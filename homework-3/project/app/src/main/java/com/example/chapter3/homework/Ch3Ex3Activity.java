package com.example.chapter3.homework;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private ViewPager mViewPager = null;
    private TabLayout mTablayout = null;
    private List<Fragment> mfragmentList = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    CustomPagerAdapter customPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mfragmentList.add(new PlaceholderFragment());
        mfragmentList.add(new HelloFragment());

        mTitles.add("placeholder");
        mTitles.add("hello");

        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(),mfragmentList,  mTitles);
        mViewPager.setAdapter(customPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        mTablayout = (TabLayout)findViewById(R.id.tablayout);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class CustomPagerAdapter extends FragmentPagerAdapter{
        List<Fragment> mfragmentList = null;
        List<String> mTitles = null;
        public CustomPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList,
                                  List<String> titles){
            super(fragmentManager);
            mfragmentList = fragmentList;
            mTitles = titles;
        }

        @Override
        public Fragment getItem(int i) {
            if(mfragmentList != null){
                return mfragmentList.get(i);
            }
            return null;
        }

        @Override
        public int getCount() {
            if(mfragmentList != null){
                return mfragmentList.size();
            }
            return 0;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if(mTitles != null){
                return mTitles.get(position);
            }
            return super.getPageTitle(position);
        }
    }
}
