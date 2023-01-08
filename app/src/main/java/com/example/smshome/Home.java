package com.example.smshome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    CardView lampuA,lampuB,lampuC,lampuD,lampuE,lampuF,lampuG,lampuH,lampuI,lampuJ,lampuK,lampuL, profil;
    TextView txtA,txtB,txtC,txtD,txtE,txtF,txtG,txtH,txtI,txtJ,txtK,txtL;
    ImageView imgA,imgB,imgC,imgD,imgE,imgF,imgG,imgH,imgI,imgJ,imgK,imgL, pengaturan;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String phoneNo;
    String message;
    String A,B,C,D,E,F,G,H,I,J,K,L;
    TextView feedback;
    Boolean lampA, lampB, lampC, lampD, lampF, lampG, lampE, lampH, lampI, lampJ, lampK, lampL = false;
    SharedPreferences sharedpreferences;
    public static final String my_shared_preferences = "my_shared_preferences";
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
    int lampOn = Color.parseColor("#d4a056");
    int lampOff = Color.parseColor("#333c4b");
    int txtOff = Color.parseColor("#333c4b");
    int txtOn = Color.parseColor("#FFFFFFFF");
    String no_perangkat, no_pengguna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ambilSession();
        lampuA = findViewById(R.id.lampuA);
        imgA = findViewById(R.id.imgA);
        txtA = findViewById(R.id.txtA);


        lampuB = findViewById(R.id.lampuB);
        imgB = findViewById(R.id.imgB);
        txtB = findViewById(R.id.txtB);


        lampuC = findViewById(R.id.lampuC);
        imgC = findViewById(R.id.imgC);
        txtC = findViewById(R.id.txtC);


        lampuD = findViewById(R.id.lampuD);
        imgD = findViewById(R.id.imgD);
        txtD = findViewById(R.id.txtD);


        lampuE = findViewById(R.id.lampuE);
        imgE = findViewById(R.id.imgE);
        txtE = findViewById(R.id.txtE);


        lampuF = findViewById(R.id.lampuF);
        imgF = findViewById(R.id.imgF);
        txtF = findViewById(R.id.txtF);


        lampuG = findViewById(R.id.lampuG);
        imgG = findViewById(R.id.imgG);
        txtG = findViewById(R.id.txtG);


        lampuH = findViewById(R.id.lampuH);
        imgH = findViewById(R.id.imgH);
        txtH = findViewById(R.id.txtH);


        lampuI = findViewById(R.id.lampuI);
        imgI = findViewById(R.id.imgI);
        txtI = findViewById(R.id.txtI);


        lampuJ = findViewById(R.id.lampuJ);
        imgJ = findViewById(R.id.imgJ);
        txtJ = findViewById(R.id.txtJ);


        lampuK = findViewById(R.id.lampuK);
        imgK = findViewById(R.id.imgK);
        txtK = findViewById(R.id.txtK);


        lampuL = findViewById(R.id.lampuL);
        imgL = findViewById(R.id.imgL);
        txtL = findViewById(R.id.txtL);

        feedback = findViewById(R.id.feedback);
        feedback.setText("");
        pengaturan = findViewById(R.id.pengaturan);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Pengaturan.class);
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
        });

        profil = findViewById(R.id.profil);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this, Profile.class);
//                intent.putExtra(TAG_NO_PENGGUNA, no_pengguna);
//                intent.putExtra(TAG_NO_PERANGKAT, no_perangkat);
//                startActivity(intent);
//                finish();
//            }
//        });

        txtA.setText(A);
        txtB.setText(B);
        txtC.setText(C);
        txtD.setText(D);
        txtE.setText(E);
        txtF.setText(F);
        txtG.setText(G);
        txtH.setText(H);
        txtI.setText(I);
        txtJ.setText(J);
        txtK.setText(K);
        txtL.setText(L);

        if(lampA){
            feedback.setText(message);
            imgA.setColorFilter(lampOn);
            lampuA.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtA.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgA.setColorFilter(lampOff);
            lampuA.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtA.setTextColor(txtOff);
        }

        if(lampB){
            feedback.setText(message);
            imgB.setColorFilter(lampOn);
            lampuB.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtB.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgB.setColorFilter(lampOff);
            lampuB.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtB.setTextColor(txtOff);
        }

        if(lampH){
            feedback.setText(message);
            imgH.setColorFilter(lampOn);
            lampuH.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtH.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgH.setColorFilter(lampOff);
            lampuH.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtH.setTextColor(txtOff);
        }

        if(lampC){
            feedback.setText(message);
            imgC.setColorFilter(lampOn);
            lampuC.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtC.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgC.setColorFilter(lampOff);
            lampuC.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtC.setTextColor(txtOff);
        }

        if(lampD){
            feedback.setText(message);
            imgD.setColorFilter(lampOn);
            lampuD.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtD.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgD.setColorFilter(lampOff);
            lampuD.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtD.setTextColor(txtOff);
        }

        if(lampE){
            feedback.setText(message);
            imgE.setColorFilter(lampOn);
            lampuE.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtE.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgE.setColorFilter(lampOff);
            lampuE.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtE.setTextColor(txtOff);
        }

        if(lampF){
            feedback.setText(message);
            imgF.setColorFilter(lampOn);
            lampuF.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtF.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgF.setColorFilter(lampOff);
            lampuF.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtF.setTextColor(txtOff);
        }

        if(lampG){
            feedback.setText(message);
            imgG.setColorFilter(lampOn);
            lampuG.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtG.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgG.setColorFilter(lampOff);
            lampuG.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtG.setTextColor(txtOff);
        }

        if(lampI){
            feedback.setText(message);
            imgI.setColorFilter(lampOn);
            lampuI.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtI.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgI.setColorFilter(lampOff);
            lampuI.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtI.setTextColor(txtOff);
        }

        if(lampJ){
            feedback.setText(message);
            imgJ.setColorFilter(lampOn);
            lampuJ.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtJ.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgJ.setColorFilter(lampOff);
            lampuJ.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtJ.setTextColor(txtOff);
        }

        if(lampK){
            feedback.setText(message);
            imgK.setColorFilter(lampOn);
            lampuK.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtK.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgK.setColorFilter(lampOff);
            lampuK.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtK.setTextColor(txtOff);
        }

        if(lampL){
            feedback.setText(message);
            imgL.setColorFilter(lampOn);
            lampuL.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
            txtL.setTextColor(txtOn);
        }else{
            feedback.setText(message);
            imgL.setColorFilter(lampOff);
            lampuL.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
            txtL.setTextColor(txtOff);
        }

        lampuA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampA){
                    message = "Offa";
                    feedback.setText(message);
                    imgA.setColorFilter(lampOff);
                    txtA.setTextColor(txtOff);
                    lampuA.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusA, false);
                    editor.apply();
                    lampA = false;
                    kirim();
                }else{
                    message = "Ona";
                    feedback.setText(message);
                    imgA.setColorFilter(lampOn);
                    txtA.setTextColor(txtOn);
                    lampuA.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusA, true);
                    editor.apply();
                    lampA = true;
                    kirim();
                }
            }
        });


        lampuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampB){
                    message = "Offb";
                    feedback.setText(message);
                    imgB.setColorFilter(lampOff);
                    txtB.setTextColor(txtOff);
                    lampuB.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusB, false);
                    editor.apply();
                    lampB = false;
                    kirim();
                }else{
                    message = "Onb";
                    feedback.setText(message);
                    imgB.setColorFilter(lampOn);
                    txtB.setTextColor(txtOn);
                    lampuB.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusB, true);
                    editor.apply();
                    lampB = true;
                    kirim();
                }
            }
        });

        lampuC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampC){
                    message = "Offc";
                    feedback.setText(message);
                    imgC.setColorFilter(lampOff);
                    txtC.setTextColor(txtOff);
                    lampuC.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusC, false);
                    editor.apply();
                    lampC = false;
                    kirim();
                }else{
                    message = "Onc";
                    feedback.setText(message);
                    imgC.setColorFilter(lampOn);
                    txtC.setTextColor(txtOn);
                    lampuC.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusC, true);
                    editor.apply();
                    lampC = true;
                    kirim();
                }
            }
        });

        lampuD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampD){
                    message = "Offd";
                    feedback.setText(message);
                    imgD.setColorFilter(lampOff);
                    txtD.setTextColor(txtOff);
                    lampuD.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusD, false);
                    editor.apply();
                    lampD = false;
                    kirim();
                }else{
                    message = "Ond";
                    feedback.setText(message);
                    imgD.setColorFilter(lampOn);
                    txtD.setTextColor(txtOn);
                    lampuD.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusD, true);
                    editor.apply();
                    lampD = true;
                    kirim();
                }
            }
        });

        lampuE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampE){
                    message = "Offe";
                    feedback.setText(message);
                    imgE.setColorFilter(lampOff);
                    txtE.setTextColor(txtOff);
                    lampuE.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusE, false);
                    editor.apply();
                    lampE = false;
                    kirim();
                }else{
                    message = "One";
                    feedback.setText(message);
                    imgE.setColorFilter(lampOn);
                    txtE.setTextColor(txtOn);
                    lampuE.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusE, true);
                    editor.apply();
                    lampE = true;
                    kirim();
                }
            }
        });

        lampuF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampF){
                    message = "Offf";
                    feedback.setText(message);
                    imgF.setColorFilter(lampOff);
                    txtF.setTextColor(txtOff);
                    lampuF.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusF, false);
                    editor.apply();
                    lampF = false;
                    kirim();
                }else{
                    message = "Onf";
                    feedback.setText(message);
                    imgF.setColorFilter(lampOn);
                    txtF.setTextColor(txtOn);
                    lampuF.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusF, true);
                    editor.apply();
                    lampF = true;
                    kirim();
                }
            }
        });

        lampuG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampG){
                    message = "Offg";
                    feedback.setText(message);
                    imgG.setColorFilter(lampOff);
                    txtG.setTextColor(txtOff);
                    lampuG.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusG, false);
                    editor.apply();
                    lampG = false;
                    kirim();
                }else{
                    message = "Ong";
                    feedback.setText(message);
                    imgG.setColorFilter(lampOn);
                    txtG.setTextColor(txtOn);
                    lampuG.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusG, true);
                    editor.apply();
                    lampG = true;
                    kirim();
                }
            }
        });

        lampuH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampH){
                    message = "Offh";
                    feedback.setText(message);
                    imgH.setColorFilter(lampOff);
                    txtH.setTextColor(txtOff);
                    lampuH.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusH, false);
                    editor.apply();
                    lampH = false;
                    kirim();
                }else{
                    message = "Onh";
                    feedback.setText(message);
                    imgH.setColorFilter(lampOn);
                    txtH.setTextColor(txtOn);
                    lampuH.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusH, true);
                    editor.apply();
                    lampH = true;
                    kirim();
                }
            }
        });

        lampuI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampI){
                    message = "Offi";
                    feedback.setText(message);
                    imgI.setColorFilter(lampOff);
                    txtI.setTextColor(txtOff);
                    lampuI.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusI, false);
                    editor.apply();
                    lampI = false;
                    kirim();
                }else{
                    message = "Oni";
                    feedback.setText(message);
                    imgI.setColorFilter(lampOn);
                    txtI.setTextColor(txtOn);
                    lampuI.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusI, true);
                    editor.apply();
                    lampI = true;
                    kirim();
                }
            }
        });

        lampuJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampJ){
                    message = "Offj";
                    feedback.setText(message);
                    imgJ.setColorFilter(lampOff);
                    txtJ.setTextColor(txtOff);
                    lampuJ.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusJ, false);
                    editor.apply();
                    lampJ = false;
                    kirim();
                }else{
                    message = "Onj";
                    feedback.setText(message);
                    imgJ.setColorFilter(lampOn);
                    txtJ.setTextColor(txtOn);
                    lampuJ.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusJ, true);
                    editor.apply();
                    lampJ = true;
                    kirim();
                }
            }
        });

        lampuK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampK){
                    message = "Offk";
                    feedback.setText(message);
                    imgK.setColorFilter(lampOff);
                    txtK.setTextColor(txtOff);
                    lampuK.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusK, false);
                    editor.apply();
                    lampK = false;
                    kirim();
                }else{
                    message = "Onk";
                    feedback.setText(message);
                    imgK.setColorFilter(lampOn);
                    txtK.setTextColor(txtOn);
                    lampuK.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusK, true);
                    editor.apply();
                    lampK = true;
                    kirim();
                }
            }
        });

        lampuL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lampL){
                    message = "Offl";
                    feedback.setText(message);
                    imgL.setColorFilter(lampOff);
                    txtL.setTextColor(txtOff);
                    lampuL.setBackgroundTintList(getResources().getColorStateList(R.color.primary4));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusL, false);
                    editor.apply();
                    lampL = false;
                    kirim();
                }else{
                    message = "Onl";
                    feedback.setText(message);
                    imgL.setColorFilter(lampOn);
                    txtL.setTextColor(txtOn);
                    lampuL.setBackgroundTintList(getResources().getColorStateList(R.color.primary1));
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(session_statusL, true);
                    editor.apply();
                    lampL = true;
                    kirim();
                }
            }
        });
    }

    public void kirim(){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, message, null, null);
        Toast.makeText(getApplicationContext(), "SMS terkirim",
                Toast.LENGTH_LONG).show();
    }


    public void ambilSession() {
        sharedpreferences = this.getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        phoneNo = this.getIntent().getStringExtra(TAG_NO_PERANGKAT);
        no_pengguna = this.getIntent().getStringExtra(TAG_NO_PENGGUNA);
        no_perangkat = this.getIntent().getStringExtra(TAG_NO_PERANGKAT);
        lampA = this.getIntent().getBooleanExtra(session_statusA, false);
        lampB = this.getIntent().getBooleanExtra(session_statusB, false);
        lampC = this.getIntent().getBooleanExtra(session_statusC, false);
        lampD = this.getIntent().getBooleanExtra(session_statusD, false);
        lampE = this.getIntent().getBooleanExtra(session_statusE, false);
        lampF = this.getIntent().getBooleanExtra(session_statusF, false);
        lampG = this.getIntent().getBooleanExtra(session_statusG, false);
        lampH = this.getIntent().getBooleanExtra(session_statusH, false);
        lampI = this.getIntent().getBooleanExtra(session_statusI, false);
        lampJ = this.getIntent().getBooleanExtra(session_statusJ, false);
        lampK = this.getIntent().getBooleanExtra(session_statusK, false);
        lampL = this.getIntent().getBooleanExtra(session_statusL, false);
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
        Boolean A,B,C,D,E,F,G,H,I,J,K,L;
        A = false;
//        B = LampB;
//        C = LampC;
//        D = LampD;
//        E = LampE;
//        F = LampF;
//        G = LampG;
//        H = LampH;
//        I = LampI;
//        J = LampJ;
//        K = LampK;
//        L = LampL;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(TAG_LAMPU_A, true);
        editor.putBoolean(TAG_LAMPU_B, true);
        editor.putBoolean(TAG_LAMPU_C, true);
        editor.putBoolean(TAG_LAMPU_D, true);
        editor.putBoolean(TAG_LAMPU_E, true);
        editor.putBoolean(TAG_LAMPU_F, true);
        editor.putBoolean(TAG_LAMPU_G, true);
        editor.putBoolean(TAG_LAMPU_H, true);
        editor.putBoolean(TAG_LAMPU_I, true);
        editor.putBoolean(TAG_LAMPU_J, true);
        editor.putBoolean(TAG_LAMPU_K, true);
        editor.putBoolean(TAG_LAMPU_L, true);
        editor.apply();

    }
}