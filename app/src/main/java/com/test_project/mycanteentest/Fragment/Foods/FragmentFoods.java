package com.test_project.mycanteentest.Fragment.Foods;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.test_project.mycanteentest.Adapter.AdapterFood;
import com.test_project.mycanteentest.Model.FoodsItem;
import com.test_project.mycanteentest.Networking.NetworkConfig;
import com.test_project.mycanteentest.Presenter.PresenterFoods;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentFoods extends Fragment implements FoodsView {

    private ArrayList<FoodsItem> list = new ArrayList();
    private RecyclerView recyclerView;
    private AdapterFood adapterFood;

    PresenterFoods presenterFoods;

    NetworkConfig networkConfig;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_foods, container, false);

        recyclerView = v.findViewById(R.id.rv_foods);
//        adapterDrink.getContext(this.getActivity());
        list = new ArrayList<>();

        presenterFoods = new PresenterFoods(this);
//        adapterDrink.setData(list);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        llm.setOrientation(LinearLayout.VERTICAL);
        adapterFood = new AdapterFood(list, getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterFood);

        presenterFoods.getFoods();
        return v;
    }

    @Override
    public void getFoods(List<FoodsItem> itemList) {
        list.addAll(itemList);
        adapterFood.notifyDataSetChanged();
    }

}