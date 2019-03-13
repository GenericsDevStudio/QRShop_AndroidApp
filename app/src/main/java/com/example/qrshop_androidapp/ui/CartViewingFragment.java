package com.example.qrshop_androidapp.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qrshop_androidapp.CartList;
import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.network.Resources;


public class CartViewingFragment extends Fragment {
    public CartViewingFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private FragmentActivity main;
    private View rootView;
    private RecyclerView  recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_cart_viewing, container, false);

        // INITIALIZATION
        setHasOptionsMenu(true);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(main.getBaseContext()));

        adapter = new CartList(Resources.getCurrentCart().getProductsInCart(), main.getBaseContext());
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
