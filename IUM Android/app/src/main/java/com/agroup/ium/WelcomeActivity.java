package com.agroup.ium;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity {


    private ImageView[] dotArray;
    private int viewPagerSize = 3;
    private ImageView dotImage;
    private LinearLayout dotLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ViewPager viewPager = (ViewPager)findViewById(R.id.welcomeActivity_viewpager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(5,this));
        ViewPagerTransformer viewPagerTransformer = new ViewPagerTransformer(viewPager, pagerAdapter);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, viewPagerTransformer);
        viewPager.setOffscreenPageLimit(3);

        dotArray = new ImageView[viewPagerSize];
        for(int i=0; i<viewPagerSize; i++){
            dotImage = new ImageView(this);
            dotImage.setLayoutParams(new ViewGroup.LayoutParams(25,25));
            dotImage.setPadding(20,0,20,0);
            if(i == 0){
                dotImage.setBackgroundResource(R.mipmap.dot_focused);
            }
            else{
                dotImage.setBackgroundResource(R.mipmap.dot_unfocueds);
            }
            dotArray[i] = dotImage;

        }
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }


}
