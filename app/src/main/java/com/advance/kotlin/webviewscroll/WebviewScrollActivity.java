package com.advance.kotlin.webviewscroll;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.advance.kotlin.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xugang
 * @date 2023/5/24
 */
public class WebviewScrollActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    List<String> titles;
    ViewPager mViewPager;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview_scroll);

        mTabLayout = findViewById(R.id.tab_layout_main);
        appBarLayout = findViewById(R.id.app_bar);


        titles = new ArrayList<>();
        titles.add("推荐1");
        titles.add("推荐2");
        titles.add("推荐推荐3");
        titles.add("推推荐4");
        titles.add("荐推荐5");
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));

        mViewPager = findViewById(R.id.vp_content_bottom);


        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }



    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new WebViewViewPagerFragment();
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
