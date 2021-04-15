package com.example.gggg.chang_an;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.gggg.MainActivity;
import com.example.gggg.R;

import java.util.Calendar;

public class TimeOkActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private TextView tvDateTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private Button btSure;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_ok);
       tvDateTime = (TextView) findViewById(R.id.tvDateTime);
        showNow();
    }

    private void showNow() {
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
        updateDisplay();
    }

    private void updateDisplay() {
        tvDateTime.setText(new StringBuilder().append(mYear).append("-")
        .append(pad(mMonth + 1)).append("-").append(pad(mDay))
        .append(" ").append(pad(mHour)).append(":")
        .append(pad(mMinute)));
    }

    private String pad(int number) {
        if (number >= 10)
            return String.valueOf(number);
        else
            return "0" + String.valueOf(number);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mYear = year;
        mMonth = month;
        mDay = dayOfMonth;
        updateDisplay();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mHour = hourOfDay;
        mMinute = minute;
        updateDisplay();
    }

    public static class DatePickerDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            TimeOkActivity activity = (TimeOkActivity) getActivity();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    activity, activity, activity.mYear, activity.mMonth, activity.mDay);
            return datePickerDialog;
        }
    }

    public static class TimePickerDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            TimeOkActivity activity = (TimeOkActivity) getActivity();
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    activity, activity, activity.mHour, activity.mMinute, false);
            return timePickerDialog;
        }
    }

    public void onDateClick(View view){
        DatePickerDialogFragment datePickerFragment = new DatePickerDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        datePickerFragment.show(fm, "datePicker");
    }

    public void onTimeClick(View view){
        TimePickerDialogFragment timePickerFragment = new TimePickerDialogFragment();
        FragmentManager fm = getSupportFragmentManager();
        timePickerFragment.show(fm, "timePicker");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_time_ok, container, false);
        findViews();
        btSure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                儲存並傳至歷史記錄
            }
        });
        return mView;
    }
    private void findViews() {
        btSure = (Button) mView.findViewById(R.id.儲存);
    }
}
