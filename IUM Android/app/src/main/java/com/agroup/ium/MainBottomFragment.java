package com.agroup.ium;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agroup.ium.Structure.UserStructure;
import com.agroup.ium.Util.ScreenUtil;

import java.util.ArrayList;

public class MainBottomFragment extends BottomSheetDialogFragment {

    private Context mContext;

    //TODO: User information from database
    //ArrayList for different information
    private ArrayList<UserStructure> userArrayList;
    private RecyclerView bottomUser_RecyclerView;
    private BottomAdapter bottomAdapter;

    public MainBottomFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userArrayList = new ArrayList<>();
        //TODO: get user from Database
        AddAllUser();



    }

    @Override
    public void onStart() {
//        getActivity().getWindow().setBackgroundDrawableResource(R.color.colorTest);

        super.onStart();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new BottomSheetDialog(requireContext(), getTheme());
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage_bottom_sheet, container, false);

        bottomUser_RecyclerView = (RecyclerView)view.findViewById(R.id.bottomSheet_Account);
        bottomAdapter = new BottomAdapter(getActivity(),userArrayList);
        bottomUser_RecyclerView.setAdapter(bottomAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bottomUser_RecyclerView.setLayoutManager(layoutManager);
        LineDecoration lineDecoration = new LineDecoration(getActivity(), (int)ScreenUtil.dpToPixels((float)0.5, getContext()));
        bottomUser_RecyclerView.addItemDecoration(lineDecoration);

        return view;
    }


    @Override
    public void onStop() {
//        getActivity().getWindow().setBackgroundDrawableResource(android.R.color.background_light);

        super.onStop();
    }


    public void AddAllUser(){
        userArrayList.add(new UserStructure("Ashe", "ashe"));
        userArrayList.add(new UserStructure("Volibear", "volibear"));
    }

}
