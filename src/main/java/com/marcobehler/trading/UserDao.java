package com.marcobehler.trading;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

@Component
public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional
    public void save(User user) {
        System.out.println("Transaction open? " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("saving user to the database via datasource " + dataSource + " : user.getEmail() = " + user.getEmail());
        // TODO saving to the db here....
    }
}
