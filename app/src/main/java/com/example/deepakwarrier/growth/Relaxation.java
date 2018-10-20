package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Relaxation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final String[] most_used = {"Reading", "Calling Grandma", "Taking Walks"};
        final String[] most_used_summary = {"Reading improves your ability to comprehend written material—a skill helpful in any career.",
                "If you are going through a tough time, talking to someone might sound simplistic but it really is one of the best possible things you can do.",
                "Taking a 30-minute walk a day is kind of like that proverbial apple: There's a good chance it'll keep the doctor away"};
        final String[] least_used = {"Yoga", "Breathing Exercises", "Stretching", "Keeping A Journal", "Do Someone Else a Favor"};
        final String[] least_used_summary = {"Yoga is known for its ability to ease stress and promote relaxation.",
                "Breathing exercises are a good way to relax, reduce tension, and relieve stress.",
                "Participating in a regular stretching program not only helps increase your flexibility, but it can also calm your mind",
                "“Keeping a personal journal a daily in-depth analysis and evaluation of your experiences is a high-leverage activity that increases self-awareness and enhances all the endowments and the synergy among them.” — Stephen R.Covey",
                "You can improve the quality of other people's lives, and in the process of doing so you can benefit yourself as well."};

        Button most_used_button1 = findViewById(R.id.mostused1);
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

    public void startContacts(View view) {
        startActivity(new Intent(this, ContactsActivity.class));
    }

    public void startActivities(View view) {
        startActivity(new Intent(this, Relaxation.class));
    }

    public void startGoals(View view) {
        startActivity(new Intent(this, Goals.class));
    }

    public void openSettings(View view) {
        startActivity(new Intent(this, NotificationCenter.class));
    }
}
