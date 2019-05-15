package com.agroup.ium;

import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.agroup.ium.WelcomePage.WelcomeActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private View headerLayout;
    private NavigationView navigationView_Left;
    private BottomNavigationView navigationView_Bottom;
    private RecyclerView navigation_RecyclerView;
    private NavigationAdapter navigation_Adapter;
    private Toolbar toolbar;
    private ConstraintLayout setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView_Left = (NavigationView)findViewById(R.id.mainActivity_NavigationView);
        headerLayout = navigationView_Left.getHeaderView(0);




        //TODO: Load user information
        //Load User Image and crop it to round shape
        ImageView imageView_Header = (ImageView)headerLayout.findViewById(R.id.navigation_header_image);
        Glide.with(this)
                .load(R.drawable.volibear)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView_Header);
        //Set user name
        TextView textView_UserName = (TextView)headerLayout.findViewById(R.id.navigation_header_username);

        TextView textView_UserTag = (TextView)headerLayout.findViewById(R.id.navigation_header_userTag);

        //If SDK version below 26, set font for user name
        if(Build.VERSION.SDK_INT < 26){
            Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/RobotoCondensed-Regular.ttf");
            textView_UserName.setTypeface(font);
            textView_UserTag.setTypeface(font);
        }


        //Get RecyclerView in navigationView
        navigation_RecyclerView = (RecyclerView)findViewById(R.id.navigation_RecyclerView);
        //Setup adapter for user option
        navigation_Adapter = new NavigationAdapter(this);
        navigation_RecyclerView.setAdapter(navigation_Adapter);
        //Add layoutManager for recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        navigation_RecyclerView.setLayoutManager(layoutManager);
        //Setup the divider
        GridItemDecoration gridItemDecoration =
                new GridItemDecoration(1,32,0, 16, true);
        navigation_RecyclerView.addItemDecoration(gridItemDecoration);

        //Toolbar in the App
        toolbar = (Toolbar)findViewById(R.id.mainActivity_toolbar);
        setSupportActionBar(toolbar);

        //Get setting in the navigationBar
        setting = (ConstraintLayout)findViewById(R.id.navigation_setting);
        //Set text & image for setting view
        TextView textView_Setting = (TextView)setting.findViewById(R.id.navigation_itemText);
        textView_Setting.setText(R.string.setting);
        ImageView imageView_Setting = (ImageView)setting.findViewById(R.id.navigation_itemImage);
        imageView_Setting.setBackgroundResource(R.drawable.setting);


        //Set bottom navigation listener
        navigationView_Bottom = (BottomNavigationView)findViewById(R.id.mainActivity_BottomNavigationView);
        navigationView_Bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //Used for fragment transaction
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.bottom_navi_home:
                        Fragment fragment_main = new MainFragment();
                        fragmentTransaction.replace(R.id.container_main, fragment_main);
                        fragmentTransaction.commit();
                        break;
                    case R.id.bottom_navi_search:
                        break;
                    case R.id.bottom_navi_post:
                        break;
                    case R.id.bottom_navi_account:
                        break;
                }
                return true;
            }
        });

        //Initialize home page
        navigationView_Bottom.setSelectedItemId(R.id.bottom_navi_home);

    }

    public BottomNavigationView getNavigationView_Bottom() {
        return navigationView_Bottom;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
