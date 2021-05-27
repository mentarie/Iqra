package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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

public class EditPasswordActivity extends AppCompatActivity {
    ImageView button_close, button_save, ImgShowHidePassword;
    TextView textJudul;
    EditText editPassword;
    String getId;

    Context mContext;
    BaseApiService mApiService;
    private boolean isOpenEye = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        button_close = findViewById(R.id.button_close);
        ((View) button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Ubah Password");

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initComponents();
            }
        });

        // widget show hide password
        ImgShowHidePassword = findViewById(R.id.button_show_pass);
        ImgShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpenEye) {
                    ImgShowHidePassword.setSelected(true);
                    isOpenEye = true;
                    //Password visible
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ImgShowHidePassword.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void initComponents() {
        //parsing
        getId = PreferencesUtility.getId(getApplicationContext());
        editPassword = findViewById(R.id.editPassword);
        UpdateDataRequest user = new UpdateDataRequest(
                getId,
                "",
                "",
                editPassword.getText().toString()
        );
        if(validate(editPassword)){
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
                    //logout system
                    SaveSharedPreference.setLoggedOut(getApplicationContext(), false);
                    //dialihkan ke halaman sebelum sign in
                    startActivity(new Intent(getApplicationContext(),SplashScreenActivity.class));
                } else {
                    Toast.makeText(EditPasswordActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
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