package com.example.trantrongnguyen.databasesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.trantrongnguyen.databasesystem.fragment.DeleteFragment;
import com.example.trantrongnguyen.databasesystem.fragment.InsertFragment;
import com.example.trantrongnguyen.databasesystem.fragment.UpdateFragment;
import com.example.trantrongnguyen.databasesystem.fragment.View2Fragment;
import com.example.trantrongnguyen.databasesystem.fragment.ViewFragment;

public class Main2Activity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int INSERT_FRAGMENT = 1;
    private static final int UPDATE_FRAGMENT = 2;
    private static final int DELETE_FRAGMENT = 3;
    private static final int VIEW_FRAGMENT = 4;
    private static final int VIEW2_FRAGMENT = 5;
    private int currentFragment = 0;
    public String username, password, database, ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intentReceived = getIntent();
        Bundle data = intentReceived.getExtras();
        username = data.getString("username");
        password = data.getString("password");
        database = data.getString("database");
        ip = data.getString("ip");
        System.out.println(username);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_insert) {
            // Handle the camera action
            if(currentFragment != INSERT_FRAGMENT){

                replaceFragment(new InsertFragment());
                currentFragment = INSERT_FRAGMENT;
            }
        } else if (id == R.id.nav_update) {
            if(currentFragment != UPDATE_FRAGMENT){
                replaceFragment(new UpdateFragment());
                currentFragment = UPDATE_FRAGMENT;
            }

        } else if (id == R.id.nav_delete) {
            if(currentFragment != DELETE_FRAGMENT){
                replaceFragment(new DeleteFragment());
                currentFragment = DELETE_FRAGMENT;
            }
        } else if (id == R.id.nav_view) {
            if(currentFragment != VIEW_FRAGMENT){
                replaceFragment(new ViewFragment());
                currentFragment = VIEW_FRAGMENT;
            }
        }else if (id == R.id.nav_view2) {
            if(currentFragment != VIEW2_FRAGMENT){
                replaceFragment(new View2Fragment());
                currentFragment = VIEW2_FRAGMENT;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment( Fragment fragment){
        try{
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            bundle.putString("database", database);
            bundle.putString("ip", ip);
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment);
            fragmentTransaction.commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
