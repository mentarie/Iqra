package proyek.android.iqra.activity.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;

public class LatihanBacaActivity_18 extends AppCompatActivity {
    TextView textJudul;
    ImageView button_back, button_before;
    LinearLayout baca_j1_h18_1, baca_j1_h18_2, baca_j1_h18_3, baca_j1_h18_4, baca_j1_h18_5, baca_j1_h18_6, baca_j1_h18_7, baca_j1_h18_8, baca_j1_h18_9, baca_j1_h18_10, baca_j1_h18_11, baca_j1_h18_12, baca_j1_h18_13, baca_j1_h18_14;
    public MediaPlayer mp;
    final Handler handler_interact=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_baca_18);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Latihan Baca");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LatihanBacaActivity_18.this, Pengantar1Activity.class);
                startActivity(back);
            }
        });

        button_before = findViewById(R.id.j1_h18_b);
        button_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent before = new Intent(LatihanBacaActivity_18.this, LatihanBacaActivity_17.class);
                startActivity(before);
            }
        });

        //1
        baca_j1_h18_1 = findViewById(R.id.baca_j1_h18_1);
        baca_j1_h18_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_1, baca_j1_h18_1);
            }
        });

        //2
        baca_j1_h18_2 = findViewById(R.id.baca_j1_h18_2);
        baca_j1_h18_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_2, baca_j1_h18_2);
            }
        });

        //3
        baca_j1_h18_3 = findViewById(R.id.baca_j1_h18_3);
        baca_j1_h18_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_3, baca_j1_h18_3);
            }
        });

        //4
        baca_j1_h18_4 = findViewById(R.id.baca_j1_h18_4);
        baca_j1_h18_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_4, baca_j1_h18_4);
            }
        });

        //5
        baca_j1_h18_5 = findViewById(R.id.baca_j1_h18_5);
        baca_j1_h18_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_5, baca_j1_h18_5);
            }
        });

        //6
        baca_j1_h18_6 = findViewById(R.id.baca_j1_h18_6);
        baca_j1_h18_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_6, baca_j1_h18_6);
            }
        });

        //7
        baca_j1_h18_7 = findViewById(R.id.baca_j1_h18_7);
        baca_j1_h18_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_7, baca_j1_h18_7);
            }
        });

        //8
        baca_j1_h18_8 = findViewById(R.id.baca_j1_h18_8);
        baca_j1_h18_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_8, baca_j1_h18_8);
            }
        });

        //9
        baca_j1_h18_9 = findViewById(R.id.baca_j1_h18_9);
        baca_j1_h18_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_9, baca_j1_h18_9);
            }
        });

        //10
        baca_j1_h18_10 = findViewById(R.id.baca_j1_h18_10);
        baca_j1_h18_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_10, baca_j1_h18_10);
            }
        });

        //11
        baca_j1_h18_11 = findViewById(R.id.baca_j1_h18_11);
        baca_j1_h18_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_11, baca_j1_h18_11);
            }
        });

        //12
        baca_j1_h18_12 = findViewById(R.id.baca_j1_h18_12);
        baca_j1_h18_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_12, baca_j1_h18_12);
            }
        });

        //13
        baca_j1_h18_13 = findViewById(R.id.baca_j1_h18_13);
        baca_j1_h18_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_13, baca_j1_h18_13);
            }
        });

        //14
        baca_j1_h18_14 = findViewById(R.id.baca_j1_h18_14);
        baca_j1_h18_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h18_14, baca_j1_h18_14);
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
}