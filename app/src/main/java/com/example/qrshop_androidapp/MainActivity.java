package com.example.qrshop_androidapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.qrshop_androidapp.R;
import com.example.qrshop_androidapp.network.Resources;
import com.example.qrshop_androidapp.ui.CameraFragment;
import com.example.qrshop_androidapp.ui.CartViewingFragment;
import com.example.qrshop_androidapp.ui.LoginFragment;
import com.example.qrshop_androidapp.ui.MainMenuFragment;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import static com.example.qrshop_androidapp.ui.MainMenuFragment.bought;

public class MainActivity extends AppCompatActivity {


    // TODO: FIX SCREEN ROTATION ON CameraFragment


    FragmentManager afterQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shouldDisplayHomeUp();
        afterQr  = getSupportFragmentManager();
        FragmentManager fm = getSupportFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                shouldDisplayHomeUp();
            }
        });
         FragmentTransaction transaction = fm
                 .beginTransaction().replace(R.id.mainLayout, new LoginFragment());
         transaction.commit();
    }

    // BACK BUTTON IMPLEMENTATION

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canGoBack = getSupportFragmentManager().getBackStackEntryCount() > 0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canGoBack);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }

    // QR CODE RESULT HANDLER


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            Resources.findProduct(result.getContents());
            MainMenuFragment.checker = true;
            FragmentTransaction transaction = afterQr.beginTransaction()
                    .replace(R.id.mainLayout, new MainMenuFragment(), "MainMenuAfterQr");
            transaction.commitAllowingStateLoss();
        }
    }
}
