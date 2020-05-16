package com.rianprojek.kenalisuaraku;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreCounting extends AppCompatActivity {
    int skor;
    public final static String EXTRA_MESSAGE="com.example.myHelloAndroid.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_counting);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.skor100);
        mp.start();

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/ComicSansMSRegular.ttf");

        TextView label = findViewById(R.id.label_skor);
        TextView ucapan = findViewById(R.id.textUcapan);
        TextView ulangi = findViewById(R.id.textUlangi);
        TextView penjelasan = findViewById(R.id.textPenjelasan);
        TextView feedback = findViewById(R.id.textFeedback);
        ImageView skorImage = findViewById(R.id.imageSkor);

        label.setTypeface(custom_font);
        ucapan.setTypeface(custom_font);
        ulangi.setTypeface(custom_font);
        penjelasan.setTypeface(custom_font);
        feedback.setTypeface(custom_font);

        Intent intent = getIntent();
        String nama = intent.getStringExtra(InputProfile.EXTRA_MESSAGE);

        Bundle b = getIntent().getExtras();
        skor = b.getInt("skor");

        if (skor == 100){
            skorImage.setBackgroundResource(R.drawable.skor100);
            ucapan.setText("Luar Biasa!");
        }else if (skor == 80){
            skorImage.setBackgroundResource(R.drawable.skor80);
            ucapan.setText("Kerja bagus!");
        }else if (skor == 60){
            ucapan.setText("Lumayan");
        }else if (skor == 40){
            ucapan.setText("Sedikit lagi!");
        }else if (skor == 20){
            ucapan.setText("Sayang sekali");
        }else {
            ucapan.setText("Yahh :(");
        }
    }

    public void mainUlang(View view) {
        Intent ulang = new Intent(this, InputProfile.class);
        startActivity(ulang);
    }
}
