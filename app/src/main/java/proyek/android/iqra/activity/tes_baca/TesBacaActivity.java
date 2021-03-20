package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;

public class TesBacaActivity extends AppCompatActivity {
    ImageView button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca);

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}