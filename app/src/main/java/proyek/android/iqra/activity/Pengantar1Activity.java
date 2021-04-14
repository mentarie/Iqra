package proyek.android.iqra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import proyek.android.iqra.R;
import proyek.android.iqra.activity.tes_baca.TesBacaInformationActivity;
import proyek.android.iqra.activity.latihan.LatihanBacaActivity;
import proyek.android.iqra.apihelper.SaveSharedPreference;

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
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
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
                if (SaveSharedPreference.getLoggedStatus(getApplicationContext())){
                    Intent jilid1 = new Intent(Pengantar1Activity.this, TesBacaInformationActivity.class);
                    startActivity(jilid1);
                } else {
                    showPopupWindow(v);
                }
            }
        });
    }
    public void showPopupWindow(final View view){
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_sign_in, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        TextView button_signin_before = popupView.findViewById(R.id.button_signin_before);
        button_signin_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
            }
        });

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
    }
}