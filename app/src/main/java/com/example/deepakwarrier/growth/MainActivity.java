package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static GrowthDatabase kb = new GrowthDatabase("GrowthKB.save");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, SurveyContacts.class));
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, ActivitiesRelax.class));
    }

    public void startNotifications(View view) {
        startActivity(new Intent(this, NotificationSettings.class));
    }

    public void callCrisis(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL, "tel:6147178257"));//4402608595
    }
}