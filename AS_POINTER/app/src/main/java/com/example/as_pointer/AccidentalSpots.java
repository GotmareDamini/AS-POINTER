package com.example.as_pointer;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AccidentalSpots extends Fragment {


    ConstraintLayout expandableView, expandableView1, expandableView2, expandableView3, expandableView4;
    Button arrowBtn, arrowBtn1, arrowBtn2, arrowBtn3, arrowBtn4;
    CardView cardView, cardView1, cardView2, cardView3, cardView4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate( R.layout.fragment_accidental_spots, container, false );
        expandableView = view.findViewById( R.id.expandableView );
        arrowBtn = view.findViewById( R.id.arrowBtn );
        cardView = view.findViewById( R.id.cardView );

        expandableView1 = view.findViewById( R.id.expandableView1 );
        arrowBtn1 = view.findViewById( R.id.arrowBtn1 );
        cardView1 = view.findViewById( R.id.cardView1 );

        expandableView2 = view.findViewById( R.id.expandableView2 );
        arrowBtn2 = view.findViewById( R.id.arrowBtn2 );
        cardView2 = view.findViewById( R.id.cardView2 );

        expandableView3 = view.findViewById( R.id.expandableView3 );
        arrowBtn3 = view.findViewById( R.id.arrowBtn3 );
        cardView3 = view.findViewById( R.id.cardView3 );

        expandableView4 = view.findViewById( R.id.expandableView4 );
        arrowBtn4 = view.findViewById( R.id.arrowBtn4 );
        cardView4 = view.findViewById( R.id.cardView4 );

        arrowBtn.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition( cardView, new AutoTransition() );
                    expandableView.setVisibility( View.VISIBLE );
                    arrowBtn.setBackgroundResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                } else {
                    TransitionManager.beginDelayedTransition( cardView, new AutoTransition() );
                    expandableView.setVisibility( View.GONE );
                    arrowBtn.setBackgroundResource( R.drawable.ic_keyboard_arrow_down_black_24dp );
                }
            }
        } );


        arrowBtn1.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition( cardView1, new AutoTransition() );
                    expandableView1.setVisibility( View.VISIBLE );
                    arrowBtn1.setBackgroundResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                } else {
                    TransitionManager.beginDelayedTransition( cardView1, new AutoTransition() );
                    expandableView1.setVisibility( View.GONE );
                    arrowBtn1.setBackgroundResource( R.drawable.ic_keyboard_arrow_down_black_24dp );
                }
            }
        } );

        arrowBtn2.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (expandableView2.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition( cardView2, new AutoTransition() );
                    expandableView2.setVisibility( View.VISIBLE );
                    arrowBtn2.setBackgroundResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                } else {
                    TransitionManager.beginDelayedTransition( cardView2, new AutoTransition() );
                    expandableView2.setVisibility( View.GONE );
                    arrowBtn2.setBackgroundResource( R.drawable.ic_keyboard_arrow_down_black_24dp );
                }
            }
        } );

        arrowBtn3.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (expandableView3.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition( cardView3, new AutoTransition() );
                    expandableView3.setVisibility( View.VISIBLE );
                    arrowBtn3.setBackgroundResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                } else {
                    TransitionManager.beginDelayedTransition( cardView3, new AutoTransition() );
                    expandableView3.setVisibility( View.GONE );
                    arrowBtn3.setBackgroundResource( R.drawable.ic_keyboard_arrow_down_black_24dp );
                }
            }
        } );

        arrowBtn4.setOnClickListener( new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (expandableView4.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition( cardView4, new AutoTransition() );
                    expandableView4.setVisibility( View.VISIBLE );
                    arrowBtn4.setBackgroundResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                } else {
                    TransitionManager.beginDelayedTransition( cardView4, new AutoTransition() );
                    expandableView4.setVisibility( View.GONE );
                    arrowBtn4.setBackgroundResource( R.drawable.ic_keyboard_arrow_down_black_24dp );
                }
            }
        } );

        return view;
    }


}