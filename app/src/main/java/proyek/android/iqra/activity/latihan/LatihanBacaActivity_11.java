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

public class LatihanBacaActivity_11 extends AppCompatActivity {
    TextView textJudul;
    ImageView button_back, button_next, button_before;
    LinearLayout k_j1_h11, baca_j1_h11_2, baca_j1_h11_3, baca_j1_h11_4, baca_j1_h11_5, baca_j1_h11_6, baca_j1_h11_7, baca_j1_h11_8, baca_j1_h11_9, baca_j1_h11_10, baca_j1_h11_11, baca_j1_h11_12, baca_j1_h11_13;
    public MediaPlayer mp;
    final Handler handler_interact=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_baca_11);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Latihan Baca");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LatihanBacaActivity_11.this, Pengantar1Activity.class);
                startActivity(back);
            }
        });

        button_before = findViewById(R.id.j1_h11_b);
        button_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent before = new Intent(LatihanBacaActivity_11.this, LatihanBacaActivity_10.class);
                startActivity(before);
            }
        });

        button_next = findViewById(R.id.j1_h11_n);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(LatihanBacaActivity_11.this, LatihanBacaActivity_12.class);
                startActivity(next);
            }
        });

        //1
        k_j1_h11 = findViewById(R.id.k_j1_h11);
        k_j1_h11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_1, k_j1_h11);
            }
        });

        //2
        baca_j1_h11_2 = findViewById(R.id.baca_j1_h11_2);
        baca_j1_h11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_2, baca_j1_h11_2);
            }
        });

        //3
        baca_j1_h11_3 = findViewById(R.id.baca_j1_h11_3);
        baca_j1_h11_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_3, baca_j1_h11_3);
            }
        });

        //4
        baca_j1_h11_4 = findViewById(R.id.baca_j1_h11_4);
        baca_j1_h11_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_4, baca_j1_h11_4);
            }
        });

        //5
        baca_j1_h11_5 = findViewById(R.id.baca_j1_h11_5);
        baca_j1_h11_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_5, baca_j1_h11_5);
            }
        });

        //6
        baca_j1_h11_6 = findViewById(R.id.baca_j1_h11_6);
        baca_j1_h11_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_6, baca_j1_h11_6);
            }
        });

        //7
        baca_j1_h11_7 = findViewById(R.id.baca_j1_h11_7);
        baca_j1_h11_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_7, baca_j1_h11_7);
            }
        });

        //8
        baca_j1_h11_8 = findViewById(R.id.baca_j1_h11_8);
        baca_j1_h11_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_8, baca_j1_h11_8);
            }
        });

        //9
        baca_j1_h11_9 = findViewById(R.id.baca_j1_h11_9);
        baca_j1_h11_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_9, baca_j1_h11_9);
            }
        });

        //10
        baca_j1_h11_10 = findViewById(R.id.baca_j1_h11_10);
        baca_j1_h11_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_10, baca_j1_h11_10);
            }
        });

        //11
        baca_j1_h11_11 = findViewById(R.id.baca_j1_h11_11);
        baca_j1_h11_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_11, baca_j1_h11_11);
            }
        });

        //12
        baca_j1_h11_12 = findViewById(R.id.baca_j1_h11_12);
        baca_j1_h11_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_12, baca_j1_h11_12);
            }
        });

        //13
        baca_j1_h11_13 = findViewById(R.id.baca_j1_h11_13);
        baca_j1_h11_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h11_13, baca_j1_h11_13);
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
}