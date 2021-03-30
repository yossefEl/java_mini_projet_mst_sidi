package com.mst.java.mini.projet.usf.elm.core.models;

import java.sql.SQLException;


/**
 * the base user interface
 * This contains the shared User methods between Client and Admin classes
 */
 public interface User {
    void create() throws SQLException, ClassNotFoundException;
    void get() throws SQLException;
    void delete() throws SQLException;
    void update() throws SQLException;
}
