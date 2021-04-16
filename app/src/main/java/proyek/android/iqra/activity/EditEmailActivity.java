package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.apihelper.PreferencesUtility;

public class EditEmailActivity extends AppCompatActivity {
    ImageView button_close, button_save;
    TextView textJudul;
    private String getEmail;

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

        getEmail = PreferencesUtility.getUsername(getApplicationContext());
        TextView textNama = findViewById(R.id.editEmail);
        textNama.setHint(getEmail);
    }
}