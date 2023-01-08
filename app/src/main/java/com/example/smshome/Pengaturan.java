package com.example.smshome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Pengaturan extends AppCompatActivity {
    EditText lampuA,lampuB,lampuC,lampuD,lampuE,lampuF,lampuG,lampuH,lampuI,lampuJ,lampuK,lampuL;
    SharedPreferences sharedpreferences;
    String A,B,C,D,E,F,G,H,I,J,K,L;
    LinearLayout simpan;
    public final static String TAG_NO_PERANGKAT = "no_perangkat";
    public final static String TAG_LAMPU_A = "lampu_a";
    public final static String TAG_LAMPU_B = "lampu_b";
    public final static String TAG_LAMPU_C = "lampu_c";
    public final static String TAG_LAMPU_D = "lampu_d";
    public final static String TAG_LAMPU_E = "lampu_e";
    public final static String TAG_LAMPU_F = "lampu_f";
    public final static String TAG_LAMPU_G = "lampu_g";
    public final static String TAG_LAMPU_H = "lampu_h";
    public final static String TAG_LAMPU_I = "lampu_i";
    public final static String TAG_LAMPU_J = "lampu_j";
    public final static String TAG_LAMPU_K = "lampu_k";
    public final static String TAG_LAMPU_L = "lampu_l";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        lampuA = findViewById(R.id.lampuA);
        lampuB = findViewById(R.id.lampuB);
        lampuC = findViewById(R.id.lampuC);
        lampuD = findViewById(R.id.lampuD);
        lampuE = findViewById(R.id.lampuE);
        lampuF = findViewById(R.id.lampuF);
        lampuG = findViewById(R.id.lampuG);
        lampuH = findViewById(R.id.lampuH);
        lampuI = findViewById(R.id.lampuI);
        lampuJ = findViewById(R.id.lampuJ);
        lampuK = findViewById(R.id.lampuK);
        lampuL = findViewById(R.id.lampuL);
        ambilSession();
        lampuA.setText(A);
        lampuB.setText(B);
        lampuC.setText(C);
        lampuD.setText(D);
        lampuE.setText(E);
        lampuF.setText(F);
        lampuG.setText(G);
        lampuH.setText(H);
        lampuI.setText(I);
        lampuJ.setText(J);
        lampuK.setText(K);
        lampuL.setText(L);

        simpan = (LinearLayout) findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A,B,C,D,E,F,G,H,I,J,K,L;
                A = lampuA.getText().toString().trim();
                B = lampuB.getText().toString().trim();
                C = lampuC.getText().toString().trim();
                D = lampuD.getText().toString().trim();
                E = lampuE.getText().toString().trim();
                F = lampuF.getText().toString().trim();
                G = lampuG.getText().toString().trim();
                H = lampuH.getText().toString().trim();
                I = lampuI.getText().toString().trim();
                J = lampuJ.getText().toString().trim();
                K = lampuK.getText().toString().trim();
                L = lampuL.getText().toString().trim();

                if (TextUtils.isEmpty(A)) {
                    lampuA.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(B)) {
                    lampuB.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(C)) {
                    lampuC.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(D)) {
                    lampuD.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(E)) {
                    lampuE.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(F)) {
                    lampuF.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(G)) {
                    lampuG.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(H)) {
                    lampuH.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(I)) {
                    lampuI.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(J)) {
                    lampuJ.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(K)) {
                    lampuK.setError("Tidak boleh kosong");
                } else

                if (TextUtils.isEmpty(L)) {
                    lampuL.setError("Tidak boleh kosong");
                } else  {
                    logindah();
                }
            }
        });
    }

    public void ambilSession() {
        sharedpreferences = this.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        A = this.getIntent().getStringExtra(TAG_LAMPU_A);
        B = this.getIntent().getStringExtra(TAG_LAMPU_B);
        C = this.getIntent().getStringExtra(TAG_LAMPU_C);
        D = this.getIntent().getStringExtra(TAG_LAMPU_D);
        E = this.getIntent().getStringExtra(TAG_LAMPU_E);
        F = this.getIntent().getStringExtra(TAG_LAMPU_F);
        G = this.getIntent().getStringExtra(TAG_LAMPU_G);
        H = this.getIntent().getStringExtra(TAG_LAMPU_H);
        I = this.getIntent().getStringExtra(TAG_LAMPU_I);
        J = this.getIntent().getStringExtra(TAG_LAMPU_J);
        K = this.getIntent().getStringExtra(TAG_LAMPU_K);
        L = this.getIntent().getStringExtra(TAG_LAMPU_L);
    }

    public void logindah(){
        String perangkat_no, pengguna_no;
        String A,B,C,D,E,F,G,H,I,J,K,L;
        A = lampuA.getText().toString();
        B = lampuB.getText().toString();
        C = lampuC.getText().toString();
        D = lampuD.getText().toString();
        E = lampuE.getText().toString();
        F = lampuF.getText().toString();
        G = lampuG.getText().toString();
        H = lampuH.getText().toString();
        I = lampuI.getText().toString();
        J = lampuJ.getText().toString();
        K = lampuK.getText().toString();
        L = lampuL.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TAG_LAMPU_A, A);
        editor.putString(TAG_LAMPU_B, B);
        editor.putString(TAG_LAMPU_C, C);
        editor.putString(TAG_LAMPU_D, D);
        editor.putString(TAG_LAMPU_E, E);
        editor.putString(TAG_LAMPU_F, F);
        editor.putString(TAG_LAMPU_G, G);
        editor.putString(TAG_LAMPU_H, H);
        editor.putString(TAG_LAMPU_I, I);
        editor.putString(TAG_LAMPU_J, J);
        editor.putString(TAG_LAMPU_K, K);
        editor.putString(TAG_LAMPU_L, L);
        editor.apply();

        Intent intent = new Intent(Pengaturan.this, Home.class);
        intent.putExtra(TAG_LAMPU_A, A);
        intent.putExtra(TAG_LAMPU_B, B);
        intent.putExtra(TAG_LAMPU_C, C);
        intent.putExtra(TAG_LAMPU_D, D);
        intent.putExtra(TAG_LAMPU_E, E);
        intent.putExtra(TAG_LAMPU_F, F);
        intent.putExtra(TAG_LAMPU_G, G);
        intent.putExtra(TAG_LAMPU_H, H);
        intent.putExtra(TAG_LAMPU_I, I);
        intent.putExtra(TAG_LAMPU_J, J);
        intent.putExtra(TAG_LAMPU_K, K);
        intent.putExtra(TAG_LAMPU_L, L);
        startActivity(intent);
        finish();
    }
}