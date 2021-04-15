package com.example.gggg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.gggg.chang_an.AddPressure;
import com.example.gggg.chang_an.AddSugarWeight;
import com.example.gggg.chang_an.NewDataFragment;

public class MainActivity extends AppCompatActivity{
private NewDataFragment NDF;
private  exerciseFragment ef;
private AddSugarWeight addSugarWeight;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_newdata:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this  , NewDataFragment.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_history:
                    return true;
                case R.id.navigation_exercise:
                    setFragment(ef);
                    //Intent intent = new Intent(MainActivity.this, exerciseactivity.class );
                    //startActivity(intent);
                    return true;
                case R.id.navigation_news:
                    return true;
                case R.id.navigation_others:
                    return true;
            }
            return false;
        }

        private void setFragment(Fragment fragment) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ef = new exerciseFragment();

    }





}
