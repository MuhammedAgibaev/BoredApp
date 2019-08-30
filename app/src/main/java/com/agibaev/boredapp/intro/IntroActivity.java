package com.agibaev.boredapp.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.agibaev.boredapp.main.MainActivity;
import com.agibaev.boredapp.R;
import com.rd.PageIndicatorView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private IntroPageAdapter introPageAdapter;
    private ViewPager viewPager;
    private TextView skipBtn, nextBtn;
    PageIndicatorView pageIndicatorView;
    ArrayList<IntroPageConfig> pages = new ArrayList<>();

    public static void start(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
    }

    private void init() {
        skipBtn = findViewById(R.id.btnSkip);
        nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
        skipBtn.setOnClickListener(this);
        initViewPager();
    }

    private void initViewPager() {

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_2,
                R.drawable.capitan));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_3,
                R.drawable.vision));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_1,
                R.drawable.deadpool));

        introPageAdapter = new IntroPageAdapter(getSupportFragmentManager(), pages);
        pageIndicatorView = findViewById(R.id.pagerIndikator);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(introPageAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                onPageChanged(position);
                onPageSkip(position);
            }
        });

        pageIndicatorView.setViewPager(viewPager);
    }

    private void onPageSkip(int position) {
        String btnFinish = "Skip";
        if (position == 2) {
            btnFinish = "";
        }
        skipBtn.setText(btnFinish);
    }

    private void onPageChanged(int position) {
        String btnNext = "Next";
        if (position == 2) {
            btnNext = "Finish";
        }
        nextBtn.setText(btnNext);
    }

    private void onNextClick(){
        if(viewPager.getCurrentItem() == introPageAdapter.getCount()-1){
             MainActivity.start(this);
             finish();
        }else {
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next_btn:
                onNextClick();
                break;

            case R.id.btnSkip:
                MainActivity.start(this);
                finish();
        }
    }

    public class IntroPageAdapter extends FragmentPagerAdapter{

        List<IntroPageConfig> pages;

        public IntroPageAdapter(FragmentManager fm, List<IntroPageConfig> pages)

        {

            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            return IntroPageFragment.newInstance(pages.get(position));
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }



}
