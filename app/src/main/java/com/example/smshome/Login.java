package com.example.smshome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    LinearLayout simpan;
    EditText pengguna, perangkat;
    ProgressDialog loading;
    Context mContext;
    Boolean session = false;
    Boolean lampA, lampB, lampC, lampD, lampF, lampG, lampE, lampH, lampI, lampJ, lampK, lampL = false;
    SharedPreferences sharedpreferences;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String phoneNo;
    String message;
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";
    public static final String session_statusA = "session_statusA";
    public static final String session_statusB = "session_statusB";
    public static final String session_statusC = "session_statusC";
    public static final String session_statusD = "session_statusD";
    public static final String session_statusE = "session_statusE";
    public static final String session_statusF = "session_statusF";
    public static final String session_statusG = "session_statusG";
    public static final String session_statusH = "session_statusH";
    public static final String session_statusI = "session_statusI";
    public static final String session_statusJ = "session_statusJ";
    public static final String session_statusK = "session_statusK";
    public static final String session_statusL = "session_statusL";
    public final static String TAG_NO_PERANGKAT = "no_perangkat";
    public final static String TAG_NO_PENGGUNA = "no_pengguna";
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
    String no_perangkat, no_pengguna;
    String A,B,C,D,E,F,G,H,I,J,K,L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        simpan = (LinearLayout) findViewById(R.id.simpan);
        pengguna = findViewById(R.id.editTextPengguna);
        perangkat = findViewById(R.id.editTextPerangkat);
        cekSession();
        phoneNo = perangkat.getText().toString();
        message = pengguna.getText().toString();
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
                    kirim();
                }
            }
        });

    }

    public void cekSession() {
        // Cek session login jika TRUE maka langsung buka DashbardActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        lampA = sharedpreferences.getBoolean(session_statusA, false);
        lampB = sharedpreferences.getBoolean(session_statusB, false);
        lampC = sharedpreferences.getBoolean(session_statusC, false);
        lampD = sharedpreferences.getBoolean(session_statusD, false);
        lampE = sharedpreferences.getBoolean(session_statusE, false);
        lampF = sharedpreferences.getBoolean(session_statusF, false);
        lampG = sharedpreferences.getBoolean(session_statusG, false);
        lampH = sharedpreferences.getBoolean(session_statusH, false);
        lampI = sharedpreferences.getBoolean(session_statusI, false);
        lampJ = sharedpreferences.getBoolean(session_statusJ, false);
        lampK = sharedpreferences.getBoolean(session_statusK, false);
        lampL = sharedpreferences.getBoolean(session_statusL, false);
        no_perangkat = sharedpreferences.getString(TAG_NO_PERANGKAT, null);
        no_pengguna = sharedpreferences.getString(TAG_NO_PENGGUNA, null);
        A = sharedpreferences.getString(TAG_LAMPU_A, null);
        B = sharedpreferences.getString(TAG_LAMPU_B, null);
        C = sharedpreferences.getString(TAG_LAMPU_C, null);
        D = sharedpreferences.getString(TAG_LAMPU_D, null);
        E = sharedpreferences.getString(TAG_LAMPU_E, null);
        F = sharedpreferences.getString(TAG_LAMPU_F, null);
        G = sharedpreferences.getString(TAG_LAMPU_G, null);
        H = sharedpreferences.getString(TAG_LAMPU_H, null);
        I = sharedpreferences.getString(TAG_LAMPU_I, null);
        J = sharedpreferences.getString(TAG_LAMPU_J, null);
        K = sharedpreferences.getString(TAG_LAMPU_K, null);
        L = sharedpreferences.getString(TAG_LAMPU_L, null);

        if (session) {
            Intent intent = new Intent(Login.this, Home.class);
            intent.putExtra(TAG_NO_PENGGUNA, no_pengguna);
            intent.putExtra(TAG_NO_PERANGKAT, no_perangkat);
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
            intent.putExtra(session_statusA, lampA);
            intent.putExtra(session_statusB, lampB);
            intent.putExtra(session_statusC, lampC);
            intent.putExtra(session_statusD, lampD);
            intent.putExtra(session_statusE, lampE);
            intent.putExtra(session_statusF, lampF);
            intent.putExtra(session_statusG, lampG);
            intent.putExtra(session_statusH, lampH);
            intent.putExtra(session_statusI, lampI);
            intent.putExtra(session_statusJ, lampJ);
            intent.putExtra(session_statusK, lampK);
            intent.putExtra(session_statusL, lampL);
            startActivity(intent);
            finish();
        }
    }

    public void logindah(){
        String perangkat_no, pengguna_no;
        String A,B,C,D,E,F,G,H,I,J,K,L;
        A = "Lampu A";
        B = "Lampu B";
        C = "Lampu C";
        D = "Lampu D";
        E = "Lampu E";
        F = "Lampu F";
        G = "Lampu G";
        H = "Lampu H";
        I = "Lampu I";
        J = "Lampu J";
        K = "Lampu K";
        L = "Lampu L";
        perangkat_no = perangkat.getText().toString();
        pengguna_no = pengguna.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(session_status, true);
        editor.putBoolean(session_statusA, false);
        editor.putBoolean(session_statusB, false);
        editor.putBoolean(session_statusC, false);
        editor.putBoolean(session_statusD, false);
        editor.putBoolean(session_statusE, false);
        editor.putBoolean(session_statusF, false);
        editor.putBoolean(session_statusG, false);
        editor.putBoolean(session_statusH, false);
        editor.putBoolean(session_statusI, false);
        editor.putBoolean(session_statusJ, false);
        editor.putBoolean(session_statusK, false);
        editor.putBoolean(session_statusL, false);
        editor.putString(TAG_NO_PERANGKAT, perangkat_no);
        editor.putString(TAG_NO_PENGGUNA, pengguna_no);
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

        Intent intent = new Intent(Login.this, Home.class);
        intent.putExtra(TAG_NO_PERANGKAT, no_perangkat);
        intent.putExtra(TAG_NO_PENGGUNA, no_pengguna);
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

    public void kirim() {
        phoneNo = perangkat.getText().toString();
        message = pengguna.getText().toString();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "Koneksi Berhasil",
                            Toast.LENGTH_LONG).show();
                    logindah();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Koneksi Gagal!", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}