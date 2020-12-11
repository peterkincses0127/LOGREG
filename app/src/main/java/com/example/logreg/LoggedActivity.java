package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedActivity extends AppCompatActivity {

    TextView textviewTeljesnev;
    Button buttonKijelentkezes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        init();

        buttonKijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent (LoggedActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();

            }
        });
    }

    private void init() {
        textviewTeljesnev = findViewById(R.id.textviewTeljesnev);
        buttonKijelentkezes = findViewById(R.id.buttonKijelentkezes);

    }
}