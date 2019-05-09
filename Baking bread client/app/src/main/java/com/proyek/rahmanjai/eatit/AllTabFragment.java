package com.proyek.rahmanjai.eatit;

// Lily: Designed UI. Set fragment replacement. Implemented custom animation.
// Xiao: implemented data request and onClickListener for each adapter.


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.proyek.rahmanjai.eatit.Common.Common;
import com.proyek.rahmanjai.eatit.Interface.ItemClickListener;
import com.proyek.rahmanjai.eatit.Model.Restaurant;
import com.proyek.rahmanjai.eatit.ViewHolder.RestaurantViewHolder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTabFragment extends Fragment {
    RecyclerView recyclerView;

    FirebaseRecyclerOptions<Restaurant> options = new FirebaseRecyclerOptions.Builder<Restaurant>()
            .setQuery(FirebaseDatabase.getInstance()
                    .getReference()
                    .child("Restaurants"),Restaurant.class)
            .build();


    FirebaseRecyclerAdapter<Restaurant, RestaurantViewHolder> adapter = new FirebaseRecyclerAdapter<Restaurant, RestaurantViewHolder>(options) {
        @Override
        public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.restaurant_item,parent,false);
            return new RestaurantViewHolder(itemView);
        }

        @Override
        protected void onBindViewHolder(@NonNull RestaurantViewHolder viewHolder, int position, @NonNull Restaurant model) {


            viewHolder.txt_restaurant_name.setText(model.getName());
            Picasso.get().load(model.getImage())
                    .into(viewHolder.img_restaurant);
            final Restaurant clickItem = model;
            viewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClik) {
                    //Get CategoryId and Send to new activity
                    Intent intent = new Intent(view.getContext(), Home.class);

                    Common.restaurantSelected = adapter.getRef(position).getKey();
                    adapter.notifyDataSetChanged();
                    startActivity(intent);
                    loadRestaurant();
                }
            });
        }

    };


    public AllTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_tab, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        loadRestaurant();
        if (Common.isConnectedToInternet(view.getContext())) {
            loadRestaurant();
        }else {
            Toast.makeText(view.getContext(), "Please check your internet connection!", Toast.LENGTH_SHORT).show();
        }
        recyclerView.getAdapter().notifyDataSetChanged();

        // Request Data From Web Service

        return view;
    }
    private void loadRestaurant() {

        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();
//        adapter.notifyDataSetChanged();


    }



}
