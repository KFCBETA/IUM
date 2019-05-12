package com.agroup.ium;

import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.agroup.ium.WelcomePage.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView_NaviHeader;
    private View headerLayout;
    private NavigationView navigationView;
    private RecyclerView navigation_RecyclerView;
    private NavigationAdapter navigation_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView)findViewById(R.id.mainActivity_NavigationView);
        headerLayout = navigationView.getHeaderView(0);


        if(Build.VERSION.SDK_INT < 26){
            Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/RobotoCondensed-Regular.ttf");
            textView_NaviHeader = (TextView)headerLayout.findViewById(R.id.navigation_header_title);
            textView_NaviHeader.setTypeface(font);
        }

        navigation_Adapter = new NavigationAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        GridItemDecoration gridItemDecoration = new GridItemDecoration(1,32,16, true);

        navigation_RecyclerView = (RecyclerView)findViewById(R.id.navigation_RecyclerView);
        navigation_RecyclerView.setLayoutManager(layoutManager);
        navigation_RecyclerView.setAdapter(navigation_Adapter);
        navigation_RecyclerView.addItemDecoration(gridItemDecoration);

    }
}
