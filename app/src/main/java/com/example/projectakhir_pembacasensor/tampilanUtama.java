package com.example.projectakhir_pembacasensor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class tampilanUtama extends AppCompatActivity {
    private TextView nilai;
    private Firebase mref;
    Spinner satuanSuhu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_utama);

        nilai = (TextView) findViewById(R.id.nilai);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mref = database.getReference("value");

        satuanSuhu = (Spinner) findViewById(R.id.satuanSuhu);

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final Long value = snapshot.getValue(Long.class);
                String satuanygdipilih = satuanSuhu.getSelectedItem().toString();
                if (satuanygdipilih .equals("Celcius")) {
                    String celcius = value.toString();
                    nilai.setText(celcius + "˚C");
                    return;
                }else if (satuanygdipilih .equals("Fahrenheit")) {
                    Long F = (9 / 5 * value) + 32;
                    String Fahrenheit = F.toString();
                    nilai.setText(Fahrenheit + "˚F");
                    return;
                } else if (satuanygdipilih .equals("Kelvin")) {
                    Long K = value + 273;
                    String Kelvin = K.toString();
                    nilai.setText(Kelvin + "˚K");
                    return;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}