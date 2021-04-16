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

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.SaveSharedPreference;
import proyek.android.iqra.apihelper.UtilsApi;
import proyek.android.iqra.apihelper.signin.SignInRequest;
import proyek.android.iqra.apihelper.signin.SignInResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    TextView button_signin, button_signup;
    ProgressDialog loading;
    ImageView ImgShowHidePassword, button_back;

    Context mContext;
    BaseApiService mApiService;

    private boolean isOpenEye = false;
    private String token, setUsername, setEmail, setId, getUsername, getEmail, getId;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        //Check if UserResponse is Already Logged In
        if(SaveSharedPreference.getLoggedStatus(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), SplashScreenActivity.class);
            startActivity(intent);
        } else {
            initComponents();
        }

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
                SignInRequest user = new SignInRequest(
                        etUsername.getText().toString().trim(),
                        etPassword.getText().toString()
                );

                if (validate(etUsername) && validate(etPassword)) {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                    logIn(user);
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

    private void logIn(SignInRequest user) {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Harap Tunggu ..."); // set message
        progressDialog.show(); // show progress dialog

        mApiService.LoginHandler(user).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if(response.isSuccessful()){
                    //save token
                    SignInResponse resObj = (SignInResponse) response.body();
                    token = response.body().getData().getAccessToken();
                    setUsername = response.body().getData().getUsername();
                    setEmail = response.body().getData().getEmail();
                    setId = response.body().getData().getId();
                    SaveSharedPreference.setLoggedIn(getApplicationContext(), true, setUsername, setEmail, setId);

                    PreferencesUtility.saveUsername(setUsername, getApplicationContext());
                    PreferencesUtility.saveEmail(setEmail, getApplicationContext());
                    PreferencesUtility.saveId(setId, getApplicationContext());

                    flag = SaveSharedPreference.getLoggedStatus(getApplicationContext());
                    getUsername = PreferencesUtility.getUsername(getApplicationContext());
                    getEmail = PreferencesUtility.getEmail(getApplicationContext());
                    getId = PreferencesUtility.getId(getApplicationContext());

//                    Log.d("setUsername", setUsername);
//                    Log.d("setEmail", setEmail);
//                    Log.d("data", response.body().getData().toString());
//                    Log.d("getLoggedStatus", String.valueOf(flag));
//                    Log.d("getUsername", flag2);
//                    Log.d("getEmail", flag3);

                    //login start main activity
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}