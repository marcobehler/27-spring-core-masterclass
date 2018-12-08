package com.marcobehler.trading;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Thanks for watching this episode! If you want to, drop me a line to info@marcobehler.com.
 */
public class TradingApplication {

    public static void main(String[] args) {
        User user = new User("Hans", "hans@forest.de");
        System.out.println("user.getEmail() = " + user.getEmail());


        System.out.println("Transaction open? " + TransactionSynchronizationManager.isActualTransactionActive());

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register(user);

        System.out.println("Transaction open? " + TransactionSynchronizationManager.isActualTransactionActive());

    }
}
