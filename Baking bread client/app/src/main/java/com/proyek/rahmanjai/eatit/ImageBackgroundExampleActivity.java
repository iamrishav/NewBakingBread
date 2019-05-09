package com.proyek.rahmanjai.eatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class ImageBackgroundExampleActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);



        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Tasty Food", "Order food from Local restaurants near you. ", R.drawable.dinner);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("No minimum order", "Order in for yourself or for the group, with no restrictions on order value.", R.drawable.menu);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Lighting fast delivery", "Experience superfast delivery for food delivered fresh & on time. ", R.drawable.scooter);

        ahoyOnboarderCard1.setBackgroundColor(R.color.transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("Proceed");
        showNavigationControls(true);
        //setGradientBackground();
        setImageBackground(R.drawable.onboard);

        ;
        //setFont(face);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
//        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);

    }
}
