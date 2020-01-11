package com.example.as_pointer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener{

    private long backPressedTime;
//    final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    String backstackname = getFragmentManager().getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new Home()).addToBackStack(backstackname).commit();
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (backstackname.equals("0")) {
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(this, "Press back Again to Exit !!", Toast.LENGTH_SHORT).show();
            }
            backPressedTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Boolean fragmentpooped = getSupportFragmentManager().popBackStackImmediate(backstackname, 0);
        if (!fragmentpooped) {
            if (id == R.id.nav_home) {
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new Home()).addToBackStack(backstackname).commit();
            } else if (id == R.id.nav_spots) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new AccidentalSpots()).addToBackStack(backstackname).commit();
            } else if (id == R.id.nav_help) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new Help()).addToBackStack(backstackname).commit();
            } else if (id == R.id.nav_logout) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Confirm Exit..!!!");
                // Icon Of Alert Dialog
                alertDialogBuilder.setIcon(R.drawable.ic_announcement_black_24dp);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Are you sure, You want to exit!");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You clicked over No",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
//                Intent intent = new Intent( this, LoginActivity.class );
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
            } else if (id == R.id.nav_contact) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new ContactUs()).addToBackStack(backstackname).commit();
            }else if (id == R.id.nav_info) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new AboutUs()).addToBackStack(backstackname).commit();
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer( GravityCompat.START);
        return true;
    }

}
