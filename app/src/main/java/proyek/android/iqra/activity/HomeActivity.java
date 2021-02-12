package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import proyek.android.iqra.R;

public class HomeActivity extends AppCompatActivity {
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                finish();
            }
        });
    }
}
