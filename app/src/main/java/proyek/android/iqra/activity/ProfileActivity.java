package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.SaveSharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    ImageView button_back;
    TextView textNama, textEmail;
    Context mContext;
    BaseApiService mApiService;

    private String getUsername, getEmail;

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
            }
        });
        if (SaveSharedPreference.getLoggedStatus(getApplicationContext())){
            getUsername = PreferencesUtility.getUsername(getApplicationContext());
            getEmail = PreferencesUtility.getEmail(getApplicationContext());

            textNama = (TextView) findViewById(R.id.textNama);
            textNama.setText(getUsername);

            textEmail = (TextView) findViewById(R.id.textEmail);
            textEmail.setText(getEmail);
        }
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
                SaveSharedPreference.setLoggedOut(getApplicationContext(), false);
                startActivity(new Intent(getApplicationContext(),SplashScreenActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}