package proyek.android.iqra.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.SResponse;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<SResponse.Data> itemList;

    public DataAdapter(List<SResponse.Data> android){
        this.itemList=android;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater v = LayoutInflater.from(parent.getContext());
        View itemView = v.inflate(R.layout.example_item_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.rekamHasil.setText(itemList.get(position).getAccuracy());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView rekamHasil;

        public ViewHolder(View view){
            super(view);

            rekamHasil = (TextView)view.findViewById(R.id.rekamHasil);
        }
    }

    public void setItemList(List<SResponse.Data> itemList){
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}
