package com.example.deepakwarrier.growth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RelaxationDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String mostUsed = this.getIntent().getStringExtra("most_used_summary");

        ImageView imageView = findViewById(R.id.imageView);


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        TextView txt = (TextView)findViewById(R.id.text1);
        txt.setText(mostUsed);
        if (mostUsed == "Reading improves your ability to comprehend written material—a skill helpful in any career.") {
            imageView.setImageResource(R.mipmap.reading);
        }

        if (mostUsed == "If you are going through a tough time, talking to someone might sound simplistic but it really is one of the best possible things you can do.") {
            imageView.setImageResource(R.mipmap.phone);
        }

        if (mostUsed == "Taking a 30-minute walk a day is kind of like that proverbial apple: There's a good chance it'll keep the doctor away") {
            imageView.setImageResource(R.mipmap.walking);
        }

        if (mostUsed == "Yoga is known for its ability to ease stress and promote relaxation.") {
            imageView.setImageResource(R.mipmap.yoga);
        }

        if (mostUsed == "Breathing exercises are a good way to relax, reduce tension, and relieve stress.") {
            imageView.setImageResource(R.mipmap.breathing);
        }

        if (mostUsed == "Participating in a regular stretching program not only helps increase your flexibility, but it can also calm your mind") {
            imageView.setImageResource(R.mipmap.stretch);
        }

        if (mostUsed == "“Keeping a personal journal a daily in-depth analysis and evaluation of your experiences is a high-leverage activity that increases self-awareness and enhances all the endowments and the synergy among them.” — Stephen R.Covey") {
            imageView.setImageResource(R.mipmap.writing);
        }

        if (mostUsed == "You can improve the quality of other people's lives, and in the process of doing so you can benefit yourself as well.") {
            imageView.setImageResource(R.mipmap.yoga);
        }
    }

}
