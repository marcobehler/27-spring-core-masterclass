package com.marcobehler.trading;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void closeAccount() {

        UserService userService = new UserService();

        IUserService proxiedUserService = (IUserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                new Class[]{IUserService.class},
                new TransactionInvocationHandler(userService));
        // cglib..proxies...


        proxiedUserService.closeAccount(new User("franz", "franz@germany.de"));
    }
}