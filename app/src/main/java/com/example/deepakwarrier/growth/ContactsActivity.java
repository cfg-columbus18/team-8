package com.example.deepakwarrier.growth;


import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.deepakwarrier.growth.AppConstants.CONTACT_IMAGE;
import static com.example.deepakwarrier.growth.AppConstants.CONTACT_NAME;
import static com.example.deepakwarrier.growth.AppConstants.CONTACT_PHONE;
import static com.example.deepakwarrier.growth.AppConstants.CONTENT_URI;
import static com.example.deepakwarrier.growth.AppConstants.DISPLAY_NAME;
import static com.example.deepakwarrier.growth.AppConstants.HAS_PHONE_NUMBER;
import static com.example.deepakwarrier.growth.AppConstants.ID;
import static com.example.deepakwarrier.growth.AppConstants.NUMBER;
import static com.example.deepakwarrier.growth.AppConstants.PERMISSION_CALL_PHONE;
import static com.example.deepakwarrier.growth.AppConstants.PERMISSION_READ_CONTACT;
import static com.example.deepakwarrier.growth.AppConstants.PHONE_ID;
import static com.example.deepakwarrier.growth.AppConstants.PHONE_URI;

public class ContactsActivity extends AppCompatActivity implements MyClickListener {
    private ContactsAdapter adapter;
    private List<MyContacts> myContacts = new ArrayList<>();
    private MyClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new ContactsAdapter(myContacts,listener);
        recyclerView.setAdapter(adapter);

        checkPermission();

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getLayoutPosition();
                if (direction == ItemTouchHelper.LEFT) {
                    MyContacts viewInfo = (MyContacts) viewHolder.itemView.getTag();
                    String name = viewInfo.getContactName();
                    String phone = viewInfo.getContactName();
                    String imageStr = viewInfo.getContactName();
                    Intent intent = new Intent(ContactsActivity.this,ViewContactActivity.class);
                    intent.putExtra(CONTACT_NAME,name);
                    intent.putExtra(CONTACT_PHONE,phone);
                    intent.putExtra(CONTACT_IMAGE,imageStr);
                    startActivity(intent);
                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void getContactInfo(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(CONTENT_URI,null,null,null,DISPLAY_NAME);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String CONTACT_ID = cursor.getString(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));

                int hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(HAS_PHONE_NUMBER));
                MyContacts contacts = new MyContacts();
                if (hasPhoneNumber > 0) {
                    contacts.setContactName(name);

                    Cursor phoneCursor = contentResolver.query(PHONE_URI, new String[]{NUMBER}, PHONE_ID + " = ?", new String[]{CONTACT_ID}, null);
                    List<String> contactList = new ArrayList<>();
                    assert phoneCursor != null;
                    phoneCursor.moveToFirst();
                    while (!phoneCursor.isAfterLast()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER)).replace(" ", "");
                        contactList.add(phoneNumber);
                        phoneCursor.moveToNext();
                    }
                    contacts.setContactNumber(contactList);
                    myContacts.add(contacts);
                    phoneCursor.close();
                }

                InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(CONTENT_URI,Long.valueOf(CONTACT_ID)));
                if (inputStream != null) {
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    contacts.setContactImage(bitmap);
                }else {
                    contacts.setContactImage(VectorDrawableToBitmap(R.drawable.ic_person));
                }
            }
            adapter.notifyDataSetChanged();
            cursor.close();
        }
    }

    private Bitmap VectorDrawableToBitmap(int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(this,drawableId);
        Bitmap bitmap = null;
        if (drawable != null) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
            drawable.draw(canvas);
        }
        return bitmap;
    }

    private void checkPermission() {
        boolean contactReadPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED;
        boolean callPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
        if (contactReadPermission && callPhonePermission) {
            getContactInfo();
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},PERMISSION_READ_CONTACT);
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CALL_PHONE);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
        if (requestCode == PERMISSION_READ_CONTACT && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getContactInfo();
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "onItemClick " + position, Toast.LENGTH_SHORT).show();
        MyContacts contacts = (MyContacts) view.getTag();
        String phone = String.format("tel: %s",contacts.getContactNumber().get(0));
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phone));
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(callIntent);
        }else {
            Toast.makeText(this,"Can't Call",Toast.LENGTH_SHORT).show();
        }
    }
}