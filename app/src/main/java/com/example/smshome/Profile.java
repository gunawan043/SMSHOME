package com.example.smshome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Profile extends AppCompatActivity {
    LinearLayout simpan;
    EditText pengguna, perangkat;
    ProgressDialog loading;
    Context mContext;
    Boolean session = false;
    SharedPreferences sharedpreferences;
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";
    public final static String TAG_NO_PERANGKAT = "no_perangkat";
    public final static String TAG_NO_PENGGUNA = "no_pengguna";
    String no_perangkat, no_pengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        simpan = (LinearLayout) findViewById(R.id.simpan);
        pengguna = findViewById(R.id.editTextPengguna);
        perangkat = findViewById(R.id.editTextPerangkat);
        pengguna.setText(no_pengguna);
        perangkat.setText(no_perangkat);
        ambilSession();
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrnm = perangkat.getText().toString().trim();
                String pwd = pengguna.getText().toString().trim();

                if (TextUtils.isEmpty(usrnm)) {
                    perangkat.setError("Tidak boleh kosong");
                } else if (TextUtils.isEmpty(pwd)) {
                    pengguna.setError("Tidak boleh kosong");
                } else {
                    logindah();
                }
            }
        });
    }

    public void ambilSession() {
        sharedpreferences = this.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        no_pengguna = this.getIntent().getStringExtra(TAG_NO_PENGGUNA);
        no_perangkat = this.getIntent().getStringExtra(TAG_NO_PERANGKAT);
    }

    public void logindah(){
        String perangkat_no, pengguna_no;
        perangkat_no = perangkat.getText().toString();
        pengguna_no = pengguna.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(session_status, true);
        editor.putString(TAG_NO_PERANGKAT, perangkat_no);
        editor.putString(TAG_NO_PENGGUNA, pengguna_no);
        editor.apply();

        Intent intent = new Intent(Profile.this, Home.class);
        intent.putExtra(TAG_NO_PERANGKAT, no_perangkat);
        intent.putExtra(TAG_NO_PENGGUNA, no_pengguna);
        startActivity(intent);
        finish();
    }
}