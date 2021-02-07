package proyek.android.iqra;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    TextView button_signin, button_signup;
    ProgressDialog loading;
    ImageView ImgShowHidePassword;

    Context mContext;
    BaseApiService mApiService;

    private boolean isOpenEye = false;

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

    }

    private void initComponents() {
        etEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        etPassword = (EditText) findViewById(R.id.editTextTextPassword);
        button_signin = (TextView) findViewById(R.id.button_signin);
        button_signup = (TextView) findViewById(R.id.button_signup);

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SignUpActivity.class));
            }
        });
    }

    private void requestLogin(){
    mApiService.GetUsersHandler(etEmail.getText().toString(), etPassword.getText().toString())
        .enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("error").equals("false")){
                            // Jika login berhasil maka data nama yang ada di response API
                            // akan diparsing ke activity selanjutnya.
                            Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                            String username = jsonRESULTS.getJSONObject("usename").getString("username");
                            Intent intent = new Intent(mContext, HomeActivity.class);
                            intent.putExtra("result_nama", username);
                            startActivity(intent);
                        } else {
                            // Jika login gagal
                            String error_message = jsonRESULTS.getString("error_msg");
                            Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
                loading.dismiss();
            }
        });
    }
}