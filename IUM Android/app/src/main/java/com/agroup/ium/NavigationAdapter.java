package com.agroup.ium;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationViewHolder> {

    private static final String TAG = NavigationAdapter.class.getSimpleName();
    private String[] userOption;
    private String[] userIcon;

    private Context mContext;

    public NavigationAdapter(Context context) {
        this.mContext = context;
        this.userOption = mContext.getResources().getStringArray(R.array.user_option);
        this.userIcon = mContext.getResources().getStringArray(R.array.user_icon);
    }

    @NonNull
    @Override
    public NavigationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.navigation_item_layout, parent, false);

        return new NavigationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationViewHolder navigationViewHolder, int position) {

//        Log.e(TAG, "Position = " + position);

        navigationViewHolder.itemText.setText(userOption[position]);
        navigationViewHolder.itemIcon.setBackgroundResource(
                mContext.getResources().getIdentifier(userIcon[position], "drawable", mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return userOption.length;
    }


    public class NavigationViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemIcon;
        private TextView itemText;

        public NavigationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemIcon = itemView.findViewById(R.id.navigation_itemImage);
            itemText = itemView.findViewById(R.id.navigation_itemText);
        }
    }
}
