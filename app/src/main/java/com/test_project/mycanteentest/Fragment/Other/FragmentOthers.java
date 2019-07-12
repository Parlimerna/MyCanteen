package com.test_project.mycanteentest.Fragment.Other;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.test_project.mycanteentest.Adapter.AdapterFood;
import com.test_project.mycanteentest.Adapter.AdapterOther;
import com.test_project.mycanteentest.Fragment.Foods.FoodsView;
import com.test_project.mycanteentest.Model.FoodsItem;
import com.test_project.mycanteentest.Model.OtherItem;
import com.test_project.mycanteentest.Networking.NetworkConfig;
import com.test_project.mycanteentest.Presenter.PresenterFoods;
import com.test_project.mycanteentest.Presenter.PresenterOthers;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentOthers extends Fragment implements OthersView {

    private ArrayList<OtherItem> list = new ArrayList();
    private RecyclerView recyclerView;
    private AdapterOther adapterOther;

    PresenterOthers presenterOthers;

    NetworkConfig networkConfig;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_other, container, false);

        recyclerView = v.findViewById(R.id.rv_others);
//        adapterDrink.getContext(this.getActivity());
        list = new ArrayList<>();

        presenterOthers = new PresenterOthers(this);
//        adapterDrink.setData(list);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        llm.setOrientation(LinearLayout.VERTICAL);
        adapterOther = new AdapterOther(list, getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterOther);

        presenterOthers.getOthers();
        return v;
    }

    @Override
    public void getOthers(List<OtherItem> itemList) {
        list.addAll(itemList);
        adapterOther.notifyDataSetChanged();
    }

}