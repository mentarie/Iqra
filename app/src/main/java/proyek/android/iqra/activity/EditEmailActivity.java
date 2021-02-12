package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import proyek.android.iqra.R;

public class EditEmailActivity extends AppCompatActivity {
    ImageView button_close;
    TextView textJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        button_close = findViewById(R.id.button_close);
        ((View) button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("Ubah Email");
    }
}