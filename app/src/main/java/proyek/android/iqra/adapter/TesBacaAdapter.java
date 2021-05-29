package proyek.android.iqra.adapter;

import android.app.ProgressDialog;
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

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.tes_baca.TesBacaActivity;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.allsubmissiondata.AllSubmissionResponse;
import proyek.android.iqra.model.TesBacaModel;

public class TesBacaAdapter extends RecyclerView.Adapter<TesBacaAdapter.ViewHolder> {
    private ArrayList<TesBacaModel> dataList;
    private List<AllSubmissionResponse> submissionList;
    TesBacaActivity tesBacaActivity = new TesBacaActivity();
    String file_name;
    Integer userId;
    String submissionId;
    LinearLayout rekamLine;
    ImageView rekamIcon;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    private MediaRecorder mediaRecorder;
    private String path, getId;
    private proyek.android.iqra.apihelper.Callback<File> onClickCallback;

    public TesBacaAdapter(ArrayList<TesBacaModel> dataList, proyek.android.iqra.apihelper.Callback<File> onClickCallback) {
        this.dataList = dataList;
        this.onClickCallback = onClickCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_tesbaca, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TesBacaModel model = dataList.get(position);
        //parsing
//        Integer id = model.getUserId();
        Double percentage = (double) Math.ceil(model.getRekamHasil() * 100);
        if(percentage != 0){
            holder.rekamHasil.setBackground(ContextCompat.getDrawable(holder.rekamHasil.getContext(), R.drawable.button_bg_rounded_enabled));
        }
//        holder.Id=model.getId();
        holder.number.setText(model.getNumber());
        holder.numberColor.setBackgroundResource(model.getNumberColor());
        holder.imageSource.setImageResource(model.getImageSource());
        holder.rekamHasil.setText(String.format("%.0f%%",percentage));
        holder.rekamLine.setBackgroundResource(model.getRekamLine());
        holder.rekamIcon.setBackgroundResource(model.getRekamIcon());
//        holder.bacaanId=model.getBacaanId();
//        holder.userId=model.getUserId();

        if (holder.rekamHasil.getText() == ""){

        }

        //set onclick rekam
        holder.rekamLine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //parsing
                userId = model.getUserId();
                file_name = String.valueOf(model.getBacaanId());
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
                onClickCallback.callback(filePath);
            }
        });
    }

    public void setItemList(ArrayList<TesBacaModel> itemList){
        this.dataList = itemList;
        notifyDataSetChanged();
    }

}
