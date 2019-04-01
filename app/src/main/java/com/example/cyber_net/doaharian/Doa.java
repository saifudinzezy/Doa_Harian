package com.example.cyber_net.doaharian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import static com.example.cyber_net.doaharian.key.Key.*;


public class Doa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);
    }

    public void puasa(View view) {
        Intent myIntent = new Intent(Doa.this, DetailActivity.class);
        myIntent.putExtra(KEY_JUDUL, getResources().getString(R.string.doa_puasa));
        myIntent.putExtra(KEY_ARAB, getResources().getString(R.string.doa_puasa_arab));
        myIntent.putExtra(KEY_ARTI, getResources().getString(R.string.doa_puasa_arti));
        startActivity(myIntent);
    }

    public void bukaPuasa(View view) {
        Intent myIntent = new Intent(Doa.this, DetailActivity.class);
        myIntent.putExtra(KEY_JUDUL, getResources().getString(R.string.doa_buka_puasa));
        myIntent.putExtra(KEY_ARAB, getResources().getString(R.string.doa_buka_puasa_arab));
        myIntent.putExtra(KEY_ARTI, getResources().getString(R.string.doa_buka_puasa_arti));
        startActivity(myIntent);
    }
}
