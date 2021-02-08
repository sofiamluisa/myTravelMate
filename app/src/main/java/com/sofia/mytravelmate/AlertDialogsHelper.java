package com.sofia.mytravelmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class AlertDialogsHelper {


    public static void getAddSubjectDialog(final Activity activity, final View alertLayout) {
        final HashMap<String, EditText> editTextHashs = new HashMap<>();
        final EditText editTextVacationName = alertLayout.findViewById(R.id.editTextVacationName);
        editTextHashs.put("Vacation name", editTextVacationName);
        final EditText editTextLocation = alertLayout.findViewById(R.id.editTextLocation);
        editTextHashs.put("Vacation location", editTextLocation);
        TextView textViewSeekBar = alertLayout.findViewById(R.id.textViewSeekBar);
        SeekBar seekBar = alertLayout.findViewById(R.id.seekBar);
        ProgressBar progressBar = alertLayout.findViewById(R.id.progress_bar);
        final Vacation vacation = new Vacation();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textViewSeekBar.setText(" " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Add subject");
        alert.setCancelable(false);
        Button cancel = alertLayout.findViewById(R.id.cancel);
        Button save = alertLayout.findViewById(R.id.save);
        alert.setView(alertLayout);
        final AlertDialog dialog = alert.create();

        FloatingActionButton fab = activity.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editTextVacationName.getText()) || TextUtils.isEmpty(editTextLocation.getText())) {
                    for (Map.Entry<String, EditText> entry : editTextHashs.entrySet()) {
                        if(TextUtils.isEmpty(entry.getValue().getText())) {
                            entry.getValue().requestFocus();
                        }
                    }
                } else {

                    vacation.setVacationName(editTextVacationName.getText().toString());
                    vacation.setLocation(editTextLocation.getText().toString());
                    editTextVacationName.getText().clear();
                    editTextLocation.getText().clear();
                    editTextVacationName.requestFocus();
                    dialog.dismiss();
                }
            }
        });


    }
}

