package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.HomeActivity;
import proyek.android.iqra.activity.Pengantar1Activity;
import proyek.android.iqra.activity.SignInActivity;
import proyek.android.iqra.activity.SplashScreenActivity;
import proyek.android.iqra.adapter.TesBacaAdapter;
import proyek.android.iqra.model.TesBacaModel;

import static android.Manifest.*;
import static java.security.AccessController.getContext;

public class TesBacaActivity extends AppCompatActivity {
    ImageView button_back;
    ImageView button_next_page;
    TextView textJudul;

    private MediaRecorder mediaRecorder;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Tes Baca");

        button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Pengantar1Activity.class));
            }
        });

        button_next_page = findViewById(R.id.j1_h18_n);
        button_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TesBacaActivity_Ebta.class));
            }
        });

        //permission
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 111);
        }

        //recycleview
        RecyclerView item_recycleview_tesbaca = findViewById(R.id.item_recycleview_tesbaca);
        ArrayList<TesBacaModel> dataList;
        dataList = new ArrayList<>();
        dataList.add(new TesBacaModel(
                1,
                "1",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_1", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                2,
                "2",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_2", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                3,
                "3",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_3", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                4,
                "4",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_4", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                5,
                "5",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_5", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                6,
                "6",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_6", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                7,
                "7",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_7", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                8,
                "8",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_8", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                9,
                "9",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_9", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                10,
                "10",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_10", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                11,
                "11",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_11", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                12,
                "12",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_12", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                13,
                "13",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_12", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        dataList.add(new TesBacaModel(
                14,
                "14",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_12", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName())
                ));
        TesBacaAdapter adapter;
        adapter = new TesBacaAdapter(dataList);
        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(getApplicationContext());
        item_recycleview_tesbaca.setLayoutManager(layout_manager);
        item_recycleview_tesbaca.setAdapter(adapter);
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }

    public void recordAudio (final LinearLayout line, final ImageView icon, String file_name){
        //deklarasi path penyimpanan
        path = Environment.getExternalStorageDirectory().toString()+"/"+file_name+".3gp";

        //ganti background saat merekam
        line.setBackgroundResource(R.drawable.button_bg_circle_line_red);
        icon.setBackgroundResource(R.drawable.ic_baseline_stop);

        //start record
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(path);

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();

        //stop record
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                line.setBackgroundResource(R.drawable.button_bg_circle_disabled_line);
                icon.setBackgroundResource(R.drawable.ic_baseline_mic_disabled);
                //showPopupWindowUpload(v);
            }
        });
    }

    private void showPopupWindowUpload(final View view) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_uploadsuara, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        int waktu_loading = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showPopupWindowHasil(view);
                finish();
            }
        }, waktu_loading);
    }

    private void showPopupWindowHasil(View view) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_hasil_rekaman, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}