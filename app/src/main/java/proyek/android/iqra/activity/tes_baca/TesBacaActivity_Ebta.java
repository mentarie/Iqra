package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;
import proyek.android.iqra.adapter.TesBacaAdapter;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.model.TesBacaModel;

public class TesBacaActivity_Ebta extends AppCompatActivity {
    ImageView button_back;
    ImageView button_back_page;
    TextView textJudul;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path, getId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca_ebta);

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Jilid 1 : Tes Baca");

        button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Pengantar1Activity.class));
            }
        });

        button_back_page = findViewById(R.id.j1_ebta_b);
        button_back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TesBacaActivity.class));
            }
        });

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        //recycleview
        RecyclerView item_recycleview_tesbaca = findViewById(R.id.item_recycleview_tesbaca);
        ArrayList<TesBacaModel> dataList;
        dataList = new ArrayList<>();
        dataList.add(new TesBacaModel(
                1,
                "1",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_1", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_1",
                getId
        ));
        dataList.add(new TesBacaModel(
                2,
                "2",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_2", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_2",
                getId
        ));
        dataList.add(new TesBacaModel(
                3,
                "3",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_3", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_3",
                getId
        ));
        dataList.add(new TesBacaModel(
                4,
                "4",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_4", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_4",
                getId
        ));
        dataList.add(new TesBacaModel(
                5,
                "5",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_5", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_5",
                getId
        ));
        dataList.add(new TesBacaModel(
                6,
                "6",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_6", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_6",
                getId
        ));
        dataList.add(new TesBacaModel(
                7,
                "7",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_7", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_7",
                getId
        ));
        dataList.add(new TesBacaModel(
                8,
                "8",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_8", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_8",
                getId
        ));
        dataList.add(new TesBacaModel(
                9,
                "9",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_9", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_9",
                getId
        ));
        dataList.add(new TesBacaModel(
                10,
                "10",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_10", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_10",
                getId
        ));
        dataList.add(new TesBacaModel(
                11,
                "11",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_11", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_11",
                getId
        ));
        dataList.add(new TesBacaModel(
                12,
                "12",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_12", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_12",
                getId
        ));
        dataList.add(new TesBacaModel(
                13,
                "13",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_13", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_13",
                getId
        ));
        dataList.add(new TesBacaModel(
                14,
                "14",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_14", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_14",
                getId
        ));
        dataList.add(new TesBacaModel(
                15,
                "15",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_15", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_15",
                getId
        ));
        dataList.add(new TesBacaModel(
                16,
                "16",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_16", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_16",
                getId
        ));
        dataList.add(new TesBacaModel(
                17,
                "17",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_17", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_17",
                getId
        ));
        dataList.add(new TesBacaModel(
                18,
                "18",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_18", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_18",
                getId
        ));
        dataList.add(new TesBacaModel(
                19,
                "19",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_19", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_19",
                getId
        ));
        dataList.add(new TesBacaModel(
                20,
                "20",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_20", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_20",
                getId
        ));
        dataList.add(new TesBacaModel(
                21,
                "21",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_21", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_21",
                getId
        ));
        dataList.add(new TesBacaModel(
                22,
                "22",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_22", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_22",
                getId
        ));
        dataList.add(new TesBacaModel(
                23,
                "23",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_23", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_23",
                getId
        ));
        dataList.add(new TesBacaModel(
                24,
                "24",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_24", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_24",
                getId
        ));
        dataList.add(new TesBacaModel(
                25,
                "25",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_25", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_25",
                getId
        ));
        dataList.add(new TesBacaModel(
                26,
                "26",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_26", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_26",
                getId
        ));
        dataList.add(new TesBacaModel(
                27,
                "27",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_27", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_27",
                getId
        ));
        dataList.add(new TesBacaModel(
                28,
                "28",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_28", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_rounded_disabled", "drawable", this.getPackageName()),
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_28",
                getId
        ));
        TesBacaAdapter adapter;
        adapter = new TesBacaAdapter(dataList);
        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(getApplicationContext());
        item_recycleview_tesbaca.setLayoutManager(layout_manager);
        item_recycleview_tesbaca.setAdapter(adapter);
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}