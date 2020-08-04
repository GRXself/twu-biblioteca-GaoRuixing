package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class LoginManagerTest {

    @Test
    public void testUserLoginWithRightIdAndPassword() {
        //give
        LoginManager loginManager = new LoginManager();
        String id = "000-0001";
        String password = "pw1";
        //when
        boolean isLogin = loginManager.login(id, password);
        //then
        assertTrue(isLogin);
    }

    @Test
    public void testUserLoginWithRightIdAndBadPassword() {
        //give
        LoginManager loginManager = new LoginManager();
        String id = "000-0001";
        String password = "badpz";
        //when
        boolean isLogin = loginManager.login(id, password);
        //then
        assertFalse(isLogin);
    }

    @Test
    public void testUserLoginWithBadIdAndRightPassword() {
        //give
        LoginManager loginManager = new LoginManager();
        String id = "badId";
        String password = "pw1";
        //when
        boolean isLogin = loginManager.login(id, password);
        //then
        assertFalse(isLogin);
    }

    @Test
    public void testUserLoginWithBadIdAndPassword() {
        //give
        LoginManager loginManager = new LoginManager();
        String id = "badId";
        String password = "badpz";
        //when
        boolean isLogin = loginManager.login(id, password);
        //then
        assertFalse(isLogin);
    }
}
