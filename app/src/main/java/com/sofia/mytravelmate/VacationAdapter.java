package com.sofia.mytravelmate;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VacationAdapter extends RecyclerView.Adapter<VacationViewHolder> {
    private List<Vacation> vacationList;
    private Context context;


    public VacationAdapter(List<Vacation> vacationList, Context context) {
        this.vacationList = vacationList;
        this.context = context;
    }

    @NonNull
    @Override
    public VacationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.vacation_item, parent, false);
        return new VacationViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull VacationViewHolder holder, int position) {
        Vacation currentVacation = vacationList.get(position);
        holder.getTextViewVacationName().setText(currentVacation.getVacationName());
        holder.getTextViewLocation().setText(currentVacation.getLocation());
        holder.getTextViewPrice().setText(String.valueOf(currentVacation.getPrice()));
        holder.getImageView().setImageResource(currentVacation.getImageUrl());

        if (position % 2 == 1) {
            holder.getLinearLayout().setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return vacationList.size();
    }

}
