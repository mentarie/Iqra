package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.SignInResponse;
import proyek.android.iqra.apihelper.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileActivity extends AppCompatActivity {
    ImageView button_back;
    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                finish();
            }
        });
        LinearLayout button_nama_edit = findViewById(R.id.button_nama_edit);
        button_nama_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_nama = new Intent(ProfileActivity.this, EditNameActivity.class);
                startActivity(edit_nama);
            }
        });
        LinearLayout button_email_edit = findViewById(R.id.button_email_edit);
        button_email_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_email = new Intent(ProfileActivity.this, EditEmailActivity.class);
                startActivity(edit_email);
            }
        });
        LinearLayout button_password_edit = findViewById(R.id.button_password_edit);
        button_password_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_password = new Intent(ProfileActivity.this, EditPasswordActivity.class);
                startActivity(edit_password);
            }
        });
        LinearLayout history = findViewById(R.id.button_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baca_history = new Intent(ProfileActivity.this, HistoryActivity.class);
                startActivity(baca_history);
            }
        });
        LinearLayout tentang = findViewById(R.id.button_tentang_bukuiqra);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baca_tentang = new Intent(ProfileActivity.this, AboutActivity.class);
                startActivity(baca_tentang);
            }
        });
        LinearLayout logout = findViewById(R.id.button_signout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set LoggedIn status to false
                SaveSharedPreference.setLoggedIn(getApplicationContext(), false);

                // Logout
                logout();
            }
        });
    }

    private void logout() {
        mApiService.logout().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
        finish();
    }
}