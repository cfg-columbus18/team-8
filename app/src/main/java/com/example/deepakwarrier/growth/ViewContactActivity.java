package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.deepakwarrier.growth.AppConstants.CONTACT_IMAGE;
import static com.example.deepakwarrier.growth.AppConstants.CONTACT_NAME;
import static com.example.deepakwarrier.growth.AppConstants.CONTACT_PHONE;

public class ViewContactActivity extends AppCompatActivity {
    private String nameStr,phoneStr,imageStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        loadContactInfo();
        Intent intent = getIntent();
        nameStr = intent.getStringExtra(CONTACT_NAME);
        phoneStr = intent.getStringExtra(CONTACT_PHONE);
        imageStr = intent.getStringExtra(CONTACT_IMAGE);
    }

    private void loadContactInfo() {
        TextView name = findViewById(R.id.view_contact_name);
        name.setText(nameStr);

        TextView phone = findViewById(R.id.view_contact_phone);
        phone.setText(phoneStr);

        ImageView imageView = findViewById(R.id.view_contact_image);
        Glide.with(getApplicationContext())
                .load(imageStr)
                .into(imageView);
    }
}