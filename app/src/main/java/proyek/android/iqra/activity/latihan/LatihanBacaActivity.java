package proyek.android.iqra.activity.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.EditNameActivity;
import proyek.android.iqra.activity.HomeActivity;
import proyek.android.iqra.activity.Pengantar1Activity;
import proyek.android.iqra.activity.ProfileActivity;

public class LatihanBacaActivity extends AppCompatActivity {
    TextView textJudul;
    ImageView button_back;
    LinearLayout k_j1_h1, baca_j1_h1_3, baca_j1_h1_4, baca_j1_h1_5, baca_j1_h1_6, baca_j1_h1_7,
            baca_j1_h1_8, baca_j1_h1_9, baca_j1_h1_10, baca_j1_h1_11, baca_j1_h1_12, baca_j1_h1_13_a,
            baca_j1_h1_13_b, baca_j1_h1_13_c;
    ImageView baca_j1_h1_1, baca_j1_h1_2, button_next;
    public MediaPlayer mp;
    final Handler handler_interact=new Handler();

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
                stopAudio();
                onBackPressed();
            }
        });

        button_next = findViewById(R.id.j1_h1_n);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                Intent next = new Intent(LatihanBacaActivity.this, LatihanBacaActivity_2.class);
                startActivity(next);
            }
        });

        //2
        k_j1_h1 = findViewById(R.id.k_j1_h1);
        baca_j1_h1_2 = findViewById(R.id.baca_j1_h1_2);
        baca_j1_h1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                playAudio(R.raw.mp_baca_j1_h1_2, k_j1_h1);
            }
        });

        //3
        baca_j1_h1_3 = findViewById(R.id.baca_j1_h1_3);
        baca_j1_h1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_3, baca_j1_h1_3);
            }
        });

        //4
        baca_j1_h1_4 = findViewById(R.id.baca_j1_h1_4);
        baca_j1_h1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_4, baca_j1_h1_4);
            }
        });

        //5
        baca_j1_h1_5 = findViewById(R.id.baca_j1_h1_5);
        baca_j1_h1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_5, baca_j1_h1_5);
            }
        });

        //6
        baca_j1_h1_6 = findViewById(R.id.baca_j1_h1_6);
        baca_j1_h1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_6, baca_j1_h1_6);
            }
        });

        //7
        baca_j1_h1_7 = findViewById(R.id.baca_j1_h1_7);
        baca_j1_h1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_7, baca_j1_h1_7);
            }
        });

        //8
        baca_j1_h1_8 = findViewById(R.id.baca_j1_h1_8);
        baca_j1_h1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_8, baca_j1_h1_8);
            }
        });

        //9
        baca_j1_h1_9 = findViewById(R.id.baca_j1_h1_9);
        baca_j1_h1_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_9, baca_j1_h1_9);
            }
        });

        //10
        baca_j1_h1_10 = findViewById(R.id.baca_j1_h1_10);
        baca_j1_h1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_10, baca_j1_h1_10);
            }
        });

        //11
        baca_j1_h1_11 = findViewById(R.id.baca_j1_h1_11);
        baca_j1_h1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_11, baca_j1_h1_11);
            }
        });

        //12
        baca_j1_h1_12 = findViewById(R.id.baca_j1_h1_12);
        baca_j1_h1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_12, baca_j1_h1_12);
            }
        });

        //13
        baca_j1_h1_13_a = findViewById(R.id.baca_j1_h1_13_a);
        baca_j1_h1_13_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_13, baca_j1_h1_13_a);
            }
        });

        //13
        baca_j1_h1_13_b = findViewById(R.id.baca_j1_h1_13_b);
        baca_j1_h1_13_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_13, baca_j1_h1_13_b);
            }
        });

        //13
        baca_j1_h1_13_c = findViewById(R.id.baca_j1_h1_13_c);
        baca_j1_h1_13_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_13, baca_j1_h1_13_c);
            }
        });

        //1
        baca_j1_h1_1 = findViewById(R.id.baca_j1_h1_1);
        baca_j1_h1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(R.raw.mp_baca_j1_h1_1, k_j1_h1);
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
        Log.d("notif stop audio", "stopAudio: stop audio terpanggil");
        //ganti ke file lain
        if(mp != null && mp.isPlaying()){
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}
