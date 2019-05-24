package com.agroup.ium.WelcomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.agroup.ium.MainActivity;
import com.agroup.ium.R;
import com.bumptech.glide.Glide;

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

        View view = inflater.inflate(R.layout.cardview_welcome, container, false);

        ConstraintLayout constraintLayout = (ConstraintLayout)view.findViewById(R.id.cardViewConstraintLayout);

        cardView = (CardView)view.findViewById(R.id.welcomeCardView);
        cardView.setMaxCardElevation(cardView.getCardElevation()*10);

        TextView textView_Title = (TextView)view.findViewById(R.id.cardViewTitle);
        TextView textView_Content = (TextView)view.findViewById(R.id.cardViewContent);
        ImageView imageView_Content = (ImageView)view.findViewById(R.id.cardViewImage);

        Button button_LogIn = (Button)view.findViewById(R.id.cardViewLogIn);
        Button button_Guest = (Button)view.findViewById(R.id.cardViewGuest);


        switch(getArguments().getInt("position")){
            case 0:
                iniFirstCard(textView_Title,textView_Content,imageView_Content);
                break;
            case 1:
                iniSecondCard(textView_Title,textView_Content,imageView_Content);
                break;
            case 2:
                iniThirdCard(textView_Title,textView_Content,imageView_Content);
                break;
            case 3:
                iniFourthCard(textView_Title,textView_Content,imageView_Content,button_LogIn,button_Guest,constraintLayout);
        }

        return view;
    }

    public CardView getCardView(){
        return cardView;
    }

    public void iniFirstCard(TextView title, TextView content, ImageView imageView){

        title.setText("Card " + 1);
        content.setVisibility(View.VISIBLE);
        content.setText("Content " + 1);
        imageView.setVisibility(View.VISIBLE);
        Glide.with(getActivity())
                .load(R.drawable.volibear)
                .into(imageView);
    }


    public void iniSecondCard(TextView title, TextView content, ImageView imageView){

        title.setText("Card " + 2);
        content.setVisibility(View.VISIBLE);
        content.setText("Content " + 2);
        imageView.setVisibility(View.VISIBLE);
        Glide.with(getActivity())
                .load(R.drawable.poros)
                .into(imageView);
    }

    public void iniThirdCard(TextView title, TextView content, ImageView imageView){

        title.setText("Card " + 3);
        content.setVisibility(View.VISIBLE);
        content.setText("Content " + 3);
        imageView.setVisibility(View.VISIBLE);
        Glide.with(getActivity())
                .load(R.drawable.ashe)
                .into(imageView);

    }

    public void iniFourthCard(TextView title, TextView content, ImageView imageView, Button logIn, Button guest, ConstraintLayout constraintLayout){

        title.setText("Welcome to IUM");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        //layoutParams.topMargin = (int)ScreenUtil.dpToPixels(20,getActivity());
        title.setLayoutParams(layoutParams);

        logIn.setVisibility(View.VISIBLE);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Go to log in page
                Fragment fragment_login = new Fragment_LoginPage();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_welcome, fragment_login);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        guest.setVisibility(View.VISIBLE);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Go to Guest Page
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
