package com.example.as_pointer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Home extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_home, container, false );

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById( R.id.map1 );
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
