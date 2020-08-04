package com.twu.biblioteca.model;

import com.twu.biblioteca.data.Users;

public class LoginManager {
    private User currentUser;
    private Users users;

    public LoginManager() {
        users = new Users();
    }

    public boolean login(String id, String password) {
        return isRightIdPassword(id, password);
    }

    public boolean isRightIdPassword(String id, String password) {
        return users.getUserList().stream().anyMatch(user -> {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            };
            return false;
        });
    }
}
