package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
    }

    public void addGoals(View view) {
        startActivity(new Intent(this, AddNewGoal.class));
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, ContactsActivity.class));
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, Relaxation.class));
    }

    public void startNotifications(View view) {
        startActivity(new Intent(this, NotificationCenter.class));
    }

    public void startGoals(View view) {
        startActivity(new Intent(this, Goals.class));
    }

    public void startGrowth(View view) {
    }
}
