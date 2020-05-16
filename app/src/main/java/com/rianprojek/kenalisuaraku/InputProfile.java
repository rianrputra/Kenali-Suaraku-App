package com.rianprojek.kenalisuaraku;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class InputProfile extends AppCompatActivity {

    EditText etNama;

    public final static String EXTRA_MESSAGE="com.example.myHelloAndroid.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_profile);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/ComicSansMSRegular.ttf");

        TextView judul = findViewById(R.id.header);
        EditText input_nama = findViewById(R.id.editNama);
        TextView ket_mulai = findViewById(R.id.textMulai);
        final TextView required = findViewById(R.id.textRequired);
        final ImageButton btn_mulai = findViewById(R.id.btnMulai);

        judul.setTypeface(custom_font);
        input_nama.setTypeface(custom_font);
        ket_mulai.setTypeface(custom_font);
        required.setVisibility(View.GONE);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.game_bgm);
        mp.start();



    }

    public void startQuiz(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.start_sfx);
        mp.start();
        Intent intent = new Intent(this, QuizSatu.class);
        EditText nama = findViewById(R.id.editNama);
        String isinama = nama.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, isinama);
        startActivity(intent);
    }
}
