package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
// import android.support.v7.app.ActionBarActivity;
// import android.view.Menu;
public class MainActivity extends AppCompatActivity {

    // public static GrowthDatabase kb = new GrowthDatabase("GrowthKB.save");
   //  ActionBar actionbar = getActionBar();
   //  actionBar.hide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, MyContacts.class));
    }

    public void startActivities(View view) {
//        startActivity(new Intent(this, .class));
    }

    public void startNotifications(View view) {
//        startActivity(new Intent(this, NotificationSettings.class));
    }

    public void callCrisis(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:6147178257")));//4402608595
    }

    public void getRating(View view) {
        int id = view.getId();
        switch (id) {
            //TODO: The Logic for managing the ratings
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}