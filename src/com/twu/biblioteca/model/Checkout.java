package com.twu.biblioteca.model;

public class Checkout {
    private String id;
    private String type;
    private Object checkOutObject;
    private String userId;
    private boolean isReturned;

    public Checkout(String id, String type, Object checkOutObject, String userId) {
        this.id = id;
        this.type = type;
        this.checkOutObject = checkOutObject;
        this.userId = userId;
        isReturned = false;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Object getCheckOutObject() {
        return checkOutObject;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
