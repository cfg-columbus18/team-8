package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class notification_center extends AppCompatActivity {

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

    public void startNotifications(View view) {
//        startActivity(new Intent(this, Relaxation.class));
    }

    public void startGoals(View view) {
    }

    public void startGrowth(View view) {
    }
}
