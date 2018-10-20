package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Relaxation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String[] most_used = {"Jumping", "Skipping", "Running"};
        final String[] most_used_summary = {"JUMPING SUMMARY", "SKIPPING SUMMARY", "RUNNING SUMMARY"};
        final String[] least_used = {"Sleeping", "Napping", "Resting", "Eating", "Frolicking"};
        final String[] least_used_summary = {"SLEEPING SUMMARY", "NAPPING SUMMARY", "RESTING SUMMARY", "EATING SUMMARY", "FROLICKING SUMMARY"};

        Button most_used_button1 = (Button) findViewById(R.id.mostused1);
        most_used_button1.setText(most_used[0]);

        most_used_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent most_used_summary_intent = new Intent(Relaxation.this, RelaxationDetails.class);
                most_used_summary_intent.putExtra("most_used_summary", most_used_summary[0]);
                startActivity(most_used_summary_intent);
            }
        });

        Button most_used_button2 = (Button) findViewById(R.id.mostused2);
        most_used_button2.setText(most_used[1]);

        most_used_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent most_used_summary_intent = new Intent(Relaxation.this, RelaxationDetails.class);
                most_used_summary_intent.putExtra("most_used_summary", most_used_summary[1]);
                startActivity(most_used_summary_intent);
            }
        });

        Button most_used_button3 = (Button) findViewById(R.id.mostused3);
        most_used_button3.setText(most_used[2]);

        most_used_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent most_used_summary_intent = new Intent(Relaxation.this, RelaxationDetails.class);
                most_used_summary_intent.putExtra("most_used_summary", most_used_summary[2]);
                startActivity(most_used_summary_intent);
            }
        });

        Button least_used_button1 = (Button) findViewById(R.id.leastused1);
        least_used_button1.setText(least_used[0]);

        least_used_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxation.this, RelaxationDetails.class);
                intent.putExtra("most_used_summary", least_used_summary[0]);
                startActivity(intent);
            }
        });

        Button least_used_button2 = (Button) findViewById(R.id.leastused2);
        least_used_button2.setText(least_used[1]);

        least_used_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxation.this, RelaxationDetails.class);
                intent.putExtra("most_used_summary", least_used_summary[1]);
                startActivity(intent);
            }
        });

        Button least_used_button3 = (Button) findViewById(R.id.leastused3);
        least_used_button3.setText(least_used[2]);

        least_used_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxation.this, RelaxationDetails.class);
                intent.putExtra("most_used_summary", least_used_summary[2]);
                startActivity(intent);
            }
        });

        Button least_used_button4 = (Button) findViewById(R.id.leastused4);
        least_used_button4.setText(least_used[3]);

        least_used_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxation.this, RelaxationDetails.class);
                intent.putExtra("most_used_summary", least_used_summary[3]);
                startActivity(intent);
            }
        });

        Button least_used_button5 = (Button) findViewById(R.id.leastused5);
        least_used_button5.setText(least_used[4]);

        least_used_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxation.this, RelaxationDetails.class);
                intent.putExtra("most_used_summary", least_used_summary[4]);
                startActivity(intent);
            }
        });

    }

}
