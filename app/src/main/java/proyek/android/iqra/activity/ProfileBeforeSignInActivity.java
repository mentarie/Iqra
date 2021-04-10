package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import proyek.android.iqra.R;

public class ProfileBeforeSignInActivity extends AppCompatActivity {
    TextView button_signin_before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_before_sign_in);

        button_signin_before = findViewById(R.id.button_signin_before);
        button_signin_before.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
        LinearLayout history = findViewById(R.id.button_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baca_history = new Intent(ProfileBeforeSignInActivity.this, HistoryActivity.class);
                startActivity(baca_history);
            }
        });
        LinearLayout tentang = findViewById(R.id.button_tentang_bukuiqra);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baca_tentang = new Intent(ProfileBeforeSignInActivity.this, AboutActivity.class);
                startActivity(baca_tentang);
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}