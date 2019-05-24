package com.agroup.ium.WelcomePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.agroup.ium.R;

public class Fragment_LoginPage extends Fragment {

    private static final String TAG = Fragment_LoginPage.class.getSimpleName();


    private Button button_Enter;
    private Button button_Show;
    private EditText editText_UserName;
    private EditText editText_UserPassword;
    private boolean isShow = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_page, parent, false);

        editText_UserName = (EditText)view.findViewById(R.id.loginPageFragment_UserName);
        editText_UserPassword = (EditText)view.findViewById(R.id.loginPageFragment_UserPass);

        button_Show = (Button)view.findViewById(R.id.loginPageFragment_ShowPass);
        button_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isShow){
                    button_Show.setText(R.string.login_Hide);
                    editText_UserPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else {
                    button_Show.setText(R.string.login_Show);
                    editText_UserPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

                isShow = !isShow;
            }
        });



        button_Enter = (Button)view.findViewById(R.id.loginPageFragment_EnterButton);
        button_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string_userName = editText_UserName.getText().toString();
                String string_userPassword = editText_UserPassword.getText().toString();

                Log.e(TAG, "User Name: " +  string_userName + "\n" + "User Pass: " + string_userPassword);

                //TODO: Go to Login Page in Flicker
            }
        });


        return view;
    }
}
