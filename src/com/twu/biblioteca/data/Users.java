package com.twu.biblioteca.data;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> userList;

    public Users() {
        generateUserList();
    }

    private void generateUserList() {
        userList = new ArrayList<>();
        userList.add(new User("000-0001", "pw1"));
        userList.add(new User("000-0002", "pw2"));
        userList.get(0).setName("C1");
        userList.get(0).setEmail("test@test.com");
        userList.get(0).setPhone("18888888888");
    }

    public List<User> getUserList() {
        return userList;
    }
}
