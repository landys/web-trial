package com.hozom.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.hozom.server.util.HozomException;
import com.hozom.server.util.SqlUtil;

/**
 * Direct operate postpresql database
 * 
 * @author Tony
 * 
 */
public class BaseDao {
    private static final Logger LOG = Logger.getLogger(BaseDao.class);

    private boolean idle = true;

    private Connection conn;

    private PreparedStatement preState;

    private ResultSet rs = null;

    /**
     * Do connection to database
     * 
     * @throws HozomException
     */
    private void initConnection() throws HozomException {
        SqlUtil props = SqlUtil.getInstance();
        String driveName = props.getProp("jdbc.driver");
        String url = props.getProp("jdbc.url") + "/"
                + props.getProp("database.databasename");
        String username = props.getProp("database.username");
        String password = props.getProp("database.password");
        try {
            Class.forName(driveName);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Error: Mysql Driver not found.");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Error: Fail to get Mysql connection.");
        }
    }

    /**
     * @param sql
     * @param paras
     * @return
     * @throws HozomException
     */
    public ResultSet querySql(final String sql, final List<Object> paras)
            throws HozomException {
        prepareStatement(sql, paras);

        try {
            rs = preState.executeQuery();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Error: Execute query wrong.");
        } finally {
        }

        return rs;
    }

    /**
     * @param sql
     * @param paras
     * @throws HozomException
     */
    public void updateSql(final String sql, final List<Object> paras)
            throws HozomException {
        prepareStatement(sql, paras);

        try {
            preState.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Error: Execute update wrong.");
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new HozomException("Update error.");
        } finally {
        }
    }

    /**
     * @throws HozomException
     */
    public void closeResultSet() throws HozomException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
                throw new HozomException("Error: Close ResultSet wrong.");
            }
        }
    }

    /**
     * @throws HozomException
     */
    public void closeStatement() throws HozomException {
        if (rs != null) {
            closeResultSet();
        }
        if (preState != null) {
            try {
                preState.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
                throw new HozomException(
                        "Error: Close prepared statement wrong.");
            }
        }
    }

    /**
     * @throws HozomException
     */
    public void close() throws HozomException {
        if (preState != null) {
            closeStatement();
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
                throw new HozomException("Error: Close connection wrong.");
            }
        }
    }

    /**
     * @return
     */
    public boolean isIdle() {
        return idle;
    }

    /**
     * @param idle
     */
    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    /**
     * @param sql
     * @param paras
     * @throws HozomException
     */
    private void prepareStatement(final String sql, final List<Object> paras)
            throws HozomException {
        if (conn == null) {
            initConnection();
        }

        try {
            preState = conn.prepareStatement(sql);
            if (paras != null) {
                for (int i = 0; i < paras.size(); i++) {
                    Object para = paras.get(i);
                    int index = i + 1;
                    if (para instanceof String) {
                        preState.setString(index, (String) para);
                    } else if (para instanceof Integer) {
                        preState.setInt(index, ((Integer) para).intValue());
                    } else if (para instanceof Double) {
                        preState
                                .setDouble(index, ((Double) para).doubleValue());
                    } else if (para instanceof Float) {
                        preState.setFloat(index, ((Float) para).floatValue());
                    } else if (para instanceof Date) {
                        preState.setTimestamp(index, new Timestamp(
                                ((Date) para).getTime()));
                    } else {
                        preState.setObject(index, para);
                    }
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Error: Prepare parameters wrong.");
        }
    }
}
