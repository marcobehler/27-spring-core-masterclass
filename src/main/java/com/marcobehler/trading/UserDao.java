package com.marcobehler.trading;

import javax.sql.DataSource;

public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(User user) {
        System.out.println("saving user to the database via datasource " + dataSource + " : user.getEmail() = " + user.getEmail());
        // TODO saving to the db here....
    }
}
