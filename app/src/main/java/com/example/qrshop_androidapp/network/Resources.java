package com.example.qrshop_androidapp.network;

import android.os.CountDownTimer;
import android.util.Log;

import com.example.qrshop_androidapp.model.Cart;
import com.example.qrshop_androidapp.model.Product;
import com.example.qrshop_androidapp.model.User;
import com.example.qrshop_androidapp.ui.LoginFragment;
import com.example.qrshop_androidapp.ui.SignUpFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {

    // INITIALIZATION

    private static User currentUser;
    private static Cart currentCart = new Cart();
    private static final String SERVER_URL = "http://vasylko.zzz.com.ua/index.php/";
    private static Gson gson = new GsonBuilder().create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    private static Link link = retrofit.create(Link.class);

    // FIELDS FOR findProduct METHOD

    private static Product toReturn;
    private static boolean findingFinished;

    // METHODS

    public static boolean registerUser(String login, String password, String name) {
        SignUpFragment.registeredChecker = false;
        Call<Object> call = link.registerUser(login, password, name);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                String check = response.message();
                Log.d("REGRESPONSE : ", check);
                SignUpFragment.registeredChecker = true;
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("ONFAILURE : ", t.getMessage());
                SignUpFragment.registeredChecker = true;
            }
        });
        return true;
    }


    public static boolean loginUser(final String login, final String password) {
        currentUser = null;
        LoginFragment.checker = false;
            Call<Object> call = link.loginUser(login, password);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        User[] users = gson.fromJson(response.body().toString(), User[].class);
                        if(users.length != 0){
                            currentUser = new User(login, password, users[0].getId(), users[0].getName(), users[0].getCash());
                            LoginFragment.checker = true;
                            Log.d("LOGIN : ", currentUser.getLogin());
                            Log.d("PASSWORD : ", currentUser.getPassword());
                            Log.d("ID : ", currentUser.getId());
                            Log.d("NAME : ", currentUser.getName());
                            Log.d("CASH : ", currentUser.getCash());
                        }else{
                            currentUser = null;
                            LoginFragment.checker = true;
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Log.d("ONFAILURE : ", t.getMessage());
                    }
                });
        return true;
    }

    public static User getCurrentUser() {return currentUser; }

    public static Cart getCurrentCart() { return currentCart; }

    // METHOD FOR TESTING

    public static void addToCart(Product toAdd){
        currentCart.addToCart(toAdd);
    }

    //
    // REMOVING PRODUCT IN CART

    public static void removeFromCart(int position){
        currentCart.removeFromCart(position);
    }

    //

    public static Product findProduct(String code) {
        toReturn = null;
        findingFinished = false;
        Call<Object> call = link.findProduct(code, getCurrentUser().getId());
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Product check = gson.fromJson(response.body().toString(), Product.class);
                if(check.getIdentifier() != null && check.getName() != null && check.getPrice() != null){
                    toReturn = check;
                    findingFinished = true;
                }else{
                    toReturn = null;
                    findingFinished = true;
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("ONFAILURE : ", t.getMessage());
            }
        });
        CountDownTimer count = new CountDownTimer(10000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(findingFinished){
                    currentCart.addToCart(toReturn);
                    // FLAG
                    cancel();
                }
            }

            @Override
            public void onFinish() {
                // FLAG
                cancel();
            }
        };
        count.start();
        return toReturn;
    }
}



