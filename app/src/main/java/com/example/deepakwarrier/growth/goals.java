package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
    }

    public void addGoals(View view) {
        startActivity(new Intent(this, addnewgoal.class));
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, ContactsActivity.class));
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, Relaxation.class));
    }

    public void startNotifications(View view) {
        startActivity(new Intent(this, notification_center.class));
    }

    public void startGoals(View view) {
        startActivity(new Intent(this, goals.class));
    }

    public void startGrowth(View view) {
    }
}
