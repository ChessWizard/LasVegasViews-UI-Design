package com.chess.lasvegasviews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.chess.lasvegasviews.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    Animation from_buttom;

    Intent intent2;
    ActivityOptions options;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Check RoadMap butonumuza renk vermek
        binding.roadmapButton.setBackgroundColor(Color.parseColor("#469FEC"));// Color class'i icerisindeki parseColor methodu ile int olan color degerini hex koduna ceviriyoruz.

        // NOT: Biz sadece sayfalar arasi gecis yapiyoruz. Sayfalar arasi veri gonderseydik buna ihtiyacimiz olurdu!
        //Intent intent = getIntent();// Sayfaya gecis yapilma isteiginin alinmasini saglar.
                                    // getIntent() metodu Intent tipinde bir deger dondurdugu icin Intent nesnesine ataniyor.

        from_buttom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        binding.downArrow.setAnimation(from_buttom);
        binding.thirdScrollView.setAnimation(from_buttom);



        binding.roadmapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,CheckRoadMap_1.class);
                startActivity(intent);

            }
        });




    }

    public void back_from_details(View view){
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);


        Pair[] pairs = new Pair[1];// 1 elemanli bir "ciftleri tutacak" dizi.
        pairs[0] = new Pair<View,String>(binding.downArrow,"background_image_transition");// Animasyon icin kullanilacak nesne(baslatacak nesne),animasyonun ismi

        //Animasyonlarimizi "aktiviteler arasi" tasiyabilmek icin kullanilir. -> Aktiviteler arasi sahne animasyonu.
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity3.this,pairs);

        startActivity(intent,options.toBundle());// Aktiviteler arasi veri aktarimi Intent ve Bundle class'lari ile olur.
                                                 // Basta sayfayi tasimak icin intent kullandik. Animasyonu tasimak icin ise toBundle() ile Bundle'a cevirerek tasiyoruz.


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
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