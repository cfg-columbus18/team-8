package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class RelaxationDetails extends AppCompatActivity {

    GrowthDatabase kb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String mostUsed = this.getIntent().getStringExtra("most_used_summary");

        ImageView imageView = findViewById(R.id.imageView);

        kb = new GrowthDatabase(new File(getFilesDir(), "GrowthKB.save"));

        

        TextView txt = (TextView) findViewById(R.id.text1);
        txt.setText(mostUsed);
        if (mostUsed.equals("Reading improves your ability to comprehend written material—a skill helpful in any career.")) {
            imageView.setImageResource(R.mipmap.reading);
        }

        if (mostUsed.equals("If you are going through a tough time, talking to someone might sound simplistic but it really is one of the best possible things you can do.")) {
            imageView.setImageResource(R.mipmap.phone);
        }

        if (mostUsed.equals("Taking a 30-minute walk a day is kind of like that proverbial apple: There's a good chance it'll keep the doctor away")) {
            imageView.setImageResource(R.mipmap.walkin);
        }

        if (mostUsed.equals("Yoga is known for its ability to ease stress and promote relaxation.")) {
            imageView.setImageResource(R.mipmap.yoga);
        }

        if (mostUsed.equals("Breathing exercises are a good way to relax, reduce tension, and relieve stress.")) {
            imageView.setImageResource(R.mipmap.breathing);
        }

        if (mostUsed.equals("Participating in a regular stretching program not only helps increase your flexibility, but it can also calm your mind")) {
            imageView.setImageResource(R.mipmap.stretchingg);
        }

        if (mostUsed.equals("“Keeping a personal journal a daily in-depth analysis and evaluation of your experiences is a high-leverage activity that increases self-awareness and enhances all the endowments and the synergy among them.” — Stephen R.Covey")) {
            imageView.setImageResource(R.mipmap.writing);
        }

        if (mostUsed.equals("You can improve the quality of other people's lives, and in the process of doing so you can benefit yourself as well.")) {
            imageView.setImageResource(R.mipmap.yoga);
        }
    }

    public void openMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void incrementAndOpen(View view) {
        kb.increaseActivityPoints(1);
        openMain(view);
    }
}
