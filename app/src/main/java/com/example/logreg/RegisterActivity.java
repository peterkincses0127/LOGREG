package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edittextRegFelhasznalo,edittextRegJelszo,edittextRegTeljesnev, edittextRegEmail;
    Button buttonRegVissza, buttonRegRegisztracio;
    DBHelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        buttonRegVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

        buttonRegRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatokEllenorzese();



            }
        });
    }
    private void adatokEllenorzese(){
        String etregregFelh = edittextRegFelhasznalo.getText().toString().trim();
        String etregJelszo = edittextRegJelszo.getText().toString().trim();
        String etregTeljesnev = edittextRegTeljesnev.getText().toString().trim();
        String etEmail = edittextRegEmail.getText().toString().trim();

        if (etregJelszo.isEmpty()){
            Toast.makeText(this, "Jelszó megadása kötelező", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etregregFelh.isEmpty()){
            Toast.makeText(this, "Felhasználónév megadása kötelező", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etregTeljesnev.isEmpty()){
            Toast.makeText(this, "Név megadása kötelező", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etEmail.isEmpty()){
            Toast.makeText(this, "Email megadása kötelező", Toast.LENGTH_SHORT).show();
            return;

        }

       if(adatbazis.adatrogzites(etregregFelh,etregJelszo,etregTeljesnev,etEmail)){
           Toast.makeText(this, "Sikeres adatrögzités", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, "Siketelen adatrögzités", Toast.LENGTH_SHORT).show();

       }

    }
    private void init() {
        edittextRegFelhasznalo = findViewById(R.id.edittextRegFelhasznalo);
        edittextRegJelszo = findViewById(R.id.edittextRegJelszo);
        edittextRegTeljesnev = findViewById(R.id.edittextRegTeljesnev);
        edittextRegEmail = findViewById(R.id.edittextRegEmail);
        buttonRegVissza = findViewById(R.id.buttonRegVissza);
        buttonRegRegisztracio= findViewById(R.id.buttonRegRegisztracio);
        adatbazis = new DBHelper(RegisterActivity.this);



    }
}