package proyek.android.iqra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LatihanBacaActivity extends AppCompatActivity {
    TextView textJudul;
    ImageView button_back;
    ImageView baca_j1_h1_1, baca_j1_h1_2, baca_j1_h1_3, baca_j1_h1_4, baca_j1_h1_5, baca_j1_h1_6, baca_j1_h1_7, baca_j1_h1_8, baca_j1_h1_9, baca_j1_h1_10, baca_j1_h1_11, baca_j1_h1_12, baca_j1_h1_13_a, baca_j1_h1_13_b, baca_j1_h1_13_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_baca);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Latihan Baca");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Pengantar1Activity.class));
                finish();
            }
        });


        baca_j1_h1_2 = findViewById(R.id.baca_j1_h1_2);
        final MediaPlayer mp_baca_j1_h1_2 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_2);
        baca_j1_h1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_2.start();
            }
        });
        baca_j1_h1_3 = findViewById(R.id.baca_j1_h1_3);
        final MediaPlayer mp_baca_j1_h1_3 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_3);
        baca_j1_h1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_3.start();
            }
        });
        baca_j1_h1_4 = findViewById(R.id.baca_j1_h1_4);
        final MediaPlayer mp_baca_j1_h1_4 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_4);
        baca_j1_h1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_4.start();
            }
        });
        baca_j1_h1_5 = findViewById(R.id.baca_j1_h1_5);
        final MediaPlayer mp_baca_j1_h1_5 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_5);
        baca_j1_h1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_5.start();
            }
        });
        baca_j1_h1_6 = findViewById(R.id.baca_j1_h1_6);
        final MediaPlayer mp_baca_j1_h1_6 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_6);
        baca_j1_h1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_6.start();
            }
        });
        baca_j1_h1_7 = findViewById(R.id.baca_j1_h1_7);
        final MediaPlayer mp_baca_j1_h1_7 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_7);
        baca_j1_h1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_7.start();
            }
        });
        baca_j1_h1_8 = findViewById(R.id.baca_j1_h1_8);
        final MediaPlayer mp_baca_j1_h1_8 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_8);
        baca_j1_h1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_8.start();
            }
        });
        baca_j1_h1_9 = findViewById(R.id.baca_j1_h1_9);
        final MediaPlayer mp_baca_j1_h1_9 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_9);
        baca_j1_h1_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_9.start();
            }
        });
        baca_j1_h1_10 = findViewById(R.id.baca_j1_h1_10);
        final MediaPlayer mp_baca_j1_h1_10 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_10);
        baca_j1_h1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_10.start();
            }
        });
        baca_j1_h1_11 = findViewById(R.id.baca_j1_h1_11);
        final MediaPlayer mp_baca_j1_h1_11 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_11);
        baca_j1_h1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_11.start();
            }
        });
        baca_j1_h1_12 = findViewById(R.id.baca_j1_h1_12);
        final MediaPlayer mp_baca_j1_h1_12 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_12);
        baca_j1_h1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_12.start();
            }
        });
        baca_j1_h1_13_a = findViewById(R.id.baca_j1_h1_13_a);
        final MediaPlayer mp_baca_j1_h1_13_a = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_13);
        baca_j1_h1_13_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_13_a.start();
            }
        });
        baca_j1_h1_13_b = findViewById(R.id.baca_j1_h1_13_b);
        final MediaPlayer mp_baca_j1_h1_13_b = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_13);
        baca_j1_h1_13_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_13_b.start();
            }
        });
        baca_j1_h1_13_c = findViewById(R.id.baca_j1_h1_13_c);
        final MediaPlayer mp_baca_j1_h1_13_c = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_13);
        baca_j1_h1_13_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_13_c.start();
            }
        });
        baca_j1_h1_1 = findViewById(R.id.baca_j1_h1_1);
        final MediaPlayer mp_baca_j1_h1_1 = MediaPlayer.create(this, R.raw.mp_baca_j1_h1_1);
        baca_j1_h1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_baca_j1_h1_1.start();
            }
        });
    }
}