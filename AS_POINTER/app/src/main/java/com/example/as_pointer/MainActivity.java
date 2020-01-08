package com.example.as_pointer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity   implements NavigationView.OnNavigationItemSelectedListener{

    private long backPressedTime;
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new Logout()).addToBackStack(backstackname).commit();
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
