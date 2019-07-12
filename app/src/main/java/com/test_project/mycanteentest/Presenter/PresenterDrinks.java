package com.test_project.mycanteentest.Presenter;

import android.util.Log;

import com.test_project.mycanteentest.Fragment.Drinks.DrinksView;
import com.test_project.mycanteentest.Model.DrinksItem;
import com.test_project.mycanteentest.Model.Kantin;
import com.test_project.mycanteentest.Networking.ApiService;
import com.test_project.mycanteentest.Networking.NetworkConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterDrinks {

    private DrinksView drinksView;
    private NetworkConfig networkConfig;

    public PresenterDrinks(DrinksView view) {
        this.drinksView = view;

        if (this.networkConfig == null) {
            this.networkConfig = new NetworkConfig();
        }
    }

    public void getDrinks() {
        networkConfig.createService()
                .getContent()
                .enqueue(new Callback<Kantin>() {
                    @Override
                    public void onResponse(Call<Kantin> call, Response<Kantin> response) {
                        if (response.isSuccessful()) {
                            Kantin data = response.body();
                            Log.i("aaaa", "response success " + response.body());

                            List<DrinksItem> dataList = data.getDrinks();
                            drinksView.getDrinks(dataList);

                        }else{
                            Log.i("aaaa", "response unsuccess " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Kantin> call, Throwable t) {
                        Log.i("aaaa", "response failure " + t.getMessage());
                    }
                });
    }

}
