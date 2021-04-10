package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.PreferencesUtility;
import proyek.android.iqra.apihelper.SaveSharedPreference;

public class HomeActivity extends AppCompatActivity {
    ImageView profile;
    private String getUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (SaveSharedPreference.getLoggedStatus(getApplicationContext())){
            getUsername = PreferencesUtility.getUsername(getApplicationContext());

            TextView textNama = findViewById(R.id.textnama);
            textNama.setText(getUsername);
        }

        LinearLayout card_jilid1 = findViewById(R.id.card_jilid1);
        card_jilid1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent pengantar1 = new Intent(HomeActivity.this, Pengantar1Activity.class);
                startActivity(pengantar1);
            }
        });

        profile = findViewById(R.id.button_user);
        ((View) profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SaveSharedPreference.getLoggedStatus(getApplicationContext())){
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), ProfileBeforeSignInActivity.class));
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
