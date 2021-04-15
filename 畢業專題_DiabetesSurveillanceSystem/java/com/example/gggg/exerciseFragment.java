package com.example.gggg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gggg.R.layout;


/**
 * A simple {@link Fragment} subclass.
 */
public class exerciseFragment extends Fragment {
    String str;
    double kaluli;
    Button button;
    TextView result;
    EditText input_hour;

    public exerciseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        //運動類型下拉清單
        ArrayAdapter<String> sport;
        final Spinner spinner;
        final String[] sp = {"散步", "慢跑(8 公里/時)", "快跑(12 公里/時)", "騎腳踏車", "瑜珈", "排球",
                "桌球", "棒壘球 ", "高爾夫", "羽毛球", "游泳", "籃球", "網球", "跳繩"};
        //將可選内容與ArrayAdapter連接起來
        sport = new ArrayAdapter<String>(getActivity(), R.layout.spin, sp);
        // 對應控件
        spinner = (Spinner) view.findViewById(R.id.spinner);
        //設置下拉列表的風格
        sport.setDropDownViewResource(R.layout.spin);
        //將adapter 添加到spinner中
        spinner.setAdapter(sport);
        //對照所選運動所需的卡路里
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                str = (String) spinner.getSelectedItem();
                //對照
                if (str == "散步") kaluli = 4.5;
                if (str == "慢跑(8 公里/時)") kaluli = 8.2;
                if (str == "快跑(12 公里/時)") kaluli = 12.7;
                if (str == "騎腳踏車") kaluli = 6.2;
                if (str == "瑜珈") kaluli = 3.0;
                if (str == "排球") kaluli = 3.6;
                if (str == "桌球") kaluli = 4.2;
                if (str == "棒壘球") kaluli = 4.7;
                if (str == "高爾夫") kaluli = 5.0;
                if (str == "羽毛球") kaluli = 5.1;
                if (str == "游泳") kaluli = 8.3;
                if (str == "籃球") kaluli = 7.3;
                if (str == "網球") kaluli = 6.6;
                if (str == "跳繩") kaluli = 10.5;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //卡路里按鈕設定
        button = (Button) view.findViewById(R.id.button);
        result = (TextView) view.findViewById(R.id.result);
        input_hour = (EditText) view.findViewById(R.id.input_hour);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          calcal(v);
                                      }
                                  });

        return view;

    }
    public void calcal(View v){

        //輸入之時間(單位:小時)
        double input = Double.parseDouble(input_hour.getText().toString());
        //計算出卡路里
        double cal = kaluli * 60 * input;
        //結果
        result.setText("結果: 共消耗"+ cal+"大卡");
    }
}



