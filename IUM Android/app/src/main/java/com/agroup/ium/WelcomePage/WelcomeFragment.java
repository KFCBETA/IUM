package com.agroup.ium.WelcomePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agroup.ium.R;
import com.agroup.ium.Util.ScreenUtil;

public class WelcomeFragment extends Fragment {

    private ImageView[] dotArray;
    private int viewPagerSize = 4;
    private ImageView dotImage;
    private LinearLayout dotLinearLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, parent, false);


        ViewPager viewPager = (ViewPager)view.findViewById(R.id.welcomeActivity_viewpager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                ScreenUtil.dpToPixels(5,getActivity()));
        ViewPagerTransformer viewPagerTransformer = new ViewPagerTransformer(viewPager, pagerAdapter,this);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, viewPagerTransformer);
        viewPager.setOffscreenPageLimit(3);

        dotLinearLayout = (LinearLayout)view.findViewById(R.id.welcomeActivity_dotLinearLayout);

        dotArray = new ImageView[viewPagerSize];
        for(int i=0; i<viewPagerSize; i++){
            dotImage = new ImageView(getActivity());
            dotImage.setLayoutParams(new ViewGroup.LayoutParams(25,25));
            dotImage.setPadding(20,0,20,0);
            dotArray[i] = dotImage;
            if(i == 0){
                dotArray[i].setBackgroundResource(R.drawable.dot_focused);
            }
            else{
                dotArray[i].setBackgroundResource(R.drawable.dot_unfocued);
            }

            dotLinearLayout.addView(dotArray[i]);
        }

        return view;
    }


    public void changeDotPosition(int position){
        for(int i=0; i<viewPagerSize; i++){
            dotArray[i].setBackgroundResource(R.drawable.dot_focused);
            if(i != position){
                dotArray[i].setBackgroundResource(R.drawable.dot_unfocued);
            }
        }
    }

}
