package com.twu.biblioteca;

import com.twu.biblioteca.data.Books;
import com.twu.biblioteca.data.CheckoutList;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Checkout;

public class CheckoutManager {
    private static CheckoutManager instance = new CheckoutManager();
    private CheckoutList checkoutList = CheckoutList.getInstance();
    private int checkoutId = 1;

    private CheckoutManager() {
    }

    public static CheckoutManager getInstance() {
        return instance;
    }

    public void showCheckout() {
        System.out.println("Checkout List:");
        checkoutList.getCheckoutList().forEach(this::checkOutConsoleLinePrinter);
    }

    public void checkOutConsoleLinePrinter(Checkout checkout) {
        System.out.print(checkout.getId());
        System.out.print("   |");

        System.out.print(checkout.getType());
        StringBuilder typeWhiteSpace = new StringBuilder();
        for (int i = 5 - checkout.getType().length() + 2; i > 0; i--) {
            typeWhiteSpace.append(" ");
        }
        System.out.print(typeWhiteSpace);
        System.out.print("|");

        Object checkoutOjb = checkout.getCheckOutObject();
        if (checkoutOjb instanceof Book) {
            Book book = (Book) checkoutOjb;
            System.out.print(book.getBookName());
            StringBuilder nameWhiteSpace = new StringBuilder();
            Books books = new Books();
            for (int i = books.getMaxBookNameCharacterCount() - book.getBookName().length() + 4; i > 0; i--) {
                nameWhiteSpace.append(" ");
            }
            System.out.print(nameWhiteSpace);
            System.out.print("|");
        }
        else {
            System.out.print("Movie not supported now!   |");
        }

        System.out.print(checkout.getUserId());
        System.out.print("  |");

        System.out.print(checkout.isReturned());
    }

    public void checkoutBook(Book book, String userId) {
        checkoutList.getCheckoutList().add(new Checkout(Integer.toString(checkoutId), "Book", book, userId));
        checkoutId++;
    }

    public void returnBook(Book book, String userId) {
        checkoutList.getCheckoutList().forEach(checkout -> {
            if (checkout.getCheckOutObject().equals(book) && checkout.getUserId().equals(userId))
                checkout.setReturned(true);
        });
    }
}
