package proyek.android.iqra.activity.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;

public class LatihanBacaActivity_3 extends AppCompatActivity {
    TextView textJudul;
    ImageView button_back, button_next, button_before;
    LinearLayout k_j1_h3, baca_j1_h3_2, baca_j1_h3_3, baca_j1_h3_4, baca_j1_h3_5, baca_j1_h3_6, baca_j1_h3_7, baca_j1_h3_8, baca_j1_h3_9, baca_j1_h3_10, baca_j1_h3_11, baca_j1_h3_12;
    public MediaPlayer mp;
    final Handler handler_interact=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_baca_3);
        
        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Latihan Baca");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                Intent back = new Intent(LatihanBacaActivity_3.this, Pengantar1Activity.class);
                startActivity(back);
            }
        });

        button_before = findViewById(R.id.j1_h3_b);
        button_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                Intent before = new Intent(LatihanBacaActivity_3.this, LatihanBacaActivity_2.class);
                startActivity(before);
            }
        });

        button_next = findViewById(R.id.j1_h3_n);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                Intent next = new Intent(LatihanBacaActivity_3.this, LatihanBacaActivity_4.class);
                startActivity(next);
            }
        });

        //1
        k_j1_h3 = findViewById(R.id.k_j1_h3);
        k_j1_h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_1, k_j1_h3);
            }
        });

        //2
        baca_j1_h3_2 = findViewById(R.id.baca_j1_h3_2);
        baca_j1_h3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_2, baca_j1_h3_2);
            }
        });

        //3
        baca_j1_h3_3 = findViewById(R.id.baca_j1_h3_3);
        baca_j1_h3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_3, baca_j1_h3_3);
            }
        });

        //4
        baca_j1_h3_4 = findViewById(R.id.baca_j1_h3_4);
        baca_j1_h3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_4, baca_j1_h3_4);
            }
        });

        //5
        baca_j1_h3_5 = findViewById(R.id.baca_j1_h3_5);
        baca_j1_h3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_5, baca_j1_h3_5);
            }
        });

        //6
        baca_j1_h3_6 = findViewById(R.id.baca_j1_h3_6);
        baca_j1_h3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_6, baca_j1_h3_6);
            }
        });

        //7
        baca_j1_h3_7 = findViewById(R.id.baca_j1_h3_7);
        baca_j1_h3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_7, baca_j1_h3_7);
            }
        });

        //8
        baca_j1_h3_8 = findViewById(R.id.baca_j1_h3_8);
        baca_j1_h3_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_8, baca_j1_h3_8);
            }
        });

        //9
        baca_j1_h3_9 = findViewById(R.id.baca_j1_h3_9);
        baca_j1_h3_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_9, baca_j1_h3_9);
            }
        });

        //10
        baca_j1_h3_10 = findViewById(R.id.baca_j1_h3_10);
        baca_j1_h3_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_10, baca_j1_h3_10);
            }
        });

        //11
        baca_j1_h3_11 = findViewById(R.id.baca_j1_h3_11);
        baca_j1_h3_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_11, baca_j1_h3_11);
            }
        });

        //12
        baca_j1_h3_12 = findViewById(R.id.baca_j1_h3_12);
        baca_j1_h3_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h3_12, baca_j1_h3_12);
            }
        });

    }

    public void playAudio(int audioId, final LinearLayout ll)
    {
        //ganti ke file lain
        if(mp != null && mp.isPlaying()){
            mp.stop();
            mp.release();
            mp = null;
        }

        //play audio
        mp = MediaPlayer.create(this, audioId);
        ll.setBackgroundResource(R.drawable.button_bg_rounded_corners_line);
        mp.start();

        //creating timer
        Timer timer_interact=new Timer();
        timer_interact.schedule(new TimerTask() {
            @Override
            public void run() {
                //creating runnable
                final Runnable runnable_interact = new Runnable() {
                    public void run() {
                        ll.setBackgroundResource(R.drawable.button_bg_rounded_corners);
                    }
                };
                handler_interact.post(runnable_interact); }
        }, 3000);
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }

    public void stopAudio(){
        Log.d("Mentarie", "stopAudio: stop audio terpanggil");
        //ganti ke file lain
        if(mp != null && mp.isPlaying()){
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onDestroy() {
        stopAudio();
        super.onDestroy();
    }
}