package com.example.deepakwarrier.growth;

import android.graphics.Bitmap;

import java.util.List;

public class MyContacts {
    private String ContactName;
    private List<String> ContactNumber;
    private Bitmap ContactImage;

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public List<String> getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(List<String> contactNumber) {
        ContactNumber = contactNumber;
    }

    public Bitmap getContactImage() {
        return ContactImage;
    }

    public void setContactImage(Bitmap contactImage) {
        ContactImage = contactImage;
    }
}