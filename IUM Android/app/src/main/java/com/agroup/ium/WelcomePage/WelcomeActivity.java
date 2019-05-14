package com.agroup.ium.WelcomePage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agroup.ium.R;
import com.agroup.ium.Util.ScreenUtil;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = WelcomeActivity.class.getSimpleName();

    private ImageView[] dotArray;
    private int viewPagerSize = 4;
    private ImageView dotImage;
    private LinearLayout dotLinearLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ViewPager viewPager = (ViewPager)findViewById(R.id.welcomeActivity_viewpager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                ScreenUtil.dpToPixels(5,this));
        ViewPagerTransformer viewPagerTransformer = new ViewPagerTransformer(viewPager, pagerAdapter,this);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, viewPagerTransformer);
        viewPager.setOffscreenPageLimit(3);

        dotLinearLayout = (LinearLayout)findViewById(R.id.welcomeActivity_dotLinearLayout);

        dotArray = new ImageView[viewPagerSize];
        for(int i=0; i<viewPagerSize; i++){
            dotImage = new ImageView(this);
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

        toolbar = (Toolbar)findViewById(R.id.welcomeActivity_toolbar);
        setSupportActionBar(toolbar);

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
