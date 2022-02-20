package com.chess.lasvegasviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.chess.lasvegasviews.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    // Sayfamiz icin animasyonlar hazirlayacagiz.

    //CardView cardview1,cardview2,cardview3;// Cardview'larimizi global olarak tanimladik.
    Animation anim_from_bottom,anim_from_top,anim_from_left;// Animasyon resource'larimizi kullanabilmek icin tanimlayacagiz.

    // Animasyon ekelemk icin diger nesnelerimizi de ekliyoruz.
    // NOT: Gerek yoktur. Cunku hepsini binding ile yapiyoruz!

    //ImageView imageView;// Ayarlar butonu icin animasyon ekleyecegiz.
    //TextView textView,textView2,textView3,textView4,textView5;// Baslikta yazan yazilar icin animasyon ekleyecegiz.

    private ActivityMainBinding binding;// Binding jetpack yapisi ile nesnelerin id'lerini bulmadan dogurdan erisebiliriz.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);




        // Yarattigimiz animasyonu kullanabilmek icin tanimliyoruz.
        // AnimationUtils class'i icerisindeki static method olan loadAnimation ile bu eklemeyi gerceklestirdik.
        // AnimationUtils.loadAnimation(bulunulan aktivite,R.anim.animasyon kaynaginin ismi -> animasyonun baglanti yolu(bulundugu dosya) eklenir);
        // Not: loadAnimation methodu static oldugundan dolayi class ismi ile ulasildi.
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this,R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this,R.anim.anim_from_left);

        // Cardview'lar icin animasyonlar
        binding.cardview1.setAnimation(anim_from_bottom);// Yarattigimiz animasyonu cardview'da goruntulenmesi icin setAnimation() methodu ile ekliyoruz.
                                                         // Bu method cardview'un parent class'i olan view class'indan gelir.
        binding.cardview2.setAnimation(anim_from_bottom);
        binding.cardview3.setAnimation(anim_from_bottom);

        // Ayarlar butonu ve baslik icin animasyonlar
        binding.imageView.setAnimation(anim_from_top);
        binding.firstText.setAnimation(anim_from_top);
        binding.textView2.setAnimation(anim_from_top);
        binding.textView3.setAnimation(anim_from_top);
        binding.textView4.setAnimation(anim_from_top);
        binding.textView5.setAnimation(anim_from_top);

        // Arama butonu icin animasyon
        binding.searchView.setAnimation(anim_from_left);
    }

    public void card1(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
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