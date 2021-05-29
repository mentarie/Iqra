package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import proyek.android.iqra.apihelper.emailchecker.EmailCheckerRequest;
import proyek.android.iqra.apihelper.emailchecker.EmailCheckerResponse;
import proyek.android.iqra.apihelper.updatedata.UpdateDataRequest;
import proyek.android.iqra.apihelper.updatedata.UpdateDataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditEmailActivity extends AppCompatActivity {
    ImageView button_close, button_save;
    TextView textJudul;
    EditText editEmail;
    String setEmail, setStatusEmail, getEmail;
    Boolean emailAda;
    Integer getId;

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

        getEmail = PreferencesUtility.getEmail(getApplicationContext());
        editEmail = findViewById(R.id.editEmail);
        editEmail.setText(getEmail);

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
        getId = Integer.parseInt(PreferencesUtility.getId(getApplicationContext()));

//        EmailCheckerRequest cekEmail = new EmailCheckerRequest(
//                getId,
//                email
//        );
        UpdateDataRequest user = new UpdateDataRequest(
                getId,
                "",
                editEmail.getText().toString(),
                ""
        );
        if (validateLength(editEmail)) {
//            if(!validateEmailExist(cekEmail)){
                saveData(user);
//            }else{
//                editEmail.setError("Email sudah digunakan");
//            }
        }
    }

    //validate
    private boolean validateLength(@NotNull EditText etEmail) {
        String email = etEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            etEmail.setError("Email is not valid.");
            etEmail.requestFocus();
            return false;
        }
        return true;
    }
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

//    private boolean validateEmailExist(EmailCheckerRequest cekEmail) {
//        mApiService.EmailCheckerHandler(cekEmail).enqueue(new Callback<EmailCheckerResponse>() {
//            @Override
//            public void onResponse(Call<EmailCheckerResponse> call, Response<EmailCheckerResponse> response) {
//                emailAda = response.body().getData();
//                setStatusEmail = emailAda.toString();
//                Log.d("setStatusEmail D", setStatusEmail);
//            }
//
//            @Override
//            public void onFailure(Call<EmailCheckerResponse> call, Throwable t) {
//                Log.d("response", t.getStackTrace().toString());
//                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Log.d("setStatusEmail L", setStatusEmail);
//
//        if(setStatusEmail.equals("true")){
//            return true;
//        }else{
//            return false;
//        }
//    }

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