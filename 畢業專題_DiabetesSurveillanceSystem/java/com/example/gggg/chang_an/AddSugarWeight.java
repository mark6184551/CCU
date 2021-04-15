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
public class AddSugarWeight extends Fragment {

    private View mView;
    private EditText etValue;
    private EditText etWeight;
    private Button btClear;
    private Button btPass;
    Context context;


    public AddSugarWeight() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.add_sugar_weight_fragment, container, false);
        findViews();
        btClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                etValue.setText(null);
                etWeight.setText(null);
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

    private void findViews(){
        etValue = (EditText) mView.findViewById(R.id.etValue);
        etWeight = (EditText) mView.findViewById(R.id.etWeight);
        btClear = (Button) mView.findViewById(R.id.清除);
        btPass = (Button) mView.findViewById(R.id.略過);
    }
}
