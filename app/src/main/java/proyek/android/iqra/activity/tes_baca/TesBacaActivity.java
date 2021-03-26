package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;

import static android.Manifest.*;
import static java.security.AccessController.getContext;

public class TesBacaActivity extends AppCompatActivity {
    ImageView button_back;
    TextView textJudul;
    LinearLayout baca_j1_h18_1, baca_j1_h18_2, baca_j1_h18_3, baca_j1_h18_4, baca_j1_h18_5, baca_j1_h18_6, baca_j1_h18_7, baca_j1_h18_8, baca_j1_h18_9, baca_j1_h18_10, baca_j1_h18_11, baca_j1_h18_12, baca_j1_h18_13, baca_j1_h18_14;
    ImageView button_next;
    Boolean isRecording = false;

    private int PERMISSION_CODE = 1000;
    private MediaRecorder mediaRecorder;
    private String recordFile;
    private String judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Tes Baca");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        baca_j1_h18_1 = findViewById(R.id.baca_j1_h18_1);
        baca_j1_h18_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                if(checkPermissionFromDevice()){
//
//                } else {
//                    requestPermissions();
//                }
//                if (isRecording){
//                    //Stop recording
//                    stopRecording(baca_j1_h1_1);
//                    isRecording = false;
//                } else {
//                    //Start recording
//                    if(checkPermission()){
//                        judul = "baca_j1_h1_1";
//                        Log.d("sebelum start recording", judul);
//
//                        startRecording(judul, baca_j1_h1_1);
//                        isRecording = true;
//                    }
//                }
            }
        });
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
       ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        }, PERMISSION_CODE);
    }

    private void startRecording(String judul, LinearLayout ll) {
        String recordPath = this.getExternalFilesDir("/").getAbsolutePath();
        recordFile = judul.concat(".3gp");
        Log.d("start recording", recordFile);

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(recordPath + "/" + recordFile);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mediaRecorder.prepare();
        } catch (IOException e){
            e.printStackTrace();
        }

        ll.setBackgroundResource(R.drawable.button_bg_rounded_corners_line);
        mediaRecorder.start();
    }

    private void stopRecording(LinearLayout ll) {
        ll.setBackgroundResource(R.drawable.button_bg_rounded_corners);
        mediaRecorder.stop();
        mediaRecorder.reset();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}