package com.marcobehler.trading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Service
public class UserService implements IUserService {

    @Autowired
    private MailService mailService;

    @Autowired // @Inject..@Resource
    private UserDao userDao;

    @Override
    public void register(User user) {
        mailService.sendWelcomeEmail(user);
        userDao.save(user);
        // 1. save the user to a database.persistent storage..
        // 2. send the user a welcome email
        // 3..risk /balance check....
    }

    @Override
    public void closeAccount(User user) {
        System.out.println("Closing the users account: " + user.getEmail());
    }

}
