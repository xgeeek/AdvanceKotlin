package com.advance.kotlin.fragmentvisible;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xugang
 * @date 2023/5/17
 */
public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mList = new ArrayList<BaseFragment>();

    public ViewPagerFragmentAdapter(@NonNull FragmentManager fm, List<BaseFragment> list) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }
}
