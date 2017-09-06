package com.ashkp.mycontactlist;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ContactActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initListButton();
        initMapButton();
        initSettingsButton();
        initToggleButton();
        setForEditing(false);
        initChangeDateButton();
    }

    private void initListButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (ContactActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (ContactActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSettingsButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (ContactActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initToggleButton(){
        final ToggleButton editToggle = (ToggleButton) findViewById(R.id.toggleButtonEdit);
        editToggle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                setForEditing(editToggle.isChecked());
            }
        });
    }

    private void setForEditing(boolean enabled) {
        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);
        EditText editCity = (EditText) findViewById(R.id.editCity);
        EditText editState = (EditText) findViewById(R.id.editState);
        EditText editZipCode = (EditText) findViewById(R.id.editZipcode);
        EditText editPhone = (EditText) findViewById(R.id.editHome);
        EditText editCell = (EditText) findViewById(R.id.editCell);
        EditText editEmail = (EditText) findViewById(R.id.editEMail);
        Button buttonChange = (Button) findViewById(R.id.btnBirthday);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);

        editName.setEnabled(enabled);
        editAddress.setEnabled(enabled);
        editCity.setEnabled(enabled);
        editState.setEnabled(enabled);
        editZipCode.setEnabled(enabled);
        editPhone.setEnabled(enabled);
        editCell.setEnabled(enabled);
        editEmail.setEnabled(enabled);
        buttonChange.setEnabled(enabled);
        buttonSave.setEnabled(enabled);

        if(enabled) {
            editName.requestFocus();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void didFinishDatePickerDialog(Calendar selectedTime) {
        TextView birthday = (TextView) findViewById(R.id.textBirthday);
        birthday.setText(DateFormat.format("MM/dd/yyyy",
                selectedTime.getTimeInMillis()).toString());
    }

    private void initChangeDateButton(){
        Button changeDate = (Button) findViewById(R.id.btnBirthday);
        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
            }
        });
    }
}
