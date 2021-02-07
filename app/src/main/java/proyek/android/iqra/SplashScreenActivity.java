package proyek.android.iqra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading=4000;
    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent signin=new Intent(SplashScreenActivity.this, SignInActivity.class);
                startActivity(signin);
                finish();
            }
        }, waktu_loading);
    }
}
