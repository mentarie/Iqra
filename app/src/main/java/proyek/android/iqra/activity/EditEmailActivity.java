package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.SaveSharedPreference;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.updatedata.UpdateDataRequest;
import proyek.android.iqra.apihelper.updatedata.UpdateDataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditEmailActivity extends AppCompatActivity {
    ImageView button_close, button_save;
    TextView textJudul;
    EditText editEmail;
    String getId, setEmail;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        button_close = findViewById(R.id.button_close);
        ((View) button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Ubah Email");

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initComponents();
            }
        });
    }

    private void initComponents() {
        //parsing
        getId = PreferencesUtility.getId(getApplicationContext());
        editEmail = findViewById(R.id.editEmail);
        UpdateDataRequest user = new UpdateDataRequest(
                getId,
                "",
                editEmail.getText().toString(),
                ""
        );
        if(validate(editEmail)){
            saveData(user);
        }
    }

    //validate
    private boolean validate(@NotNull EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

    private void saveData(UpdateDataRequest user) {
        mApiService.UpdateUserHandler(user).enqueue(new Callback<UpdateDataResponse>() {
            @Override
            public void onResponse(Call<UpdateDataResponse> call, Response<UpdateDataResponse> response) {
                if(response.isSuccessful()){
                    //save data update ke shared preference
                    UpdateDataResponse resObj = (UpdateDataResponse) response.body();
                    setEmail = response.body().getData().getEmail();
                    SaveSharedPreference.setUpdateEmail(getApplicationContext(), true, setEmail);
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                } else {
                    Toast.makeText(EditEmailActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateDataResponse> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
    }
}