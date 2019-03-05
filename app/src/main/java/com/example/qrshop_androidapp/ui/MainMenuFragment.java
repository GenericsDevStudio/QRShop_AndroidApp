package com.example.qrshop_androidapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        // INITIALIZATION

        return rootView;
    }

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
}
