package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public GrowthDatabase kb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kb = new GrowthDatabase(this.getFilesDir());
        TextView welcome = findViewById(R.id.welcome_message);
        String name = welcome.getText() + " ";// + kb.getUserName() + "!";
        welcome.setText(name);
    }

    public void startContacts(View view) {
        startActivity(new Intent(this, ContactsActivity.class));
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

    public void startGoals(View view) {
    }

    public void startGrowth(View view) {
    }
}