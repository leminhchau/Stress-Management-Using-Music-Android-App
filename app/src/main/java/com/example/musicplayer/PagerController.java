package com.example.musicplayer;



import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController extends FragmentPagerAdapter {
    int tabCounts;

    public PagerController(@NonNull FragmentManager fm, int tabCounts) {
        super(fm, tabCounts);
        this.tabCounts = tabCounts;
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0)
        {
            Log.i("info", "the page num is " + String.valueOf(i));
            return new currentmusic();
        }

        else{
            Log.i("info", "the page num is " + String.valueOf(i));
            return new chart();

        }


    }

//    @Override
//    public int getItemPosition(Object object) {
//        // this method will be called for every fragment in the ViewPager
//        if (object instanceof SomePermanantCachedFragment) {
//            return POSITION_UNCHANGED; // don't force a reload
//        } else {
//            // POSITION_NONE means something like: this fragment is no longer valid
//            // triggering the ViewPager to re-build the instance of this fragment.
//            return POSITION_NONE;
//        }
//    }
    @Override
    public int getCount() {
        return tabCounts;
    }
}
