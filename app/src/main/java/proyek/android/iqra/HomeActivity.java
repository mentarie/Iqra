package proyek.android.iqra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

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
    }
}
