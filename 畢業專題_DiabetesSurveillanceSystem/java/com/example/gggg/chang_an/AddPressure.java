package com.example.gggg.chang_an;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gggg.R;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class AddPressure extends Fragment {

    private View mView;
    private EditText etHigh;
    private EditText etLow;
    private EditText etHeart;
    private Button btClear;
    private Button btPass;
    Context context;

    @SuppressLint("ValidFragment")
    public AddPressure(){

    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            mView = inflater.inflate(R.layout.add_pressure_fragment, container, false);
            findViews();
        btClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                etHigh.setText(null);
                etLow.setText(null);
                etHeart.setText(null);
            }
        });

        btPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext()  , TimeOkActivity.class);
                startActivity(intent);
            }
        });
        return mView;
    }



    private void findViews() {
        etHigh = (EditText) mView.findViewById(R.id.etHigh);
        etLow = (EditText)  mView.findViewById(R.id.etLow);
        etHeart = (EditText)  mView.findViewById(R.id.etHeart);
        btClear = (Button)  mView.findViewById(R.id.清除);
        btPass = (Button)  mView.findViewById(R.id.略過);
    }

}
