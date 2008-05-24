package com.hozom.server.dao;

/**
 * @author Tony
 * 
 */
public class BaseDaoFactory {
    private static BaseDaoFactory factory = new BaseDaoFactory();

    // private BaseDAO[] baseDAOs = new BaseDAO[5];

    private BaseDaoFactory() {
    }

    public static synchronized BaseDaoFactory getInstance() {
        if (factory == null) {
            factory = new BaseDaoFactory();
        }
        return factory;
    }

    public synchronized BaseDao getBaseDao() {
        return new BaseDao();
    }
}
