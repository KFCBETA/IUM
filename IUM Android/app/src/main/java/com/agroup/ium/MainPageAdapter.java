package com.agroup.ium;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agroup.ium.Structure.PostStructure;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.NavigationViewHolder> {

    private static final String TAG = MainPageAdapter.class.getSimpleName();

    private Context mContext;
    //ArrayList to store all post
    private ArrayList<PostStructure> postArray;


    public MainPageAdapter(Context context, ArrayList<PostStructure> postArray) {
        this.mContext = context;
        this.postArray = postArray;
    }

    @NonNull
    @Override
    public NavigationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homepage_item, parent, false);

        return new NavigationViewHolder(view);
    }

    public void notifyMyAdapterDataSetChange(ArrayList<PostStructure> postUpdate){
        notifyDataSetChanged();
        //Get the selected list form mainActivity
        postArray = postUpdate;
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationViewHolder navigationViewHolder, int position) {

        //Setup All post information
        navigationViewHolder.userName.setText(postArray.get(position).getUserName());
        Glide.with(mContext)
                .load(mContext.getResources().getIdentifier(postArray.get(position).getImageLink(), "drawable",
                        mContext.getPackageName()))
                .apply(RequestOptions.circleCropTransform())
                .into(navigationViewHolder.userImage);

        navigationViewHolder.postContent.setText(postArray.get(position).getPostContent());
        navigationViewHolder.postDate.setText(postArray.get(position).getPostDate());

    }

    //Get all post count
    @Override
    public int getItemCount() {
        return postArray.size();
    }


    public class NavigationViewHolder extends RecyclerView.ViewHolder {

        private ImageView userImage;
        private TextView userName;
        private TextView postDate;
        private TextView postContent;


        public NavigationViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = (ImageView)itemView.findViewById(R.id.mainPage_Image);
            userName = (TextView)itemView.findViewById(R.id.mainPage_UserName);
            postDate = (TextView)itemView.findViewById(R.id.mainPage_date);
            postContent = (TextView)itemView.findViewById(R.id.mainPage_content);

        }
    }

}
