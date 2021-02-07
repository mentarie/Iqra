package proyek.android.iqra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Pengantar1Activity extends AppCompatActivity {
    TextView textPengantar1;
    ImageView button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengantar1);

        textPengantar1 = (TextView) findViewById(R.id.textToolbar);
        textPengantar1.setText("Pengantar Jilid 1");

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView latihan_jilid1 = findViewById(R.id.button_latihan);
        latihan_jilid1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent jilid1 = new Intent(Pengantar1Activity.this, LatihanBacaActivity.class);
                startActivity(jilid1);
            }
        });
    }
}