package com.test_project.mycanteentest.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.test_project.mycanteentest.Fragment.Drinks.FragmentDrinks;
import com.test_project.mycanteentest.Fragment.Foods.FragmentFoods;
import com.test_project.mycanteentest.Fragment.Other.FragmentOthers;

public class PagerFragment extends FragmentStatePagerAdapter {

    private static int tabFragmentCount = 3;

    //Constructor to the class
    public PagerFragment(FragmentManager fm, int tabFragmentCount) {
        super(fm);
        //Initializing tab count
        this.tabFragmentCount= tabFragmentCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                FragmentFoods tab1 = new FragmentFoods();
                return tab1;
            case 1:
                FragmentDrinks tab2 = new FragmentDrinks();
                return tab2;
            case 2:
                FragmentOthers tab3 = new FragmentOthers();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabFragmentCount;
    }
}
