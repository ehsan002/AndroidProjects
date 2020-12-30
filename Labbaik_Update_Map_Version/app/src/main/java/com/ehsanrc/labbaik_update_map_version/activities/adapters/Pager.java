package com.ehsanrc.labbaik_update_map_version.activities.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ehsanrc.labbaik_update_map_version.activities.activities.Jilhajj10;
import com.ehsanrc.labbaik_update_map_version.activities.activities.Jilhajj11;
import com.ehsanrc.labbaik_update_map_version.activities.activities.Jilhajj8;
import com.ehsanrc.labbaik_update_map_version.activities.activities.Jilhajj9;

/**
 * Created by USER on 10/06/2016.
 */
public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Jilhajj8 tab1 = new Jilhajj8();
                return tab1;
            case 1:
                Jilhajj9 tab2 = new Jilhajj9();
                return tab2;
            case 2:
                Jilhajj10 tab3 = new Jilhajj10();
                return tab3;
            case 3:
                Jilhajj11 tab4 = new Jilhajj11();
                return tab4;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set the titles
        switch(position) {
            case 0:
                return "Jilhajj 8";
            case 1:
                return "Jilhajj 9";
            case 2:
                return "Jilhajj 10";
            case 3:
                return "Jilhajj 11-13";
        }
        return null;
    }
}
