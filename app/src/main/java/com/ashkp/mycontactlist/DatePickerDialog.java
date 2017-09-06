package com.ashkp.mycontactlist;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


/**
 * Created by ashkp on 9/5/2017.
 */

public class DatePickerDialog extends DialogFragment {

    public interface SaveDateListener {
        void didFinishDatePickerDialog(Calendar selectedTime);
    }

    public DatePickerDialog() {
        //Empty constructor requiredd for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.select_date, container);

        getDialog().setTitle("Select Date");

        final DatePicker dp = (DatePicker) view.findViewById(R.id.birthdayPicker);

        Button saveButton = (Button) view.findViewById(R.id.buttonSelect);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View arg0) {
                Calendar selectedTime = Calendar.getInstance();
                selectedTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                saveItem(selectedTime);
            }
        });

        Button cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;
    }

    private void saveItem (Calendar selectedTime) {
        SaveDateListener activity = (SaveDateListener) getActivity();

        activity.didFinishDatePickerDialog(selectedTime);
        getDialog().dismiss();
    }

}
