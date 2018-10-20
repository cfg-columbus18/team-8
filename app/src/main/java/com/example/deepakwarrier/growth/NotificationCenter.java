package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NotificationCenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_center);
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, ContactsActivity.class));
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, Relaxation.class));
    }

    public void startGoals(View view) {
        startActivity(new Intent(this, Goals.class));
    }

    public void openSettings(View view) {
        startActivity(new Intent(this, NotificationCenter.class));
    }
}
