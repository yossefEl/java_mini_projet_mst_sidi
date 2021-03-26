package com.mst.java.mini.projet.usf.elm.core.models;

import java.sql.SQLException;

abstract public class User {

    abstract public void create() throws SQLException, ClassNotFoundException;
    abstract public void get() throws SQLException;
    abstract public void delete() throws SQLException;
    abstract public void update() throws SQLException;
}
