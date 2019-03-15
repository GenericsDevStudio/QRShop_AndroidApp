package com.example.qrshop_androidapp.ui;


import android.content.Context;
import android.graphics.Camera;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.model.Cart;
import com.example.qrshop_androidapp.network.Resources;


public class MainMenuFragment extends Fragment {
    public MainMenuFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private FragmentActivity main;
    private View rootView;
    private TextView userNameTextView;
    private TextView userCashTextView;
    private TextView cartCountTextView;
    private Button addNewToCartButton;
    private Button finishPaymentButton;
    private String userName = Resources.getCurrentUser().getName();
    private String userCash = Resources.getCurrentUser().getCash() + " " + "Dollars";
    public static boolean checker;
    public static Boolean bought;

    // CART

    private static final Cart currentCart = Resources.getCurrentCart();

    ////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        // INITIALIZATION

        if(checker){
            CountDownTimer waitForResponse = new CountDownTimer(10000, 10) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if(bought != null){
                        if(bought){
                            Toast.makeText(main.getBaseContext(), "Successfully bought", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(main.getBaseContext(), "Buying failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFinish() {
                    Toast.makeText(main.getBaseContext(), "Connection timeout", Toast.LENGTH_SHORT).show();
                    cancel();
                }
            };
            waitForResponse.start();
        }

        String inCart = currentCart.getProductsInCartCount() + " " + "In Cart";
        userNameTextView = rootView.findViewById(R.id.userNameTextView);
        userNameTextView.setText(userName);
        userCashTextView = rootView.findViewById(R.id.userCashTextView);
        userCashTextView.setText(userCash);
        cartCountTextView = rootView.findViewById(R.id.cartCountTextView);
        cartCountTextView.setText(inCart);
        addNewToCartButton = rootView.findViewById(R.id.addNewToCartButton);
        finishPaymentButton = rootView.findViewById(R.id.finishPaymentButton);

        // ON CLICK LISTENERS

        addNewToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainLayout, new CameraFragment());
                transaction.commit();
            }
        });

        finishPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainLayout, new CartViewingFragment())
                        .addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;
    }

    // TOOLBAR INITIALIZATION

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.settingsMenuBtn:

                //TODO
                return true;
            case R.id.cartMenuBtn:

                //TODO
                return true;
            case R.id.exitMenuBtn:
                //TODO
                return true;
            default:
                break;
        }

        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
