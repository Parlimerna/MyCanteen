package com.test_project.mycanteentest.Fragment.Drinks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test_project.mycanteentest.Adapter.AdapterDrink;
import com.test_project.mycanteentest.Model.DrinksItem;
import com.test_project.mycanteentest.Networking.ApiService;
import com.test_project.mycanteentest.Networking.NetworkConfig;
import com.test_project.mycanteentest.Presenter.PresenterDrinks;
import com.test_project.mycanteentest.R;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class FragmentDrinks extends Fragment implements DrinksView {

    private ArrayList<DrinksItem> list = new ArrayList();
    private RecyclerView recyclerView;
    private AdapterDrink adapterDrink;


    PresenterDrinks presenterDrinks;

    NetworkConfig networkConfig;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_drinks, container, false);

        recyclerView = v.findViewById(R.id.rv_Drink12);
//        adapterDrink.getContext(this.getActivity());
        list = new ArrayList<>();

        presenterDrinks = new PresenterDrinks(this);
//        adapterDrink.setData(list);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        llm.setOrientation(LinearLayout.VERTICAL);
        adapterDrink = new AdapterDrink(list, getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapterDrink);

        presenterDrinks.getDrinks();
        return v;
    }


    @Override
    public void getDrinks(List<DrinksItem> itemList) {
        list.addAll(itemList);
        adapterDrink.notifyDataSetChanged();
    }

}



