package com.sofia.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.res.TypedArray;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sofia.mytravelmate.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EditAddActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private TextView textViewDateTo;
    private TextView textViewDateFrom;
    private EditText editTextVacationName;
    private EditText editTextLocation;
    private TextView textViewSeekBar;
    private SeekBar seekBar;
    private ProgressBar progressBar;
    private Button cancel;
    private Button save;
    private Vacation vacation;
    final HashMap<String, EditText> editTextHashs = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);

        editTextVacationName = findViewById(R.id.editTextVacationName);
        editTextLocation = findViewById(R.id.editTextLocation);
        textViewSeekBar = findViewById(R.id.textViewSeekBar);
        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progress_bar);
        cancel = findViewById(R.id.cancel);
        save = findViewById(R.id.save);
        textViewDateTo = findViewById(R.id.textViewDateTo);
        textViewDateFrom = findViewById(R.id.textViewDateFrom);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);


        Optional.ofNullable(getIntent().getSerializableExtra("vacation123")).ifPresent((vac) -> vacation = (Vacation) vac);


        if (vacation != null) {
            editTextVacationName.setText(vacation.getVacationName());
            editTextLocation.setText(vacation.getLocation());
            textViewSeekBar.setText(String.valueOf(vacation.getPrice()));
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!TextUtils.isEmpty(editTextVacationName.getText()) && !TextUtils.isEmpty(editTextLocation.getText())) {

                        VacationDatabase appDB = VacationDatabase.getInstance(getApplicationContext());
                        vacation.setVacationName(editTextVacationName.getText().toString());
                        vacation.setLocation(editTextLocation.getText().toString());
                        vacation.setPrice(Integer.parseInt(textViewSeekBar.getText().toString()));
                        appDB.vacationDao().updateVacation(vacation);

                    }
                    finish();
                }
            });
        } else {
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!TextUtils.isEmpty(editTextVacationName.getText()) && !TextUtils.isEmpty(editTextLocation.getText())) {
                        final TypedArray imgs = getResources().obtainTypedArray(R.array.arrayImages);
                        final Random rand = new Random();
                        final int rndInt = rand.nextInt(imgs.length());
                        final int resID = imgs.getResourceId(rndInt, 0);
                        VacationDatabase appDB = VacationDatabase.getInstance(getApplicationContext());
                        appDB.vacationDao().insertVacation(new Vacation(editTextVacationName.getText().toString(), editTextLocation.getText().toString(), Integer.parseInt(textViewSeekBar.getText().toString()), resID));

                    }
                    finish();
                }
            });

        }


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textViewSeekBar.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void OpenStartDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textViewDateFrom.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();

    }

    public void OpenFinishDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textViewDateTo.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}