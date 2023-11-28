package fr.afpa.pompey.cda22045.sparadrap.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


public abstract class DAO<T> {

//    protected static Connection connect = Singleton.getInstanceDB();

    public abstract int create(T obj) throws ParseException;

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj) throws SQLException;

    public abstract T find(Long pID) throws SQLException;

    public abstract List<T> findAll() throws Exception;
}
