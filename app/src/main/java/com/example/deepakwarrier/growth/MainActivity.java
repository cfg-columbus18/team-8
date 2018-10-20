package com.example.deepakwarrier.growth;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public GrowthDatabase kb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kb = new GrowthDatabase(new File(getFilesDir(), "GrowthKB.save"));
        TextView welcome = findViewById(R.id.welcome_message);
        String name = welcome.getText() + " " + kb.getUserName() + "!";
        welcome.setText(name);
        findViewById(R.id.crisis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhone();
            }
        });

    }

    public void dialPhone() {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:6103333244"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
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

    public void changeImg(View view) {
        ImageView grow = (ImageView) view;
        grow.setImageResource(R.drawable.sprout);
    }
}