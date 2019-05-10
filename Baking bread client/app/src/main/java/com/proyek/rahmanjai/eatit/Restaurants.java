package com.proyek.rahmanjai.eatit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.FirebaseDatabase;
import com.proyek.rahmanjai.eatit.Common.Common;
import com.proyek.rahmanjai.eatit.Interface.ItemClickListener;
import com.proyek.rahmanjai.eatit.Model.Restaurant;
import com.proyek.rahmanjai.eatit.ViewHolder.RestaurantViewHolder;
import com.squareup.picasso.Picasso;

import static com.proyek.rahmanjai.eatit.Main2Activity.City;


public class Restaurants extends Fragment {

    AlertDialog waitingDialog;
    RecyclerView recyclerView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    private TextView locationView;
    private TextView changeLocView;
    static LatLng defLocation = new LatLng(28.5355, 77.3910); //Delhi
    static LatLng curLocation = defLocation;
//    SwipeRefreshLayout mSwipeRefreshLayout ;


//    FirebaseRecyclerOptions<Restaurant> options = new FirebaseRecyclerOptions.Builder<Restaurant>()
//            .setQuery(FirebaseDatabase.getInstance()
//                    .getReference()
//                    .child("Restaurants"),Restaurant.class)
//            .build();
//
//
//    FirebaseRecyclerAdapter<Restaurant, RestaurantViewHolder>   adapter = new FirebaseRecyclerAdapter<Restaurant, RestaurantViewHolder>(options) {
//        @Override
//        public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View itemView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.restaurant_item,parent,false);
//            return new RestaurantViewHolder(itemView);
//        }
//
//        @Override
//        protected void onBindViewHolder(@NonNull RestaurantViewHolder viewHolder, int position, @NonNull Restaurant model) {
//
//
//            viewHolder.txt_restaurant_name.setText(model.getName());
//            Picasso.get().load(model.getImage())
//                    .into(viewHolder.img_restaurant);
//            final Restaurant clickItem = model;
//            viewHolder.setItemClickListener(new ItemClickListener() {
//                @Override
//                public void onClick(View view, int position, boolean isLongClik) {
//                    //Get CategoryId and Send to new activity
//                    Intent intent = new Intent(view.getContext(), Home.class);
//
//                    Common.restaurantSelected = adapter.getRef(position).getKey();
//                    adapter.notifyDataSetChanged();
//                    startActivity(intent);
//                    loadRestaurant();
//                }
//            });
//        }
//
//    };

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurants);
//
//        recyclerView = view.findViewById(R.id.recycler_restaurant);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        loadRestaurant();
//        if (Common.isConnectedToInternet(this)) {
//            loadRestaurant();
//        }else {
//            Toast.makeText(Restaurants.this, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        recyclerView.getAdapter().notifyDataSetChanged();
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_restaurants, container, false);
//        recyclerView = view.findViewById(R.id.);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        loadRestaurant();
//        if (Common.isConnectedToInternet(view.getContext())) {
//            loadRestaurant();
//        }else {
//            Toast.makeText(view.getContext(), "Please check your internet connection!", Toast.LENGTH_SHORT).show();
//        }
//        recyclerView.getAdapter().notifyDataSetChanged();

        mSectionsPagerAdapter =  new SectionsPagerAdapter(getChildFragmentManager());
        mTabLayout = (TabLayout) view.findViewById(R.id.home_tabLayout);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mViewPager = (ViewPager) view.findViewById(R.id.home_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabLayout.setScrollPosition(position, 0, true);
                mTabLayout.setSelected(true);
                mViewPager.getParent().requestDisallowInterceptTouchEvent(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        locationView = (TextView) view.findViewById(R.id.home_TV_Location);
        locationView.setText(City);
        changeLocView = (TextView) view.findViewById(R.id.home_TV_notHere);
        changeLocView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View layout = inflater.inflate(R.layout.dialog_set_city,(ViewGroup) view.findViewById(R.id.dialog));
                new android.app.AlertDialog.Builder(getActivity()).setTitle("Please Input City Name").setIcon(
                        android.R.drawable.ic_dialog_info).setView(
                        layout).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Dialog dialog = (Dialog) dialogInterface;
                        EditText inputCity = (EditText) dialog.findViewById(R.id.dialog_et_city);
                        if (inputCity.getText().toString().equalsIgnoreCase("Indore")){
                            City = "Indore";
                            getActivity().recreate();
                        }
                        else if (inputCity.getText().toString().equalsIgnoreCase("delhi")){
                            City = "delhi";
                            getActivity().recreate();
                        }
                        else if (inputCity.getText().toString().equalsIgnoreCase("noida")){
                            City = "Noida";
                            getActivity().recreate();
                        }
                        else {
                            String SorryInfo = "We Currently Don't Have Service At Your Location!";
                            new android.app.AlertDialog.Builder(getActivity()).setTitle("Sorry!").setIcon(
                                    android.R.drawable.ic_dialog_info)
                                    .setMessage(SorryInfo)
                                    .setNegativeButton("Cancel", null).show();
                        }
                    }
                })
                        .setNegativeButton("Cancel", null).show();
            }
        });

        return view;
    }

//    private void loadRestaurant() {
//
//        adapter.startListening();
//        adapter.notifyDataSetChanged();
//        recyclerView.setAdapter(adapter);
//        recyclerView.getAdapter().notifyDataSetChanged();
////        adapter.notifyDataSetChanged();
//
//
//    }

    class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    AllTabFragment tab1 = new AllTabFragment();
                    return tab1;
                case 1:
                    RestaurantList tab2 = new RestaurantList();
                    return tab2;
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Order Here";
                case 1:
                    return "Search Here";

                default:
                    break;
            }
            return null;
        }
    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//
//    }
}

