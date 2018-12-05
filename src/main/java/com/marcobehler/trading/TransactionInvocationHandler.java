package com.marcobehler.trading;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionInvocationHandler implements InvocationHandler {

    private final UserService userService;

    public TransactionInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Open up a database connection");
        Object result = method.invoke(userService, args);
        System.out.println("closing the database connection");
        return result;
    }
}
