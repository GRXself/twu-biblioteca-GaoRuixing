package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class LoginManagerTest {
    LoginManager loginManager = LoginManager.getInstance();

    @Test
    public void testUserLoginWithRightIdAndPassword() {
        //give
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
        String id = "badId";
        String password = "badpz";
        //when
        boolean isLogin = loginManager.login(id, password);
        //then
        assertFalse(isLogin);
    }
}
