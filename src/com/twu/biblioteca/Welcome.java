package com.twu.biblioteca;

public class Welcome {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public String getWelcomeMessage(){
        return welcomeMessage;
    }

    public void showWelcomeMessage(){
        System.out.println(getWelcomeMessage());
    }
}
