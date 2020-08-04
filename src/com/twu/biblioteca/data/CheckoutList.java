package com.twu.biblioteca.data;

import com.twu.biblioteca.model.Checkout;

import java.util.ArrayList;
import java.util.List;

public class CheckoutList {
    private static CheckoutList instance = new CheckoutList();
    private List<Checkout> checkoutList;

    private CheckoutList() {
        checkoutList = new ArrayList<>();
    }

    public static CheckoutList getInstance() {
        return instance;
    }

    public List<Checkout> getCheckoutList() {
        return checkoutList;
    }
}
