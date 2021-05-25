package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;
import proyek.android.iqra.adapter.TesBacaAdapter;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.Callback;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.submission.SubmissionResponse;
import proyek.android.iqra.model.TesBacaModel;
import retrofit2.Call;
import retrofit2.Response;

public class TesBacaActivity_Ebta extends AppCompatActivity {
    ImageView button_back;
    ImageView button_back_page;
    TextView textJudul;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path;
    private int getId;

    private Callback<File> onClickCallback = new Callback<File>() {
        @Override
        public void callback(File file) {
            uploadFile(file, new View(getBaseContext()));
        }

        @Override
        public void error() {

        }
    };

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

        //getId user
        getId = Integer.parseInt(PreferencesUtility.getId(getApplicationContext()));

        //recycleview
        RecyclerView item_recycleview_tesbaca = findViewById(R.id.item_recycleview_tesbaca);
        ArrayList<TesBacaModel> dataList;
        dataList = new ArrayList<>();
        dataList.add(new TesBacaModel(
                15,
                "1",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_1", "drawable", this.getPackageName()),
                0.0,
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_1",
                getId
        ));
        dataList.add(new TesBacaModel(
                16,
                "2",
                getResources().getIdentifier("button_bg_rounded_theme", "drawable", this.getPackageName()),
                getResources().getIdentifier("jilid1_ebta_2", "drawable", this.getPackageName()),
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
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
                0.0,
                getResources().getIdentifier("button_bg_circle_disabled_line", "drawable", this.getPackageName()),
                getResources().getIdentifier("ic_baseline_mic_disabled", "drawable", this.getPackageName()),
                "jilid1_ebta_28",
                getId
        ));
        TesBacaAdapter adapter;
        adapter = new TesBacaAdapter(dataList, onClickCallback);
        RecyclerView.LayoutManager layout_manager = new LinearLayoutManager(getApplicationContext());
        item_recycleview_tesbaca.setLayoutManager(layout_manager);
        item_recycleview_tesbaca.setAdapter(adapter);
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }

    private void uploadFile(File filePath, final View v) {
        showPopupWindowUpload(v);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), filePath);
        MultipartBody.Part audio =
                MultipartBody.Part.createFormData("iqra-file-rekaman", filePath.getName(), requestBody);

        mApiService.UploadFileHandler(audio).enqueue(new retrofit2.Callback<SubmissionResponse>() {
            @Override
            public void onResponse(Call<SubmissionResponse> call, Response<SubmissionResponse> response) {
                if(response.isSuccessful()){

                } else {
                    Log.d("Upload", "gagal");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showPopupWindowUpload(final View view) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(
                view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_uploadsuara, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        int waktu_loading = 10000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                popupWindow.dismiss();
            }
        }, waktu_loading);
    }
}