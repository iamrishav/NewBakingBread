package com.proyek.rahmanjai.eatit;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.proyek.rahmanjai.eatit.Model.DetailResult;
import com.proyek.rahmanjai.eatit.Model.DetailSinglePlace;
import com.proyek.rahmanjai.eatit.Model.DistanceDuration;
import com.proyek.rahmanjai.eatit.Model.DistanceResult;
import com.proyek.rahmanjai.eatit.Model.PlaceList;
import com.proyek.rahmanjai.eatit.Model.SinglePlace;
import com.proyek.rahmanjai.eatit.Recycler.RestaurantListRecycler;
import com.proyek.rahmanjai.eatit.rest_api.GooglePlacesApi;
import com.proyek.rahmanjai.eatit.rest_api.RestaurantListClient;
import com.proyek.rahmanjai.eatit.utils.LoadingUtil;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;
import static com.proyek.rahmanjai.eatit.RestaurantLocation.curLocation;

public class RestaurantList extends Fragment {

    public static final String TAG = "list";
    RecyclerView recyclerHospital;
    ArrayList<SinglePlace> itemList;
    FrameLayout fader, listFrame;
    AVLoadingIndicatorView avi;
    TextView tvDisplayResult;
    GooglePlacesApi googlePlacesApi;
    RestaurantListClient restaurantListClient;
    private Button loginPage, locateMap;
    DetailSinglePlace place;
    ImageView image;
    PlaceList placeList;
    DistanceResult distanceResult;
    String placeId;
    static LatLng defLocation = new LatLng(28.5, 77); //Delhi
    static LatLng curLocation = defLocation;
    LocationManager locMan;
    LocationListener locLis;





//

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_restaurant_list, container, false);

        recyclerHospital = (RecyclerView) view.findViewById(R.id.recyclerHospital);
        recyclerHospital.setLayoutManager(new LinearLayoutManager(view.getContext()));

        fader = (FrameLayout) view.findViewById(R.id.fader);
        listFrame = (FrameLayout) view.findViewById(R.id.content_main);
        avi = (AVLoadingIndicatorView) view.findViewById(R.id.avi);
        tvDisplayResult = view.findViewById(R.id.tvDisplayResult);

        image = view.findViewById(R.id.restaurantImage);

        stopLoadingAnimation();
        tvDisplayResult.setVisibility(View.INVISIBLE);


//        Intent intent = getIntent();
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            Log.d(TAG, "onCreate: search started");

        setLoadingAnimation();
        googlePlacesApi = new GooglePlacesApi(view.getContext());
        restaurantListClient = googlePlacesApi.getrestaurantlistclient();

        HashMap<String, String> params = googlePlacesApi.getQueryParams(curLocation, GooglePlacesApi.TYPE_RESTAURANT, GooglePlacesApi.RANKBY_DISTANCE);

//            params.put("name", query);

        restaurantListClient.getNearbyRestaurant(params).enqueue(new Callback<PlaceList>() {
            @Override
            public void onResponse(Call<PlaceList> call, Response<PlaceList> response) {
//                    Log.d(TAG, "onResponse: resp received");
                placeList = response.body();




                if (placeList != null) {
                    stopLoadingAnimation();
                    itemList = placeList.places;
                    if (itemList.size() == 0)
                        tvDisplayResult.setVisibility(View.VISIBLE);

                    else
                        bindRecyclerView();
                    getDistance();
                }

            }

            @Override
            public void onFailure(Call<PlaceList> call, Throwable t) {
//                    Log.d(TAG, "onFailure: cannot access places api");
                Toast.makeText(getContext(), "Unable to access server. Please try again later", Toast.LENGTH_SHORT).show();
                tvDisplayResult.setVisibility(View.VISIBLE);
            }
        });






//
//







        return view;
    }


    void bindRecyclerView() {
        RestaurantListRecycler hospitalListRecycler = new RestaurantListRecycler(itemList, getContext());
        recyclerHospital.setAdapter(hospitalListRecycler);




    }

    void setLoadingAnimation() {
        LoadingUtil.enableDisableView(listFrame, false);
        tvDisplayResult.setVisibility(View.INVISIBLE);
        fader.setVisibility(View.VISIBLE);
        avi.show();
    }

    void stopLoadingAnimation() {
        LoadingUtil.enableDisableView(listFrame, true);
        fader.setVisibility(View.GONE);
        avi.hide();
    }


    void getDistance() {
        if (placeList.places.isEmpty())
            return;


        String destination = "";


        for (int i = 0; i < placeList.places.size() - 1; i++) {
            SinglePlace place = placeList.places.get(i);
            destination += place.getLoc().latitude + "," + place.getLoc().longitude + "|";
        }
        SinglePlace place = placeList.places.get(placeList.places.size() - 1);
        destination += place.getLoc().latitude + "," + place.getLoc().longitude;


        HashMap<String, String> params = new HashMap<>();
        params.put("key", GooglePlacesApi.WEB_KEY);
        params.put("origins", curLocation.latitude + "," + curLocation.longitude);
        params.put("destinations", destination);

        restaurantListClient.getRestaurantDistances(params).enqueue(new Callback<DistanceResult>() {
            @Override
            public void onResponse(Call<DistanceResult> call, Response<DistanceResult> response) {
                distanceResult = response.body();

                if (distanceResult != null) {
                    ArrayList<DistanceDuration> distanceDurations = distanceResult.getRows().get(0).getElements();

                    if (distanceDurations == null)
                        return;

                    for (int i = 0; i < distanceDurations.size(); i++) {
                        DistanceDuration d = distanceDurations.get(i);

//                        Log.d(TAG, "onResponse: distance"+d.getDistance().getText());
//                        Log.d(TAG, "onResponse: duration"+d.getDuration().getText());

                        placeList.places.get(i).setDistance(d.getDistance().getValue());
                        placeList.places.get(i).setDistanceString(d.getDistance().getText());
                        placeList.places.get(i).setTimeMinutes(d.getDuration().getValue());
                        placeList.places.get(i).setTimeString(d.getDuration().getText());
                    }
                } else {
                    Toast.makeText(getContext(), "Unable to fetch data from the server. Please try again later", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DistanceResult> call, Throwable t) {
                Toast.makeText(getContext(), "Unable to access server. Please try again later", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onFailure: cannot fetch distances");
            }
        });
    }



}


