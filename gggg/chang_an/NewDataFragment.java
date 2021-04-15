package com.example.gggg.chang_an;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gggg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDataFragment extends AppCompatActivity {

    TabLayout tb_content;
    public ViewPager vp_content;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private ViewPagerAdapter adapter = null;
    private Context context = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_data_fragment);
        tb_content = findViewById(R.id.tl_tabs);
        vp_content = findViewById(R.id.pager);
        initial();
        tb_content.setTabMode(TabLayout.MODE_FIXED);
        vp_content.setAdapter(adapter);
        tb_content.setupWithViewPager(vp_content);
    }

    private void initial() {
        fragments.add(new AddSugarWeight());
        fragments.add(new AddPressure());
        titles.add("血糖");
        titles.add("血壓");
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
    }
}

