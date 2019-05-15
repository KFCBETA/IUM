package com.agroup.ium;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    //Adapter for RecyclerView
    private MainPageAdapter mainPageAdapter;
    //ArrayList to store all post
    private ArrayList<PostStructure> postArray;
    //Layout for Refreshing
    private SwipeRefreshLayout mainPageSwipeRefreshLayout;
    //BottomNavigationView from mainActivity
    private BottomNavigationView bottomNavigationView;

    //Create Test Post Array
    public void CreateTestArray(){

        AddPost("Poros", "19:00","The thunderous demigod known as the Thousand-Pierced Bear is the battle-spirit of the Freljord. Thousands of years of constant and bitter wars, fought in the coldest winters, have hardened Volibear into a truly indomitable force, hurling bolts of lightning from the highest peaks—and when snowy tempests rage down, it can only mean that he is on the attack once more. Any who dare to face him may find themselves joining his fierce army of Ursine warriors… assuming they do not fall victim to his savage claws.", "poros");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postArray = new ArrayList<>();
        bottomNavigationView = ((MainActivity)getActivity()).getNavigationView_Bottom();

        CreateTestArray();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, parent, false);

        //Get RecyclerView & setup the adapter
        RecyclerView recyclerView_mainPage = (RecyclerView)view.findViewById(R.id.mainFragment_RecyclerView);
        mainPageAdapter = new MainPageAdapter(getActivity(),postArray);
        recyclerView_mainPage.setAdapter(mainPageAdapter);

        //Setup layoutManager for RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_mainPage.setLayoutManager(layoutManager);


        //TODO: Refresh to get new post
        //Setup RefreshLayout & Test
        mainPageSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.mainFragment_SwipeRefreshLayout);
        mainPageSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                AddPost("Ashe", "19:00","Iceborn warmother of the Avarosan tribe, Ashe commands the most populous horde in the north. Stoic, intelligent, and idealistic, yet uncomfortable with her role as leader, she taps into the ancestral magics of her lineage to wield a bow of True Ice. With her people’s belief that she is the mythological hero Avarosa reincarnated, Ashe hopes to unify the Freljord once more by retaking their ancient, tribal lands.", "ashe");
                AddPost("Volibear", "19:00","Poros are the mysterious, magical, and most-loved creatures originating from the Howling Abyss. Poros are equal parts truth, valor, and innocence. The colour of their fur is described as “very light blue, like Freljordian snow” (Pantone P 121-3 U). They have a heart-shaped underbelly because they’re made of love. A poro’s horns perk up when it’s excited and droop down when it’s scared. Poros paddle through deep snow with their front paws. Some believe that poros are indestructible—though at one point we animated poros to keel over and twitch if they ran into the Abyss’ fountains.", "volibear");

                mainPageAdapter.notifyMyAdapterDataSetChange(postArray);

                mainPageSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }


    //TODO: Add Post through API
    public void AddPost(String userName, String postDate, String postContent, String imageLink){

        PostStructure temp = new PostStructure(userName, postDate, postContent, imageLink);
        postArray.add(temp);
    }

}
