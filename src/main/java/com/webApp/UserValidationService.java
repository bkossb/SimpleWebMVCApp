package com.webApp;

public class UserValidationService {
    public boolean isUserValid(String user, String password) {
        if (user.equals("bartek") && password.equals("123qwe"))
            return true;

        return false;
    }
}
