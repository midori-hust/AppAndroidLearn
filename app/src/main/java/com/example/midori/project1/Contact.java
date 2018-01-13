package com.example.midori.project1;

/**
 * Created by midori on 2018/01/11.
 */

public class Contact {
    private String ContactName;
    private String ContactNumber;
    private int ContactColor;

    public Contact(String ContactName, String ContactNumber, int ContactColor) {
        this.ContactName = ContactName;
        this.ContactNumber = ContactNumber;
        this.ContactColor = ContactColor;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public int getContactColor() {
        return ContactColor;
    }

    public void setContactColor(int contactColor) {
        ContactColor = contactColor;
    }
}
