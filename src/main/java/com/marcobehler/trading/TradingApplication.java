package com.marcobehler.trading;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Thanks for watching this episode! If you want to, drop me a line to info@marcobehler.com.
 */
public class TradingApplication {

    public static void main(String[] args) {
        User user = new User("Hans", "hans@forest.de");
        System.out.println("user.getEmail() = " + user.getEmail());


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register(user);
    }
}
