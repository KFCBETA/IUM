package com.agroup.ium;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<CardFragment_Welcome> fragments;
    private float baseElevation;

    public final int ELEVATION_FACTOR = 8;

    public CardFragmentPagerAdapter(FragmentManager fragmentManager, float elevation) {
        super(fragmentManager);

        fragments = new ArrayList<>();

        this.baseElevation = elevation;

        for (int i=0; i<3; i++) {
            addCardFragment(new CardFragment_Welcome());
        }
    }

    public float getBaseElevation() {
        return baseElevation;
    }

    public CardView getCardView(int position) {
        return fragments.get(position).getCardView();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragments.set(position, (CardFragment_Welcome)fragment);

        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return CardFragment_Welcome.getInstance(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addCardFragment(CardFragment_Welcome fragment){
        fragments.add(fragment);
    }
}
