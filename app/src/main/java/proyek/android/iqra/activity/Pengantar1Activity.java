package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.latihan.LatihanBacaActivity;
import proyek.android.iqra.activity.tes_baca.TesBacaActivity;

public class Pengantar1Activity extends AppCompatActivity {
    TextView textPengantar1, tes_baca_jilid1, latihan_jilid1;
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

        latihan_jilid1 = findViewById(R.id.button_latihan);
        latihan_jilid1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent jilid1 = new Intent(Pengantar1Activity.this, LatihanBacaActivity.class);
                startActivity(jilid1);
            }
        });

        tes_baca_jilid1 = findViewById(R.id.button_tesbaca);
        tes_baca_jilid1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent jilid1 = new Intent(Pengantar1Activity.this, TesBacaActivity.class);
                startActivity(jilid1);
            }
        });
    }
}