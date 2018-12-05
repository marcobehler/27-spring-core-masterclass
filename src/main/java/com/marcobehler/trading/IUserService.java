package com.marcobehler.trading;

public interface IUserService {

    void register(User user);

    void closeAccount(User user);
}
