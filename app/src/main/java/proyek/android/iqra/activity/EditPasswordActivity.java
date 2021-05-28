package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
    ImageView button_close, button_save;
    TextView textJudul;
    EditText editPassword;
    String getId;

    Context mContext;
    BaseApiService mApiService;

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
        if (editText.getText().toString().trim().length() >= 8) {
            return true;
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

    private void saveData(UpdateDataRequest user) {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(EditPasswordActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Harap Tunggu ..."); // set message
        progressDialog.show(); // show progress dialog

        mApiService.UpdateUserHandler(user).enqueue(new Callback<UpdateDataResponse>() {
            @Override
            public void onResponse(Call<UpdateDataResponse> call, Response<UpdateDataResponse> response) {
                if(response.isSuccessful()){
                    //logout system
                    SaveSharedPreference.setLoggedOut(getApplicationContext(), false);
                    //dialihkan ke halaman sebelum sign in
                    startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                } else {
                    Toast.makeText(EditPasswordActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                    progressDialog.setCancelable(true);
                }
            }

            @Override
            public void onFailure(Call<UpdateDataResponse> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
    }
}