package com.example.farshid.myproject_robofa.Location;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farshid.myproject_robofa.R;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements LocationListener {
    double latx, lony;
    public LatLng origen;
    MapView mapview;
    double gLat2, glng2;
    private GoogleMap googleMap;
    String Kind = "";
    TextView Maptoolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Maptoolbar_title = findViewById(R.id.Maptoolbar_title);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Kind = extras.getString("Kind");
            switch (Kind) {

                case "1": {
                    gLat2 = 38.391090;
                    glng2 = 47.666506;
                    Maptoolbar_title.setText("موقعیت کانون نرجس ");
                    break;
                }
                case "2": {
                    gLat2 = 38.384605;
                    glng2 = 47.681792;
                    Maptoolbar_title.setText("موقعیت آموزشگاه آرش");
                    break;
                }
                case "3": {
                    gLat2 = 38.393569;
                    glng2 = 47.685320;
                    Maptoolbar_title.setText("موقعیت کانون علامه طباطبایی");
                    break;
                }
                case "4": {
                    gLat2 = 38.404354;
                    glng2 = 47.680096;
                    Maptoolbar_title.setText("موقعیت آموزشگاه استارمس");
                    break;
                }
                case "5": {
                    gLat2 = 38.397817;
                    glng2 = 47.673338;
                    Maptoolbar_title.setText("موقعیت آموزشگاه دهکده زبان");
                    break;
                }

            }
        }
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        android.location.LocationListener locationListener = new Mylocation();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, locationListener);
        mapview = findViewById(R.id.Mapq2);
        mapview.onCreate(savedInstanceState);
        mapview.onResume();
        try {
            MapsInitializer.initialize(this.getApplicationContext());
        } catch (Exception e) {
        }
        googleMap = mapview.getMap();
        LatLng sydney = new LatLng(gLat2, glng2);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("موقعیت").snippet("کانون آموزشی نرجس").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconlocation)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

//        CircleOptions circleOptions = new CircleOptions().center(new LatLng(gLat2, glng2)).radius(3000).strokeColor(Color.RED);
//        Circle circle = googleMap.addCircle(circleOptions);
//        CircleOptions circleOptions = new CircleOptions().center(new LatLng(38.3945697, 47.666616)).radius(2000).strokeColor(Color.CYAN);
//        Circle circle = googleMap.addCircle(circleOptions);
/////////////////////////////////////////////////////////////////////////////////
//

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    class Mylocation implements android.location.LocationListener {
        @Override
        public void onLocationChanged(android.location.Location location) {
            latx = location.getLatitude();
            lony = location.getLongitude();
            origen = new LatLng(latx, lony);
            googleMap.addMarker(new MarkerOptions().position(origen).title("my location"));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
