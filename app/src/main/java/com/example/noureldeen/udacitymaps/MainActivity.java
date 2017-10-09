package com.example.noureldeen.udacitymaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    GoogleMap googleMap;
    boolean mapReady= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        Button btnSatellite = (Button) findViewById(R.id.btnSatellite);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        Button btnHybird = (Button) findViewById(R.id.btnHybird);
        btnHybird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        Button btnEgypt = (Button) findViewById(R.id.btnEgypt);
        btnEgypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng latLng = new LatLng(26.8206,30.8025);
                CameraPosition cameraPosition = CameraPosition.builder().target(latLng).bearing(113).tilt(70).zoom(10).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),5000,null);
            }
        });
        Button btnTokyo = (Button) findViewById(R.id.btnTokyo);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng latLng = new LatLng(35.6895,139.6917);
                CameraPosition cameraPosition = CameraPosition.builder().target(latLng).bearing(113).tilt(70).zoom(10).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),5000,null);
            }
        });
        Button btnGermany = (Button) findViewById(R.id.btnGermany);
        btnGermany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng latLng = new LatLng(51.1657,10.4515);
                CameraPosition cameraPosition = CameraPosition.builder().target(latLng).bearing(113).tilt(70).zoom(10).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),5000,null);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        this.googleMap = googleMap;
        LatLng maadi = new LatLng(29.986370,31.289333);
        CameraPosition cameraPosition = CameraPosition.builder().target(maadi).bearing(113).tilt(70).zoom(20).build();
        //this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),5000,null);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(maadi);
        markerOptions.title("My Home");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        this.googleMap.addMarker(markerOptions);
        this.googleMap.addCircle(new CircleOptions().center(maadi).radius(100).fillColor(Color.BLUE).strokeColor(Color.GREEN));
    }
}
