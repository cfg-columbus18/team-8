package com.example.deepakwarrier.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

/**
 * A login screen that offers login via email/password.
 */
public class WelcomeActivity extends AppCompatActivity {
    public GrowthDatabase kb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        kb = new GrowthDatabase(new File(getFilesDir(), "GrowthKB.save"));

        int i = kb.getCurrentForestGrowth();
        Log.d("test", "Current forest growth: " + i);
        Log.d("name", "Stored name: " + kb.getUserName());
        if (kb.getUserName() != null) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void welcomeContinueOnClick(View view) {
        TextInputEditText nameInput = findViewById(R.id.name_input);
        kb.setUserName(nameInput.getText().toString());
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}