package com.example.qrshop_androidapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.network.Resources;


public class MainMenuFragment extends Fragment {
    public MainMenuFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        // INITIALIZATION

        return rootView;
    }
}
