package com.agroup.ium;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardFragment_Welcome extends Fragment {


    private CardView cardView;

    public static Fragment getInstance(int position){

        CardFragment_Welcome cardFragment = new CardFragment_Welcome();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        cardFragment.setArguments(bundle);

        return cardFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_welcome_cardview, container, false);

        cardView = (CardView)view.findViewById(R.id.welcomeCardView);
        cardView.setMaxCardElevation(cardView.getCardElevation()*10);

        TextView textView_Title = (TextView)view.findViewById(R.id.cardViewTitle);
        TextView textView_Content = (TextView)view.findViewById(R.id.cardViewContent);

        textView_Title.setText("Card " + getArguments().getInt("position"));

        textView_Content.setText("Content " + getArguments().getInt("position"));

        return view;
    }


    public CardView getCardView(){
        return cardView;
    }
}
