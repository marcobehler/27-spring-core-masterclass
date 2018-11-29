package com.marcobehler.trading;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class UserService {

    private MailService mailService;
    private UserDao userDao;

    public UserService(MailService mailService, UserDao userDao) {
        this.mailService = mailService;
        this.userDao = userDao;
    }

    public void register(User user) {
        mailService.sendWelcomeEmail(user);
        userDao.save(user);
        // 1. save the user to a database.persistent storage..
        // 2. send the user a welcome email
        // 3..risk /balance check....
    }


}
