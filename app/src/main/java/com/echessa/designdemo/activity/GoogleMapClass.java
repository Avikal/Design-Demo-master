package com.echessa.designdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.echessa.designdemo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by avikal on 1/5/2016.
 */
public class GoogleMapClass extends AppCompatActivity {

    String indore, ratlam;
    boolean location_city;
    Bundle bundle;
    private GoogleMap googleMap;
    double latitude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_map_xml);
        bundle = getIntent().getExtras();
//        indore = bundle.getString("Indore");
        location_city = bundle.getBoolean("location_city");
        try {
            // Loading map
            initilizeMap();

            // Changing map type
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

            // Showing / hiding your current location
            googleMap.setMyLocationEnabled(true);

            // Enable / Disable zooming controls
            googleMap.getUiSettings().setZoomControlsEnabled(false);

            // Enable / Disable my location button
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Enable / Disable Compass icon
            googleMap.getUiSettings().setCompassEnabled(true);

            // Enable / Disable Rotate gesture
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            // Enable / Disable zooming functionality
            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            if(location_city)
            {
                latitude = 22.725313;
                longitude = 75.865555;
            }
            else if(location_city==false)
            {
                latitude = 23.3341696;
                longitude = 75.0376325;
            }


            // lets place some 10 random markers
//            for (int i = 0; i < 10; i++) {
                // random latitude and logitude
                double[] randomLocation = createRandLocation(latitude,
                        longitude);

                // Adding a marker
                MarkerOptions marker = new MarkerOptions().position(
                        new LatLng(randomLocation[0], randomLocation[1]))
                        .title("Hello Maps ");

                Log.e("Random", "> " + randomLocation[0] + ", "
                        + randomLocation[1]);

                // changing marker color
//                if (i == 0)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//                if (i == 1)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//                if (i == 2)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
//                if (i == 3)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//                if (i == 4)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//                if (i == 5)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
//                if (i == 6)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_RED));
//                if (i == 7)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
//                if (i == 8)
//                    marker.icon(BitmapDescriptorFactory
//                            .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
//                if (i == 9)
                    marker.icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

                googleMap.addMarker(marker);

                // Move the camera to last position with a zoom level
//                if (i == 9) {
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(new LatLng(randomLocation[0],
                                    randomLocation[1])).zoom(15).build();

                    googleMap.animateCamera(CameraUpdateFactory
                            .newCameraPosition(cameraPosition));
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    /**
     * function to load map If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    /*
     * creating random postion around a location for testing purpose only
     */
    private double[] createRandLocation(double latitude, double longitude) {

        return new double[] { latitude + ((Math.random() - 0.5) / 500),
                longitude + ((Math.random() - 0.5) / 500),
                150 + ((Math.random() - 0.5) * 10) };
    }
}


