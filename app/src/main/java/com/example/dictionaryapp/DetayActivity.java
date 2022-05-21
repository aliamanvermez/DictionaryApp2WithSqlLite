package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    private TextView textViewIngilizce,textViewTurkce;
    private Kelimeler kelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewIngilizce = findViewById(R.id.textViewIngilizce);
        textViewTurkce = findViewById(R.id.textViewTurkce);

        kelime = (Kelimeler) getIntent().getSerializableExtra("nesne");

        textViewTurkce.setText(kelime.getTurkce());
        textViewIngilizce.setText(kelime.getIngilizce());


    }
}