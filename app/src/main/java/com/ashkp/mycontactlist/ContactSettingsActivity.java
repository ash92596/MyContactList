package com.ashkp.mycontactlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class ContactSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);
        initListButton();
        initMapButton();
        initSettingsButton();
        initSettings();
        initSortByClick();
        initSortOrderClick();
        initBackgroundColor();

        final RelativeLayout ll=(RelativeLayout) findViewById(R.id.settings);

        final RadioButton radio_white = (RadioButton) findViewById(R.id.radioWhiteBackground);
        final RadioButton radio_blue = (RadioButton) findViewById(R.id.radioBlueBackground);
        final RadioButton radio_pink = (RadioButton) findViewById(R.id.radioPinkBackground);
        radio_white.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ll.setBackgroundColor(getResources().getColor(R.color.settings_background_white));

            }
        });

        radio_blue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ll.setBackgroundColor(getResources().getColor(R.color.settings_background_blue));

            }
        });

        radio_pink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ll.setBackgroundColor(getResources().getColor(R.color.settings_background_pink));

            }
        });

    }


    private void initListButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } //end public void onClick(View v)
        });
    }

    private void initMapButton(){
        ImageButton ibList = (ImageButton) findViewById( R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } //end public void onClick(View v)
        });
    }

    private void initSettingsButton() {
        ImageButton ibSettings = (ImageButton)findViewById(R.id.imageButtonSettings);
        ibSettings.setEnabled(false);

    }


    private void initSettings() {
        String sortBy = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortfield","contactname");
        String sortOrder = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortorder","ASC");
        String chooseBackgroundColor = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("background","WHITE");

        RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
        RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
        RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthday);
        if (sortBy.equalsIgnoreCase("contactname")) {
            rbName.setChecked(true);
        }
        else if (sortBy.equalsIgnoreCase("city")) {
            rbCity.setChecked(true);
        }
        else {
            rbBirthDay.setChecked(true);
        }

        RadioButton rbWhite = (RadioButton) findViewById(R.id.radioWhiteBackground);
        RadioButton rbBlue = (RadioButton) findViewById(R.id.radioBlueBackground);
        RadioButton rbPink = (RadioButton) findViewById(R.id.radioPinkBackground);
        if (chooseBackgroundColor.equalsIgnoreCase("WHITE")) {
            rbWhite.setChecked(true);
        }
        else if (sortBy.equalsIgnoreCase("BLUE")) {
            rbBlue.setChecked(true);
        }
        else {
            rbPink.setChecked(true);
        }

        RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
        RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
        if (sortOrder.equalsIgnoreCase("ASC")) {
            rbAscending.setChecked(true);
        }
        else {
            rbDescending.setChecked(true);
        }
    }

    private void initSortByClick() {
        RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroupSortBy);
        rgSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

                                                @Override
                                                public void onCheckedChanged(RadioGroup arg0, int arg1) {
        RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
        RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
        if (rbName.isChecked()) {
          getSharedPreferences("MyContactListPreferences",
          Context.MODE_PRIVATE).edit()
          .putString("sordfield", "contactname").apply();
        }
        else if (rbCity.isChecked()) {
         getSharedPreferences("MyContactListPreferences",
         Context.MODE_PRIVATE).edit()
         .putString("sortfield", "city").apply();
        }
        else {
         getSharedPreferences("MyContactListPreferences",
         Context.MODE_PRIVATE).edit()
         .putString("sortfield", "birthay").apply();
         }
                                                }

        }
        );
    }

    private void initSortOrderClick() {
        RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroupSortOrder);
        rgSortOrder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                   public void onCheckedChanged(RadioGroup arg0, int arg1) {
        RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
        if (rbAscending.isChecked()) {
        getSharedPreferences("MyContactListPreferences",
        Context.MODE_PRIVATE).edit()
        .putString("sortorder", "ASC").apply();
        }
        else {
        getSharedPreferences("MyContactListPreferences",
        Context.MODE_PRIVATE).edit()
        .putString("sortorder", "DESC").apply();
        }
       }
       }
        );
    }

    private void initBackgroundColor() {
        RadioGroup rgBackground = (RadioGroup) findViewById(R.id.radioGroupBackgroundColors);
        rgBackground.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup arg0, int arg1) {
        RadioButton rbWhite = (RadioButton) findViewById(R.id.radioWhiteBackground);
        RadioButton rbBlue = (RadioButton) findViewById(R.id.radioBlueBackground);
        if (rbWhite.isChecked()) {
         getSharedPreferences("MyContactListPreferences",
         Context.MODE_PRIVATE).edit()
         .putString("background", "WHITE").apply();
        }
        else if (rbBlue.isChecked()) {
            getSharedPreferences("MyContactListPreferences",
                    Context.MODE_PRIVATE).edit()
                    .putString("background", "BLUE").apply();
        }
        else {
            getSharedPreferences("MyContactListPreferences",
                    Context.MODE_PRIVATE).edit()
                    .putString("background", "PINK").apply();
        }
         }
        }
        );
    }

}