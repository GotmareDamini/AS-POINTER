package com.example.as_pointer;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maps );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng place = new LatLng( 21.207558, 78.975252 );
        mMap.addMarker( new MarkerOptions().position( place ).title( "S.B. JAIN Road" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( place, 16f ) );

        LatLng place1 = new LatLng( 21.213315, 78.973355 );
        mMap.addMarker( new MarkerOptions().position( place1 ).title( "S.B. JAIN T-Point" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( place1, 16f ) );

        LatLng place2 = new LatLng( 21.207236, 78.981408 );
        mMap.addMarker( new MarkerOptions().position( place2 ).title( "Hanuman Mandir" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( place2, 16f ) );

        LatLng place3 = new LatLng( 21.192051, 79.016649 );
        mMap.addMarker( new MarkerOptions().position( place3 ).title( "Gorewada Tiger Reserve" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( place3, 16f ) );

        LatLng place4 = new LatLng( 21.184333, 79.031647 );
        mMap.addMarker( new MarkerOptions().position( place4 ).title( "Katol Naka" ) );
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom( place4, 16f ) );
    }
}
