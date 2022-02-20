package com.chess.lasvegasviews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.chess.lasvegasviews.databinding.ActivityMain2Binding;
import com.chess.lasvegasviews.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {


    Animation from_left,from_right,from_bottom;

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        // Kullanilacak animasyonlar tanimlandi
        from_left = AnimationUtils.loadAnimation(this,R.anim.anim_from_left);
        from_right = AnimationUtils.loadAnimation(this,R.anim.anim_from_right);
        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        // Animasyonlar nesneler uzerinde isleniyor
        binding.secondBackArrow.setAnimation(from_left);
        binding.secondTitle.setAnimation(from_right);
        binding.secondSubtitle.setAnimation(from_right);
        binding.secondRatingBar.setAnimation(from_left);
        binding.secondRatingNumber.setAnimation(from_right);
        binding.secondRatingNumber2.setAnimation(from_right);
        binding.secondArrowUp.setAnimation(from_bottom);
        binding.moreDetails.setAnimation(from_bottom);

    }

    public void back_arrow(View view){
        Intent intent  = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    public void up_arrow(View view){
        Intent intent  = new Intent(MainActivity2.this,MainActivity3.class);


        Pair[] pairs = new Pair[1];// 1 elemanli bir "ciftleri tutacak" dizi.
        pairs[0] = new Pair<View,String>(binding.secondArrowUp,"background_image_transition");// Animasyon icin kullanilacak nesne(baslatacak nesne),animasyonun ismi

        //Animasyonlarimizi "aktiviteler arasi" tasiyabilmek icin kullanilir. -> Aktiviteler arasi sahne animasyonu.
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this,pairs);
        startActivity(intent,options.toBundle());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    // Ekrani "tam ekran" halinde goruntulemek icin yontem.
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}