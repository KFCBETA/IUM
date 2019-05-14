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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView_NaviHeader;
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


        if(Build.VERSION.SDK_INT < 26){
            Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/RobotoCondensed-Regular.ttf");
            textView_NaviHeader = (TextView)headerLayout.findViewById(R.id.navigation_header_username);
            textView_NaviHeader.setTypeface(font);
        }

        navigation_Adapter = new NavigationAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        GridItemDecoration gridItemDecoration = new GridItemDecoration(1,32,0, 16, true);

        navigation_RecyclerView = (RecyclerView)findViewById(R.id.navigation_RecyclerView);
        navigation_RecyclerView.setLayoutManager(layoutManager);
        navigation_RecyclerView.setAdapter(navigation_Adapter);
        navigation_RecyclerView.addItemDecoration(gridItemDecoration);

        toolbar = (Toolbar)findViewById(R.id.mainActivity_toolbar);
        setSupportActionBar(toolbar);

        setting = (ConstraintLayout)findViewById(R.id.navigation_setting);
        TextView textView_Setting = (TextView)setting.findViewById(R.id.navigation_itemText);
        textView_Setting.setText(R.string.setting);

        ImageView imageView_Setting = (ImageView)setting.findViewById(R.id.navigation_itemImage);
        imageView_Setting.setBackgroundResource(R.drawable.setting);

        navigationView_Bottom = (BottomNavigationView)findViewById(R.id.mainActivity_BottomNavigationView);
        navigationView_Bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_navi_home:
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


        Fragment fragment_main = new MainFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_main, fragment_main);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
