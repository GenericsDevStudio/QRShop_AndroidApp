package com.example.qrshop_androidapp.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.model.Product;
import com.example.qrshop_androidapp.network.Resources;

public class CameraFragment extends Fragment {
    public CameraFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private View rootView;
    private FragmentActivity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_camera, container, false);

        // INITIALIZATION

        Resources.addToCart(new Product("1", "Jacket", "250"));

        FragmentTransaction transaction = main.getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainLayout, new MainMenuFragment());
        transaction.commit();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
