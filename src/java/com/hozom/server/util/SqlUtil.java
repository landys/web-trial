package com.hozom.server.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.hozom.server.util.HozomException;

/**
 * @author Tony
 * 
 */
public class SqlUtil {
    private static final Logger LOG = Logger.getLogger(SqlUtil.class);
    private static SqlUtil sqlProp;
    private Properties props;
    private static final String sqlName = "sqlHozom.properties";

    private SqlUtil() {
    }

    public static SqlUtil getInstance() throws HozomException {
        if (sqlProp == null) {
            sqlProp = new SqlUtil();
            sqlProp.props = new Properties();

            try {
                InputStream in = SqlUtil.class.getClassLoader()
                        .getResourceAsStream(sqlName);
                sqlProp.props.load(in);
            } catch (FileNotFoundException e) {
                LOG.error(e.getMessage());
                throw new HozomException(
                        "Error: Cannot find sql property file.");
            } catch (IOException e) {
                LOG.error(e.getMessage());
                throw new HozomException(
                        "Error: IO exception in reading sql property.");
            }

        }
        return sqlProp;
    }

    public String getProp(String key) {
        return props.getProperty(key);
    }

}
