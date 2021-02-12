package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.BaseApiService;
import proyek.android.iqra.apihelper.UtilsApi;

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
                logIn();
            }
        });

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SignUpActivity.class));
            }
        });
    }

    private void logIn() {
    }


}