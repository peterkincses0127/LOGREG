package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edittextFelhasznalo,edittextJelszo;
    Button buttonBejelentkezes,buttonRegisztracio;
    DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatokEllenorzese();

                Intent bejelentkezes = new Intent(MainActivity.this,LoggedActivity.class);
                startActivity(bejelentkezes);
                finish();
            }
        });

        buttonRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisztracio = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(regisztracio);
                finish();
            }
        });

    }
    private void adatokEllenorzese(){
        String felhnev = edittextFelhasznalo.getText().toString().trim();
        String jelszo = edittextFelhasznalo.getText().toString().trim();
        if (felhnev.isEmpty()){
            Toast.makeText(this, "Név megadása kötelező", Toast.LENGTH_SHORT).show();
            return;
        }
        if (jelszo.isEmpty()){
            Toast.makeText(this, "Jelsző megadása kötelező", Toast.LENGTH_SHORT).show();
            return;
        }

    }
    private void adatLekerdezes(){
        Cursor adatok = adatbazis.adatLekerdezes();
        if (adatok == null){
            Toast.makeText(this,"Sikertelen lekérdezés", Toast.LENGTH_SHORT).show();
            return;
        }
        if (adatok.getCount() == 0){
            Toast.makeText(this,"Még nincs adat felvéve", Toast.LENGTH_SHORT).show();
            return;
        }



    }

    private void init() {
        edittextFelhasznalo= findViewById(R.id.edittextFelhasznalo);
        edittextJelszo = findViewById(R.id.edittextJelszo);
        buttonBejelentkezes = findViewById(R.id.buttonBejelentkezes);
        buttonRegisztracio = findViewById(R.id.buttonRegisztracio);
    }

}