package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeTest {

    private Welcome welcome = new Welcome();

    @Test
    public void testWelcomeMessageIsNotEmpty() {
        //given
        String welcomeMessage = welcome.getWelcomeMessage();
        //when
        //then
        assertTrue(!welcomeMessage.isEmpty());
    }
}
