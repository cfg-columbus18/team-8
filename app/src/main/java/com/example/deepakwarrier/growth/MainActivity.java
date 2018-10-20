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

        updateImage(kb.getCurrentForestGrowth());
    }

    private void updateImage(int currentForestGrowth) {
        ImageView image = findViewById(R.id.growth);
        if(currentForestGrowth == 1){
            image.setImageResource(R.drawable.sprout);
        }else if(currentForestGrowth == 2){
            image.setImageResource(R.drawable.trees);
        }else if(currentForestGrowth >= 3){
            image.setImageResource(R.drawable.swing);
        }
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
        startActivity(new Intent(this, NotificationCenter.class));
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
        startActivity(new Intent(this, Goals.class));
    }

    public void startGrowth(View view) {
    }

    public void changeImg(View view) {
        ImageView grow = (ImageView) view;
        grow.setImageResource(R.drawable.sprout);
    }

    public void startActivitiesDetails(View view) {

        final String[] most_used_summary = {"Reading improves your ability to comprehend written material—a skill helpful in any career.",
                "If you are going through a tough time, talking to someone might sound simplistic but it really is one of the best possible things you can do.",
                "Taking a 30-minute walk a day is kind of like that proverbial apple: There's a good chance it'll keep the doctor away"};

        Intent intent = new Intent(this, RelaxationDetails.class);
        switch (view.getId()) {
            case R.id.entry1:
                intent.putExtra("most_used_summary", most_used_summary[0]);
                break;
            case R.id.entry2:
                intent.putExtra("most_used_summary", most_used_summary[2]);
                break;
        }
        startActivity(intent);
    }
}