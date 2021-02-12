package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import proyek.android.iqra.R;

public class HistoryActivity extends AppCompatActivity {
    ImageView button_back;
    TextView textJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        button_back = findViewById(R.id.button_back);
        ((View) button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textJudul = (TextView) findViewById(R.id.textToolbar);
        textJudul.setText("History");
    }
}