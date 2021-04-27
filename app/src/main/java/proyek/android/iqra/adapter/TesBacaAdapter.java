package proyek.android.iqra.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import proyek.android.iqra.R;
import proyek.android.iqra.activity.SignInActivity;
import proyek.android.iqra.activity.tes_baca.TesBacaActivity;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.submission.SubmissionResponse;
import proyek.android.iqra.model.TesBacaModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TesBacaAdapter extends RecyclerView.Adapter<TesBacaAdapter.ViewHolder> {
    private ArrayList<TesBacaModel> dataList;
    TesBacaActivity tesBacaActivity = new TesBacaActivity();
    String file_name, userId, submissionId;
    LinearLayout rekamLine;
    ImageView rekamIcon;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path, getId;
    private double score;

    public TesBacaAdapter(ArrayList<TesBacaModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_tesbaca, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TesBacaModel model = dataList.get(position);
        holder.Id=model.getId();
        holder.number.setText(model.getNumber());
        holder.numberColor.setBackgroundResource(model.getNumberColor());
        holder.imageSource.setImageResource(model.getImageSource());
        holder.rekamHasil.setBackgroundResource(model.getRekamHasil());
        holder.rekamLine.setBackgroundResource(model.getRekamLine());
        holder.rekamIcon.setBackgroundResource(model.getRekamIcon());
        holder.bacaanId=model.getBacaanId();
        holder.userId=model.getUserId();

        //set onclick rekam
        holder.rekamLine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //parsing
                userId = holder.userId;
                file_name = String.valueOf(holder.bacaanId);
                submissionId = userId+"-"+file_name;
                rekamLine = holder.rekamLine;
                rekamIcon = holder.rekamIcon;

                holder.rekamIcon.setImageResource(android.R.color.transparent);
                recordAudio(rekamLine,rekamIcon, submissionId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder  extends RecyclerView.ViewHolder  {
        int Id;
        String bacaanId, userId;
        LinearLayout numberColor, rekamLine;
        ImageView imageSource, rekamIcon;
        TextView number, rekamHasil;

        public ViewHolder(View itemView) {
            super(itemView);
            numberColor = itemView.findViewById(R.id.numberColor);
            number = itemView.findViewById(R.id.number);
            imageSource = itemView.findViewById(R.id.imageSource);
            rekamHasil = itemView.findViewById(R.id.rekamHasil);
            rekamLine = itemView.findViewById(R.id.rekamLine);
            rekamIcon = itemView.findViewById(R.id.rekamIcon);
        }
    }

    public void recordAudio (final LinearLayout line, final ImageView icon, final String file_name){
        mApiService = UtilsApi.getAPIService();

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

                File filePath = new File(path);
                Log.d("filepath", String.valueOf(filePath));

                uploadFile(filePath, v);
            }
        });
    }

    private void uploadFile(File filePath, final View v) {
        showPopupWindowUpload(v);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), filePath);
        MultipartBody.Part audio =
                MultipartBody.Part.createFormData("iqra-file-rekaman", filePath.getName(), requestBody);

        mApiService.UploadFileHandler(audio).enqueue(new Callback<SubmissionResponse>() {
            @Override
            public void onResponse(Call<SubmissionResponse> call, Response<SubmissionResponse> response) {
                if(response.isSuccessful()){
                    SubmissionResponse resObj = (SubmissionResponse) response.body();
                    score = response.body().getData();

                    //bawa hasil score, simpen di hasil akurasi di baris tsb
                    Log.d("score", String.valueOf(score));
                    showPopupWindowHasil(v, score);

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
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_uploadsuara, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        int waktu_loading = 4000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                popupWindow.dismiss();
            }
        }, waktu_loading);
    }

    private void showPopupWindowHasil(View view, Double score) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_hasil_rekaman, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        TextView hasil_test = (TextView) view.findViewById(R.id.hasil_test);
        hasil_test.setText(score);
        Log.d("score",  score.toString());

        TextView button_lanjutkan = (TextView) view.findViewById(R.id.button_lanjutkan);
        button_lanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }
}
