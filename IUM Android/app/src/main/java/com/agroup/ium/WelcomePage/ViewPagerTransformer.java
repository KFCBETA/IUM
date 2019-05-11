package com.agroup.ium.WelcomePage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

import com.agroup.ium.Util.Constant;

public class ViewPagerTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private static final String TAG = ViewPagerTransformer.class.getSimpleName();

    private ViewPager viewPager;
    private float lastOffset;
    private CardFragmentPagerAdapter cardFragmentPagerAdapter;
    private Activity currentActivity;
    private boolean firstCreate = true;


    public ViewPagerTransformer(ViewPager viewPager, CardFragmentPagerAdapter adapter, Activity activity){
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.cardFragmentPagerAdapter = adapter;
        this.currentActivity = activity;

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        int currentPosition;
        int nextPosition;
        float baseElevation = cardFragmentPagerAdapter.getBaseElevation();
        float realOffset;
        //Check if user scroll tp right
        boolean scrollRight = lastOffset > positionOffset;

        if(firstCreate){
            firstCreate = false;
            return;
        }

        if(scrollRight){
            currentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        }
        else{
            nextPosition = position + 1;
            currentPosition = position;
            realOffset = positionOffset;
        }

        if(nextPosition > cardFragmentPagerAdapter.getCount()-1
                || currentPosition > cardFragmentPagerAdapter.getCount()-1){
            return;
        }

        CardView currentCard = cardFragmentPagerAdapter.getCardView(currentPosition);
        if(currentCard != null){
            currentCard.setCardElevation(baseElevation +
                    baseElevation*(Constant.ELEVATION_FACTOR)*(1-realOffset));
        }

        CardView nextCard = cardFragmentPagerAdapter.getCardView(nextPosition);
        if(nextCard != null){
            nextCard.setCardElevation(baseElevation +
                    baseElevation*(Constant.ELEVATION_FACTOR)*(1-realOffset));
        }


        lastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {
        ((WelcomeActivity)currentActivity).changeDotPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void transformPage(@NonNull View view, float v) {

    }




}
