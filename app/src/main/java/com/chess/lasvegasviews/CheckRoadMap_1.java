package com.chess.lasvegasviews;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.chess.lasvegasviews.databinding.ActivityCheckRoadMap1Binding;

public class CheckRoadMap_1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityCheckRoadMap1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCheckRoadMap1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;// Haritadan delecek deger kendi GoogleMap degiskenimize ataniyor.

        LatLng stratHotel = new LatLng(36.1475119,-115.1565537);// Latitude and Longtitude (koorfinatlar) class'i icerisine gidilecek konumun eksenleri yerlestirilir.
        MarkerOptions marker = new MarkerOptions();// MarkerOptions class'indan uretilen nesne sayesinde haritamiza marker eklenebilir.
        mMap.addMarker(marker.position(stratHotel).title("Strat Hotel-Skypod"));// Haritamizda girdigimiz koordinatlar icin kirmizi isaretci koyduk ve bu isaretciye baslik verdik.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stratHotel,15));// CameraUpdateFactory class'i icerisindeki static newLatLngZoom metoduna eriserek kameranin belli yakinlik oranina gore hareketi saglanmistir.
    }
}