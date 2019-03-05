package com.example.qrshop_androidapp.ui;


import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.network.Resources;

public class SignUpFragment extends Fragment {
    public SignUpFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private View rootView;
    private FragmentActivity main;
    private EditText loginEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private EditText nameEditText;
    private Button signUpButton;
    public static boolean registeredChecker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // INITIALIZATION

        loginEditText = rootView.findViewById(R.id.loginEditText);
        passwordEditText = rootView.findViewById(R.id.passwordEditText);
        repeatPasswordEditText = rootView.findViewById(R.id.repeatPasswordEditText);
        signUpButton = rootView.findViewById(R.id.signUpButton);
        nameEditText = rootView.findViewById(R.id.nameEditText);

        ////////////////////////////////////////
        // SIGN UP

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!loginEditText.getText().toString().isEmpty()
                        && !passwordEditText.getText().toString().isEmpty()
                        && !repeatPasswordEditText.getText().toString().isEmpty()
                        && !nameEditText.getText().toString().isEmpty()) {
                    if(passwordEditText.getText().toString().equals(repeatPasswordEditText.getText().toString())){
                        if(Resources.registerUser(loginEditText.getText().toString(), repeatPasswordEditText.getText().toString(), nameEditText.getText().toString())){
                            CountDownTimer count = new CountDownTimer(10000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    if(registeredChecker){
                                        Toast.makeText(main.getBaseContext(), "You can now login!", Toast.LENGTH_SHORT).show();
                                        FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                                                .replace(R.id.mainLayout, new LoginFragment());
                                        transaction.commit();
                                        cancel();
                                    }
                                }

                                @Override
                                public void onFinish() {
                                    Toast.makeText(main.getBaseContext(), "Connection timeout", Toast.LENGTH_SHORT).show();
                                    cancel();
                                }
                            };
                            count.start();
                        }
                    }
                }else{
                    Toast.makeText(main.getBaseContext(), "One or several fields are not filled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ////////////////////////////////////////

        return rootView;
    }

    // FRAGMENT ACTIVITY

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
