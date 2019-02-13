package com.example.tabbedlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pager extends FragmentStatePagerAdapter {

    int tabCount;

    public pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                Mainprofile tab1 = new Mainprofile();
                return tab1;
            case 1:
                Mergerprofile tab2 = new Mergerprofile();
                return tab2;

                default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
