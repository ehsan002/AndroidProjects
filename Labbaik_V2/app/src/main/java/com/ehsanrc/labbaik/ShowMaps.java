package com.ehsanrc.labbaik;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class ShowMaps extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;

    LatLng latLng, haram, kaaba, sayee, mina, arafat, muzdalifa, jamarat, nababi;
    Marker currLocationMarker;

    Button button;

    Location mLastLocation;

    ArrayList<String> testList = new ArrayList<>();

    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_maps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        id = getIntent().getIntExtra("extra", 0);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        button = (Button) findViewById(R.id.btn_test);

    }

//    @Override
//    protected void onStart() {
//        mGoogleApiClient.connect();
//        super.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        mGoogleApiClient.disconnect();
//        super.onStop();
//    }

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

        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        buildGoogleApiClient();

        mGoogleApiClient.connect();

        haram = new LatLng(21.422872, 39.825736);
        kaaba = new LatLng(21.422524, 39.826225);
        sayee = new LatLng(21.423523, 39.827362);
        mina = new LatLng(21.414608, 39.894887);
        arafat = new LatLng(21.347706, 39.986368);
        muzdalifa = new LatLng(21.387907, 39.914443);
        jamarat = new LatLng(21.422408, 39.869713);
        nababi = new LatLng(24.467259, 39.611131);

        Log.i("msg", Integer.toString(id));

        if (id == 2) {
            mMap.addMarker(new MarkerOptions().position(haram).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haram, 15));
            getSupportActionBar().setTitle("মাসজিদুল হারাম");
        }
        if (id == 3) {
            mMap.addMarker(new MarkerOptions().position(kaaba).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kaaba, 15));
            getSupportActionBar().setTitle("কাবা");
        }
        if (id == 4) {
            mMap.addMarker(new MarkerOptions().position(sayee).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sayee, 15));
            getSupportActionBar().setTitle("সাফা-মারওয়া");
        }
        if (id == 5) {
            mMap.addMarker(new MarkerOptions().position(mina).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mina, 15));
            getSupportActionBar().setTitle("মিনা");
        }
        if (id == 6) {
            mMap.addMarker(new MarkerOptions().position(arafat).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arafat, 15));
            getSupportActionBar().setTitle("আরাফাত");
        }
        if (id == 7) {
            mMap.addMarker(new MarkerOptions().position(muzdalifa).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(muzdalifa, 15));
            getSupportActionBar().setTitle("মুযদালিফা");
        }
        if (id == 9) {
            mMap.addMarker(new MarkerOptions().position(nababi).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nababi, 15));
            getSupportActionBar().setTitle("মাসজিদুন নববী");
        }
        if (id == 8) {
            mMap.addMarker(new MarkerOptions().position(jamarat).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jamarat, 15));
            getSupportActionBar().setTitle("জামারাত");
        }

    }

    protected synchronized void buildGoogleApiClient() {
        //Toast.makeText(this, "buildGoogleApiClient", Toast.LENGTH_SHORT).show();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Toast.makeText(this, "onConnected", Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(20 * 60 * 1000); //set the interval in which you want to get locations
        mLocationRequest.setFastestInterval(15 * 60 * 1000); //if a location is available sooner you can get it
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);


    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "onConnectionSuspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "onConnectionSuspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (currLocationMarker != null) {
            currLocationMarker.remove();
        }
        //latLng = new LatLng(location.getLatitude(), location.getLongitude());

        if (id == 1) {

            button.setVisibility(View.GONE);
            getSupportActionBar().setTitle("আপনার অবস্থান");
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(id == 1){

//                    TextView textView = (TextView) findViewById(R.id.testTv);
//                    textView.setText(testList.get(testList.size()-1));
                }

                if (id == 2) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haram, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, haram).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 3) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kaaba, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, kaaba).width(5).color(Color.BLUE)
                            .geodesic(true));
                }
                if (id == 4) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sayee, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, sayee).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 5) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mina, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, mina).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 6) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arafat, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, arafat).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 7) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(muzdalifa, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, muzdalifa).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 8) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jamarat, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, jamarat).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                if (id == 9) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nababi, 20));

                    mMap.addPolyline((new PolylineOptions())
                            .add(latLng, nababi).width(5).color(Color.BLUE)
                            .geodesic(true));
                }

                button.setVisibility(View.GONE);
            }
        });

//        for(int i =0;i<testList.size();i++)
//        {
//            Log.i("msg",testList.get(i).toString());
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onBackPressed();
        return true;
    }
}
