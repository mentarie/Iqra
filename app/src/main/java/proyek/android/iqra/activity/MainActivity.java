package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import proyek.android.iqra.R;
import proyek.android.iqra.adapter.DataAdapter;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.SResponse;
import proyek.android.iqra.apihelper.SResponse.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Data> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer getId = Integer.valueOf(PreferencesUtility.getId(getApplicationContext()));

        recyclerView = findViewById(R.id.card_recycler_view);
        adapter = new DataAdapter(new ArrayList<Data>());
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        loadJSON(getId);
    }

    private void loadJSON(Integer getId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.48:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BaseApiService request = retrofit.create(BaseApiService.class);
        Call<SResponse> call = request.GetSubmissionsHandler(getId);
        call.enqueue(new Callback<SResponse>() {
            @Override
            public void onResponse(Call<SResponse> call, Response<SResponse> response) {
                data = response.body().getData();
                Log.d("Baerhasil", "onResponseMain: " + data.toString());
                adapter.setItemList(data);
            }

            @Override
            public void onFailure(Call<SResponse> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }
}
