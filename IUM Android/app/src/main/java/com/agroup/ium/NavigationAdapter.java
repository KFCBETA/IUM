package com.agroup.ium;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationViewHolder> {

    private static final String TAG = NavigationAdapter.class.getSimpleName();
    private String[] userOption;

    private Context mContext;

    public NavigationAdapter(Context context) {
        this.mContext = context;
        this.userOption = mContext.getResources().getStringArray(R.array.user_option);
    }

    @NonNull
    @Override
    public NavigationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.navigation_item, parent, false);

        return new NavigationViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationViewHolder navigationViewHolder, int position) {

        Log.e(TAG, "Position = " + position);

        navigationViewHolder.itemText.setText(userOption[position]);
    }

    @Override
    public int getItemCount() {
        return userOption.length;
    }


    public class NavigationViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemIcon;
        private TextView itemText;

        public NavigationViewHolder(@NonNull CardView itemView) {
            super(itemView);

            itemIcon = itemView.findViewById(R.id.navigation_itemImage);
            itemText = itemView.findViewById(R.id.navigation_itemText);
        }
    }
}
