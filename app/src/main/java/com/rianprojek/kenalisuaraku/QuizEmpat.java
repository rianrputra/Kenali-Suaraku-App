package com.rianprojek.kenalisuaraku;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizEmpat extends AppCompatActivity {
    int opsi = 0;
    int skor;
    int buttonPilih = 0;
    public final static String EXTRA_MESSAGE="com.example.myHelloAndroid.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_empat);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/ComicSansMSRegular.ttf");

        TextView hai = findViewById(R.id.textView2);
        TextView tampilnama = findViewById(R.id.text_nama);
        TextView labelskor = findViewById(R.id.label_skor);
        TextView isiskor = findViewById(R.id.jumlahSkor);
        TextView question = findViewById(R.id.question);
        Button pilih = findViewById(R.id.buttonPilih);
        Button lanjut = findViewById(R.id.buttonLanjut);
        RadioGroup rg = findViewById(R.id.radioGrupOpsi);

        hai.setTypeface(custom_font);
        tampilnama.setTypeface(custom_font);
        labelskor.setTypeface(custom_font);
        isiskor.setTypeface(custom_font);
        question.setTypeface(custom_font);
        pilih.setTypeface(custom_font);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(InputProfile.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_nama);
        textView.setText(nama);

        Bundle b = getIntent().getExtras();
        skor = b.getInt("skor");

        TextView textSkor = findViewById(R.id.jumlahSkor);
        textSkor.setText("" + skor);

        pilih.setVisibility(View.GONE);

        lanjut.setVisibility(View.GONE);

        rg.setVisibility(View.GONE);
    }

    private void displaySkor (int skor){
        TextView dispSkor = findViewById(R.id.jumlahSkor);
        dispSkor.setText("" + skor);
    }

    public void pilihJawaban(View view) {
        buttonPilih = 0;
        String next = "lanjut";

        LayoutInflater inflater = getLayoutInflater();
        View toastBenar = inflater.inflate(R.layout.activity_toast_benar, (ViewGroup) findViewById(R.id.toastBenar));
        View toastSalah = inflater.inflate(R.layout.activity_toast_salah, (ViewGroup) findViewById(R.id.toastSalah));

        Toast benar = new Toast(this);
        benar.setView(toastBenar);

        Toast salah = new Toast(this);
        salah.setView(toastSalah);

        RadioGroup pilihanOpsi = findViewById(R.id.radioGrupOpsi);
        pilihanOpsi.setVisibility(View.GONE);

        if (buttonPilih == 0){
            if (opsi == 2){
                benar.show();
                skor = skor + 20;
                displaySkor(skor);
                final MediaPlayer playBenar = MediaPlayer.create(this, R.raw.benar_sound);
                playBenar.start();
                buttonPilih = 1;
                Button pilih = findViewById(R.id.buttonPilih);
                pilih.setVisibility(View.GONE);
                ImageButton benerBro = findViewById(R.id.imgBtnDua);
                benerBro.setBackgroundResource(R.drawable.bener_bro);
                Button lanjut = findViewById(R.id.buttonLanjut);
                lanjut.setVisibility(View.VISIBLE);
            } else if (opsi == 1) {
                salah.show();
                final MediaPlayer playSalah = MediaPlayer.create(this, R.raw.salah_sound);
                playSalah.start();
                buttonPilih = 1;
                Button pilih = findViewById(R.id.buttonPilih);
                pilih.setVisibility(View.GONE);
                Button lanjut = findViewById(R.id.buttonLanjut);
                lanjut.setVisibility(View.VISIBLE);
                ImageButton salahBro = findViewById(R.id.imgBtnSatu);
                salahBro.setBackgroundResource(R.drawable.salah_bro);
            } else {
                salah.show();
                final MediaPlayer playSalah = MediaPlayer.create(this, R.raw.salah_sound);
                playSalah.start();
                buttonPilih = 1;
                Button pilih = findViewById(R.id.buttonPilih);
                pilih.setVisibility(View.GONE);
                Button lanjut = findViewById(R.id.buttonLanjut);
                lanjut.setVisibility(View.VISIBLE);
                ImageButton salahBro = findViewById(R.id.imgBtnTiga);
                salahBro.setBackgroundResource(R.drawable.salah_bro);
            }
        }else {
            Button pilih = findViewById(R.id.buttonPilih);
            pilih.setVisibility(View.GONE);
            pilih.setActivated(false);
            Button lanjut = findViewById(R.id.buttonLanjut);
            lanjut.setVisibility(View.VISIBLE);
        }

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/ComicSansMSRegular.ttf");
        Button lanjut = findViewById(R.id.buttonLanjut);
        lanjut.setTypeface(custom_font);

    }

    public void lanjutQuiz(View view) {
        final Intent intent = new Intent(this, QuizLima.class);
        Bundle b = new Bundle();
        b.putInt("skor", skor);
        intent.putExtras(b);

        TextView isinama = findViewById(R.id.text_nama);
        String nama = isinama.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, nama);

        startActivity(intent);
    }

    public void opsiSatu(View view) {
        opsi = 1;
        Button pilih = findViewById(R.id.buttonPilih);
        pilih.setVisibility(View.VISIBLE);
    }

    public void opsiDua(View view) {
        opsi = 2;
        Button pilih = findViewById(R.id.buttonPilih);
        pilih.setVisibility(View.VISIBLE);
    }

    public void opsiTiga(View view) {
        opsi = 3;
        Button pilih = findViewById(R.id.buttonPilih);
        pilih.setVisibility(View.VISIBLE);
    }


    public void playAudio(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.chicken_sound);
        mp.start();
    }

    public void cekOpsiSatu(View view) {
        RadioButton opsiSatu = findViewById(R.id.radButtonSatu);
        opsiSatu.setChecked(true);
        opsi = 1;
        if (buttonPilih == 0){
            Button pilih = findViewById(R.id.buttonPilih);
            pilih.setVisibility(View.VISIBLE);
            ImageButton imageSatu = findViewById(R.id.imgBtnSatu);
            ImageButton imageDua = findViewById(R.id.imgBtnDua);
            ImageButton imageTiga = findViewById(R.id.imgBtnTiga);
            imageSatu.setBackgroundResource(R.drawable.selected);
            imageDua.setBackgroundResource(R.drawable.blank);
            imageTiga.setBackgroundResource(R.drawable.blank);
        }else {

        }
    }

    public void cekOpsiDua(View view) {
        RadioButton opsiDua = findViewById(R.id.radButtonDua);
        opsiDua.setChecked(true);
        opsi = 2;
        if (buttonPilih == 0){
            Button pilih = findViewById(R.id.buttonPilih);
            pilih.setVisibility(View.VISIBLE);
            ImageButton imageSatu = findViewById(R.id.imgBtnSatu);
            ImageButton imageDua = findViewById(R.id.imgBtnDua);
            ImageButton imageTiga = findViewById(R.id.imgBtnTiga);
            imageSatu.setBackgroundResource(R.drawable.blank);
            imageDua.setBackgroundResource(R.drawable.selected);
            imageTiga.setBackgroundResource(R.drawable.blank);
        }else {

        }
    }

    public void cekOpsiTiga(View view) {
        RadioButton opsiTiga = findViewById(R.id.radButtonTiga);
        opsiTiga.setChecked(true);
        opsi = 3;
        if (buttonPilih == 0){
            Button pilih = findViewById(R.id.buttonPilih);
            pilih.setVisibility(View.VISIBLE);
            ImageButton imageSatu = findViewById(R.id.imgBtnSatu);
            ImageButton imageDua = findViewById(R.id.imgBtnDua);
            ImageButton imageTiga = findViewById(R.id.imgBtnTiga);
            imageSatu.setBackgroundResource(R.drawable.blank);
            imageDua.setBackgroundResource(R.drawable.blank);
            imageTiga.setBackgroundResource(R.drawable.selected);
        }else {

        }
    }
}
