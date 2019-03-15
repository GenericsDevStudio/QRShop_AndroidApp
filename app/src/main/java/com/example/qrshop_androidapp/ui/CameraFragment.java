package com.example.qrshop_androidapp.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.model.Product;
import com.example.qrshop_androidapp.network.Resources;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import static com.example.qrshop_androidapp.ui.MainMenuFragment.bought;

public class CameraFragment extends Fragment {
    public CameraFragment() {
        // Required empty public constructor
    }

    // FIELDS

    private IntentIntegrator qrScan;
    private View rootView;
    private FragmentActivity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // INFLATING

        rootView = inflater.inflate(R.layout.fragment_camera, container, false);

        // INITIALIZATION

        qrScan = new IntentIntegrator(main);

        return rootView;
    }

    // CAMERA PREVIEW

    @Override
    public void onResume() {
        super.onResume();
        qrScan.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        qrScan.setPrompt("Scan");
        qrScan.setCameraId(0);
        qrScan.setBeepEnabled(false);
        qrScan.setBarcodeImageEnabled(false);
        qrScan.initiateScan();
    }

    @Override
    public void onPause() {
        super.onPause();
        qrScan.setTimeout(0);
    }

    // GETTING ACTIVITY

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = getActivity();
    }
}
