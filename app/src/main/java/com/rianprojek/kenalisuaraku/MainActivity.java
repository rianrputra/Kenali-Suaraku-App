package com.rianprojek.kenalisuaraku;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titel = findViewById(R.id.titel);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        titel.startAnimation(anim);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/ComicSansMSRegular.ttf");
        titel.setTypeface(custom_font);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.opening_bgm);
        mp.start();

    }

    public void startGame(View view) {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.start_sfx);
        mp.start();
        final Intent intent = new Intent(this, InputProfile.class);
        startActivity(intent);

    }
}
