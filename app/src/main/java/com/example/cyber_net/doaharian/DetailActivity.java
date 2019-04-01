package com.example.cyber_net.doaharian;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.cyber_net.doaharian.key.Key.*;

public class DetailActivity extends AppCompatActivity {
    //membuat varibael untuk button dan mp3
    Button btnPlay, btnPause, btnStop;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause =  findViewById(R.id.btnPause);
        btnStop =  findViewById(R.id.btnStop);

        stateAwal();


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });


        //menerima intent dari Doa.class
        Intent myIntent = getIntent();

        //membuat variabel untuk menampung value dari Doa.class
        String judulDoa = myIntent.getStringExtra(KEY_JUDUL);
        String arabDoa = myIntent.getStringExtra(KEY_ARAB);
        String artiDoa = myIntent.getStringExtra(KEY_ARTI);

        //tampilkan value di TextView
        ((TextView) findViewById(R.id.txt_nama_doa)).setText(judulDoa);
        ((TextView) findViewById(R.id.txt_doa_arab)).setText(arabDoa);
        ((TextView) findViewById(R.id.txt_doa_arti)).setText(artiDoa);
    }

    //membuat all function
    private void stateAwal() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    //membuat fungsi play
    private void play() {
        Intent myIntent = getIntent();
        String kDoa_Nama = myIntent.getStringExtra(KEY_JUDUL);

        //mencari nama judul
        if (kDoa_Nama.equalsIgnoreCase(getResources().getString(R.string.doa_puasa))) {
            mMediaPlayer = MediaPlayer.create(DetailActivity.this, R.raw.niatpuasa);
        } else if (kDoa_Nama.equalsIgnoreCase(getResources().getString(R.string.doa_buka_puasa))) {
            mMediaPlayer = MediaPlayer.create(DetailActivity.this, R.raw.niatberbukapuasa);
        }

        //memulai menjalankan mp3
        mMediaPlayer.start();

        //cek jika sudah selesai
        mMediaPlayer.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //jalankan fungsi ini
                        stateAwal();
                    }
                });
    }

    private void releaseMp() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }

    public void pause() {
        if (mMediaPlayer.isPlaying()) {
            if (mMediaPlayer != null) {
                mMediaPlayer.pause();

            }
        } else {
            if (mMediaPlayer != null) {
                mMediaPlayer.start();

            }
        }
    }

    public void stop() {
        mMediaPlayer.stop();

        try {
            mMediaPlayer.prepare();
            mMediaPlayer.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMp();
    }
}
