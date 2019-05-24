package com.agroup.ium.WelcomePage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agroup.ium.R;
import com.agroup.ium.Util.ScreenUtil;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = WelcomeActivity.class.getSimpleName();

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        toolbar = (Toolbar)findViewById(R.id.welcomeActivity_toolbar);
        setSupportActionBar(toolbar);


        Fragment fragment_welcome = new WelcomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_welcome, fragment_welcome);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {

        //TODO: Missing viewPager after back Fragment

        super.onBackPressed();
    }
}
