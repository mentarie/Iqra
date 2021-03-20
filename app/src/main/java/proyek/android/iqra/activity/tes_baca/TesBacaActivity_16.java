package proyek.android.iqra.activity.tes_baca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.Pengantar1Activity;

public class TesBacaActivity_16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_baca_16);
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), Pengantar1Activity.class));
        finish();
    }
}