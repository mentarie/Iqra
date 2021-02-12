package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import proyek.android.iqra.apihelper.SignUpResponse;
import proyek.android.iqra.apihelper.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText etUsername, etEmail, etPassword;
    TextView button_signin, button_signup;
    ProgressDialog loading;
    ImageView ImgShowHidePassword;
    String id_user="id_";

    Context mContext;
    BaseApiService mApiService;

    private boolean isOpenEye = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

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

        button_signin = findViewById(R.id.button_signin);
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SignInActivity.class));
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                finish();
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

    //validate email
    private boolean validateEmail() {
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

    //jika tap button signup
    private void initComponents() {
        etUsername = (EditText) findViewById(R.id.editTextTextUsername);
        etEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        etPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button_signup = (TextView) findViewById(R.id.button_signup);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parsing
                SignUpResponse user = new SignUpResponse (
                    etUsername.getText().toString().trim(),
                    etEmail.getText().toString().trim(),
                    etPassword.getText().toString().trim(),
                    id_user.trim()
                );

                if (validate(etUsername) && validateEmail() && validate(etPassword)) {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                    signUp(user);
                }
            }
        });
    }

    private void signUp(SignUpResponse user) {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Harap Tunggu ..."); // set message
        progressDialog.show(); // show progress dialog

        mApiService.CreateUserHandler(user).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if(response.isSuccessful()) {
                    Log.i("debug", "onResponse: BERHASIL");
                    progressDialog.dismiss();
                    startActivity(new Intent(mContext, HomeActivity.class));
                } else {
                    Log.i("debug", "onResponse: TIDAK BERHASIL");
                    progressDialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }


    //proses ketika signup
//    private void signUp(user) {
//        // display a progress dialog
//        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
//        progressDialog.setCancelable(false); // set cancelable to false
//        progressDialog.setMessage("Harap Tunggu ..."); // set message
//        progressDialog.show(); // show progress dialog
//
//        mApiService.CreateUserHandler().enqueue(new Callback<SignUpResponse>() {
//            @Override
//            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
//                if(response.isSuccessful()) {
//                    Log.i("debug", "onResponse: BERHASIL");
//                    loading.dismiss();
//                    try {
//                        JSONObject jsonRESULTS = new JSONObject(response.body().toString());
//                        if (jsonRESULTS.getString("error").equals("false")){
//                            Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(mContext, HomeActivity.class));
//                        } else {
//                            String error_message = jsonRESULTS.getString("error_msg");
//                            Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Log.i("debug", "onResponse: TIDAK BERHASIL");
//                    loading.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SignUpResponse> call, Throwable t) {
//                Log.d("response", t.getStackTrace().toString());
//                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
//            }
//        });
//    }
}