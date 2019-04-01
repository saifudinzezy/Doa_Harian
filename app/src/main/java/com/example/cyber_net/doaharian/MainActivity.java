package com.example.cyber_net.doaharian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView profilCard, doaCard, mottoCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        profilCard = findViewById(R.id.profilcard);
        doaCard = findViewById(R.id.doacard);
        mottoCard = findViewById(R.id.motocard);
        profilCard.setOnClickListener(this);
        doaCard.setOnClickListener(this);
        mottoCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profilcard:
                startActivity(new Intent(MainActivity.this, Profil.class));
                break;

            case R.id.doacard:
                startActivity(new Intent(MainActivity.this, Doa.class));
                break;
            case R.id.motocard:
                startActivity(new Intent(MainActivity.this, Moto.class));
                break;

            default:
                break;
        }
    }
}
