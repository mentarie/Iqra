package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

import java.io.IOException;

import okhttp3.ResponseBody;
import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.SignInResponse;
import proyek.android.iqra.apihelper.SignUpResponse;
import proyek.android.iqra.apihelper.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    TextView button_signin, button_signup;
    ProgressDialog loading;
    ImageView ImgShowHidePassword;

    Context mContext;
    BaseApiService mApiService;

    private boolean isOpenEye = false;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        initComponents();

        // widget show hide password
        ImgShowHidePassword = findViewById(R.id.button_show_pass);
        ImgShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpenEye) {
                    ImgShowHidePassword.setSelected(true);
                    isOpenEye = true;
                    //Password visible
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ImgShowHidePassword.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SignUpActivity.class));
            }
        });
    }

    private void initComponents() {
        etUsername = (EditText) findViewById(R.id.editTextTextUsername);
        etPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button_signin = (TextView) findViewById(R.id.button_signin);
        button_signup = (TextView) findViewById(R.id.button_signup);

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parsing
                SignInResponse user = new SignInResponse (
                        etUsername.getText().toString().trim(),
                        etPassword.getText().toString()
                );

                if (validate(etUsername) && validate(etPassword)) {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                    logIn(user);
                }
            }
        });
    }

    //validate username & password
    private boolean validate(@NotNull EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returns true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

    private void logIn(SignInResponse user) {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Harap Tunggu ..."); // set message
        progressDialog.show(); // show progress dialog

        mApiService.LoginHandler(user).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if(response.isSuccessful()){
                    SignInResponse resObj = (SignInResponse) response.body();
//                    if(resObj.getMessage().equals("true")){
//                    } else {
//                        Toast.makeText(SignInActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
//                    }
                    token = response.body().getToken();
                    //login start main activity
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    intent.putExtra("username", String.valueOf(etUsername));
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                    progressDialog.setCancelable(true);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}