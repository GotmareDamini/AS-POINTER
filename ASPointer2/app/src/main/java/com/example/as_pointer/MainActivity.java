package com.example.as_pointer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        /*final Button button1= (Button) findViewById(R.id.button);
        Button button2= (Button) findViewById(R.id.button2);

        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility( View.GONE );
                FragmentManager fm = getSupportFragmentManager();
                Login fragment = new Login();
                fm.beginTransaction().replace( R.id.login, fragment ).commit();
            }
        } );

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility( View.GONE );
                FragmentManager fm = getSupportFragmentManager();
                SignUp fragment1 = new SignUp();
                fm.beginTransaction().replace( R.id.signup, fragment1 ).commit();
            }
        } ); */
        CardView cardView = (CardView) findViewById( R.id.card ); // creating a CardView and assigning a value.

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                SignUp fragment1 = new SignUp();
                fm.beginTransaction().replace( R.id.fragment, fragment1 ).commit();
            }
        });

    }
}
