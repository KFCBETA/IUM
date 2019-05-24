package com.agroup.ium;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agroup.ium.Structure.UserStructure;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.BottomViewHolder> {

    private static final String TAG = BottomAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<UserStructure> userArray;

    public BottomAdapter(Context mContext, ArrayList<UserStructure> userArray) {
        this.mContext = mContext;
        this.userArray = userArray;
    }

    @NonNull
    @Override
    public BottomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bottom_account_item, parent, false);

        return new BottomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomViewHolder bottomViewHolder, int position) {

//        Log.e(TAG, "Position = " + position + "  " + userArray.get(position).getUserImage());

        if(position == 0){
            bottomViewHolder.imageView_dot.setBackgroundResource(R.drawable.dot_focused);
        }
        else{
            bottomViewHolder.imageView_dot.setBackgroundResource(R.drawable.dot_unfocued);
        }
        Glide.with(mContext)
                .load(mContext.getResources().getIdentifier(userArray.get(position).getUserImage(),
                        "drawable", mContext.getPackageName()))
                .apply(RequestOptions.circleCropTransform())
                .into(bottomViewHolder.imageView_image);
        bottomViewHolder.textView_userName.setText(userArray.get(position).getUserName());
    }

    public void notifyBottomDataSetChange(ArrayList<UserStructure> userUpdate){
        notifyDataSetChanged();
        //Get the selected list form mainActivity
        userArray = userUpdate;
    }


    @Override
    public int getItemCount() {
        return userArray.size();
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView_image;
        private TextView textView_userName;
        private ImageView imageView_dot;

        public BottomViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView_image = (ImageView)itemView.findViewById(R.id.bottom_account_image);
            textView_userName = (TextView)itemView.findViewById(R.id.bottom_account_name);
            imageView_dot = (ImageView)itemView.findViewById(R.id.bottom_account_dot);
        }
    }
}
