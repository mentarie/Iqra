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
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;
import proyek.android.iqra.adapter.TesBacaAdapter;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.model.TesBacaModel;

public class TesBacaActivity extends AppCompatActivity {
    ImageView button_back;
    ImageView button_next_page;
    TextView textJudul;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path, getId;

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

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        //permission
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 111);
        }

        //getId user
        getId = PreferencesUtility.getId(getApplicationContext());

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
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_1",
                getId
                ));
        dataList.add(new TesBacaModel(
                2,
                "2",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_2", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_2",
                getId
                ));
        dataList.add(new TesBacaModel(
                3,
                "3",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_3", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_3",
                getId
                ));
        dataList.add(new TesBacaModel(
                4,
                "4",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_4", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_4",
                getId
                ));
        dataList.add(new TesBacaModel(
                5,
                "5",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_5", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_5",
                getId
                ));
        dataList.add(new TesBacaModel(
                6,
                "6",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_6", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_6",
                getId
                ));
        dataList.add(new TesBacaModel(
                7,
                "7",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_7", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_7",
                getId
                ));
        dataList.add(new TesBacaModel(
                8,
                "8",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_8", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_8",
                getId
                ));
        dataList.add(new TesBacaModel(
                9,
                "9",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_9", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_9",
                getId
                ));
        dataList.add(new TesBacaModel(
                10,
                "10",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_10", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_10",
                getId
                ));
        dataList.add(new TesBacaModel(
                11,
                "11",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_11", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_11",
                getId
                ));
        dataList.add(new TesBacaModel(
                12,
                "12",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_12", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_12",
                getId
                ));
        dataList.add(new TesBacaModel(
                13,
                "13",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_13", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_13",
                getId
                ));
        dataList.add(new TesBacaModel(
                14,
                "14",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_hal18_14", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_hal18_14",
                getId
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

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}