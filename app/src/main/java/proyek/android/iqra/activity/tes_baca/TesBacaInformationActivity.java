package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.MainActivity;
import proyek.android.iqra.activity.Pengantar1Activity;

public class TesBacaInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca_information);

        TextView start_test = findViewById(R.id.button_start_test);
        start_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jilid1 = new Intent(TesBacaInformationActivity.this, TesBacaActivity.class);
                startActivity(jilid1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
    }
}