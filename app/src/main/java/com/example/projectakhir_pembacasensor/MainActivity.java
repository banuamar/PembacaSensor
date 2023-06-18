package com.example.projectakhir_pembacasensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMasuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMasuk = (Button) findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MasukLoginOnClick();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this.getBaseContext(), "Terimakasih",
                Toast.LENGTH_LONG).show();
    }
    public void MasukLoginOnClick() {
        Intent nextpage = new Intent(this, LoginActivity.class);
        startActivity(nextpage);

    }
}