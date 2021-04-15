package proyek.android.iqra.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.tes_baca.TesBacaActivity;
import proyek.android.iqra.model.TesBacaModel;

import static android.view.View.*;

public class TesBacaAdapter extends RecyclerView.Adapter<TesBacaAdapter.ViewHolder> {
    private ArrayList<TesBacaModel> dataList;
    TesBacaActivity tesBacaActivity = new TesBacaActivity();
    String file_name;

    public TesBacaAdapter(ArrayList<TesBacaModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

        //set onclick rekam
        holder.rekamLine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                file_name = String.valueOf(holder.bacaanId);
                LinearLayout rekamLine = holder.rekamLine;
                ImageView rekamIcon = holder.rekamIcon;
                holder.rekamIcon.setImageResource(android.R.color.transparent);
                Log.d("nama file",file_name);

                ((tesBacaActivity)).recordAudio(rekamLine,rekamIcon, file_name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class ViewHolder  extends RecyclerView.ViewHolder  {
        int Id;
        String bacaanId;
        LinearLayout numberColor, rekamLine;
        ImageView imageSource, rekamIcon;
        TextView number, rekamHasil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numberColor = itemView.findViewById(R.id.numberColor);
            number = itemView.findViewById(R.id.number);
            imageSource = itemView.findViewById(R.id.imageSource);
            rekamHasil = itemView.findViewById(R.id.rekamHasil);
            rekamLine = itemView.findViewById(R.id.rekamLine);
            rekamIcon = itemView.findViewById(R.id.rekamIcon);
        }
    }
}
