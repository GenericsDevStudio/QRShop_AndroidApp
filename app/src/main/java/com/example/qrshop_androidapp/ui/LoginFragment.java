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
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.network.Resources;

public class LoginFragment extends Fragment {
    public LoginFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private FragmentActivity main;
    private View rootView;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button logInButton;
    private TextView wrongTextView;
    private TextView signUpTextView;
    public static boolean checker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        //INITIALIZATION

        loginEditText = rootView.findViewById(R.id.loginEditText);
        passwordEditText = rootView.findViewById(R.id.passwordEditText);
        logInButton = rootView.findViewById(R.id.logInButton);
        wrongTextView = rootView.findViewById(R.id.wrongTextView);
        wrongTextView.setVisibility(View.INVISIBLE);
        signUpTextView = rootView.findViewById(R.id.signUpTextView);

        // ON CLICK LISTENERS

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ////////////////////////////////////////
                // LOGIN

                if (!loginEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    if (Resources.loginUser(loginEditText.getText().toString(), passwordEditText.getText().toString())) {
                        CountDownTimer count = new CountDownTimer(10000, 10) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                if (Resources.getCurrentUser() != null) {
                                    if(checker) {
                                        wrongTextView.setVisibility(View.INVISIBLE);
                                        FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                                                .replace(R.id.mainLayout, new MainMenuFragment());
                                        transaction.commit();
                                        cancel();
                                    }
                                }else if(Resources.getCurrentUser() == null && checker){
                                    wrongTextView.setVisibility(View.VISIBLE);
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
                } else {
                    Toast.makeText(main.getBaseContext(), "One or both of the fields is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

                ////////////////////////////////////////

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainLayout, new SignUpFragment());
                transaction.commit();
            }
        });
        return rootView;
    }

    // FRAGMENT ACTIVITY

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
