package proyek.android.iqra.adapter;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import proyek.android.iqra.R;
import proyek.android.iqra.activity.tes_baca.TesBacaActivity;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.submission.SubmissionResponse;
import proyek.android.iqra.model.TesBacaModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.*;

public class TesBacaAdapter extends RecyclerView.Adapter<TesBacaAdapter.ViewHolder> {
    private ArrayList<TesBacaModel> dataList;
    TesBacaActivity tesBacaActivity = new TesBacaActivity();
    String file_name, userId, submissionId;
    LinearLayout rekamLine;
    ImageView rekamIcon;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path, getId;

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

                uploadFile(filePath);
            }
        });
    }

    private void uploadFile(File filePath) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), filePath);
        MultipartBody.Part audio =
                MultipartBody.Part.createFormData("iqra-file-rekaman", filePath.getName(), requestBody);

        mApiService.UploadFileHandler(audio).enqueue(new Callback<SubmissionResponse>() {
            @Override
            public void onResponse(Call<SubmissionResponse> call, Response<SubmissionResponse> response) {
                if(response.isSuccessful()){
                    Log.d("Upload", "success");
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
}
