package com.example.viewpagerwithtablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        appBarLayout = (AppBarLayout)findViewById(R.id.appBar);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        toolbar=(Toolbar)findViewById(R.id.toolBar);
        toolbar.setTitle(R.string.app_name);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            appBarLayout.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }

        ViewPagerAdapter pagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new FragmentOne(),"One");
        pagerAdapter.AddFragment(new FragmentTwo(),"Two");
        pagerAdapter.AddFragment(new FragmentThree(),"Three");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
