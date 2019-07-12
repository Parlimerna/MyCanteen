package com.test_project.mycanteentest.Presenter;

import android.util.Log;

import com.test_project.mycanteentest.Fragment.Foods.FoodsView;
import com.test_project.mycanteentest.Fragment.Other.OthersView;
import com.test_project.mycanteentest.Model.FoodsItem;
import com.test_project.mycanteentest.Model.Kantin;
import com.test_project.mycanteentest.Model.OtherItem;
import com.test_project.mycanteentest.Networking.NetworkConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterOthers {

    private OthersView othersView;
    private NetworkConfig networkConfig;

    public PresenterOthers(OthersView view) {
        this.othersView = view;

        if (this.networkConfig == null) {
            this.networkConfig = new NetworkConfig();
        }
    }

    public void getOthers() {
        networkConfig.createService()
                .getContent()
                .enqueue(new Callback<Kantin>() {
                    @Override
                    public void onResponse(Call<Kantin> call, Response<Kantin> response) {
                        if (response.isSuccessful()) {
                            Kantin data = response.body();
                            Log.i("aaaa", "response success " + response.body());

                            List<OtherItem> dataList = data.getOther();
                           othersView.getOthers(dataList);

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
