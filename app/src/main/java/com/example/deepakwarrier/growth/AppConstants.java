package com.example.deepakwarrier.growth;
import android.net.Uri;
import android.provider.ContactsContract;
@SuppressWarnings("ALL")
public class AppConstants {
    public static final int PERMISSION_READ_CONTACT = 101;
    public static final int PERMISSION_CALL_PHONE = 102;
    public static final Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
    public static final String ID = ContactsContract.Contacts._ID;
    public static final String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
    public static final String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
    public static final Uri PHONE_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    public static final String PHONE_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
    public static final String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    public static final String CONTACT_NAME = "CONTACT_NAME";
    public static final String CONTACT_PHONE = "CONTACT_PHONE";
    public static final String CONTACT_IMAGE = "CONTACT_IMAGE";
}
