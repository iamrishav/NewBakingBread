package com.proyek.rahmanjai.eatit;
// Lily: Finished UI design and navigation drawer design & on item selected listener.
// Xiao: Implemented default city and logout function


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.proyek.rahmanjai.eatit.Common.Common;
import com.proyek.rahmanjai.eatit.Database.Database;
import com.proyek.rahmanjai.eatit.Model.DetailSinglePlace;
import com.proyek.rahmanjai.eatit.Model.DistanceResult;
import com.proyek.rahmanjai.eatit.Model.PlaceList;
import com.proyek.rahmanjai.eatit.Model.SinglePlace;
import com.proyek.rahmanjai.eatit.Recycler.RestaurantListRecycler;
import com.proyek.rahmanjai.eatit.rest_api.GooglePlacesApi;
import com.proyek.rahmanjai.eatit.rest_api.RestaurantListClient;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
//        GoogleApiClient.OnConnectionFailedListener,
//        GoogleApiClient.ConnectionCallbacks,
//        ResultCallback<People.LoadPeopleResult>{



    private static ProgressDialog pDialog;

    GoogleApiClient mGoogleApiClient;
    boolean mSignInClicked;



    public static String City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main2);
        setCity();
        init();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//        mGoogleApiClient.connect();
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mGoogleApiClient.isConnected()) {
//            mGoogleApiClient.disconnect();
//        }
//    }

    // Haven'v finished function
    private void setCity(){
        if (City == null){
            City = "Indore";
        }
    }

    public static TextView cartNumber;

    private void init(){

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.restoolbar);
        toolbar.setTitle("Search For  Restaurants Here");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        cartNumber = (TextView) findViewById(R.id.cart_item_number);
//        cartNumber.setText(String.valueOf(ShoppingCartItem.getInstance(this).getSize()));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(Main2Activity.this,Cart.class);
                startActivity(cartIntent);
            }
        });
        cartNumber.setText(String.valueOf(new Database(this).getCountCart()));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.inflateHeaderView(R.layout.nav_header_main2);
        TextView header_mobile = (TextView) navHeaderView.findViewById(R.id.nav_mobile);
        TextView header_name = (TextView) navHeaderView.findViewById(R.id.nav_name);
        header_name.setText(Common.currentUser.getNama());
        header_mobile.setText(Common.currentUser.getPhone());

        if(findViewById(R.id.main_fragment_container) != null) {
            Restaurants homeFragment = new Restaurants();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, homeFragment).commit();
        }






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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main2, menu);
//        return true;
//    }

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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (id) {
            case R.id.nav_home:
                Restaurants homeFragment = new Restaurants();
                transaction.replace(R.id.main_fragment_container, homeFragment).commit();
                break;
            case R.id.nav_addr:
                break;
            case R.id.nav_profile:
//                ProfileFragment profileFragment = new ProfileFragment();
//                transaction.replace(R.id.main_fragment_container, profileFragment).commit();
//                break;
            case R.id.nav_history:
//                HistoryFragment historyFragment = new HistoryFragment();
//                transaction.replace(R.id.main_fragment_container, historyFragment).commit();
//                break;
            case R.id.nav_track:
//                TrackFragment trackFragment = new TrackFragment();
//                transaction.replace(R.id.main_fragment_container, trackFragment).commit();
//                break;
            case R.id.nav_help:
//                HelpFragment helpFragment = new HelpFragment();
//                transaction.replace(R.id.main_fragment_container, helpFragment).commit();
//                break;
            case R.id.nav_rate:
                break;
            case R.id.nav_logout:
//                SPManipulation.getInstance(this).clearSharedPreference();
//                LoginManager.getInstance().logOut();
//                if (mGoogleApiClient.isConnected()) {
////                    mGoogleApiClient.disconnect();
////                    // updateUI(false);
////                    System.err.println("LOG OUT ^^^^^^^^^^^^^^^^^^^^ SUCESS");
//                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                            new ResultCallback<Status>() {
//                                @Override
//                                public void onResult(Status status) {
//                                    // ...
//                                    Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                }
//                Intent splash = new Intent(this, com.proyek.rahmanjai.eatit.SplashActivity.class);
//                startActivity(splash);
//                finish();
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public static void showPDialog(){
        if (!pDialog.isShowing()){
            pDialog.show();
        }
    }
    public static void disPDialog(){
        if (pDialog.isShowing()){
            pDialog.dismiss();
        }
    }

//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        Log.d("LOGOUT", "onConnectionFailed:" + connectionResult);
//    }
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        mSignInClicked = false;
//
//        // updateUI(true);
//        Plus.PeopleApi.loadVisible(mGoogleApiClient, null).setResultCallback(this);
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    public void onResult(@NonNull People.LoadPeopleResult loadPeopleResult) {
//
//    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);

    SearchManager searchManager =
            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView =
            (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(
            searchManager.getSearchableInfo(getComponentName()));

    return true;
}

}
