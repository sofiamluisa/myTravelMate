package com.sofia.mytravelmate;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sofia.mytravelmate.activity.EditAddActivity;
import com.sofia.mytravelmate.activity.ReadOnlyActivity;
import com.sofia.mytravelmate.room.VacationDatabase;

public class VacationViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewVacationName, textViewLocation, textViewPrice;
    private final LinearLayout linearLayout;
    private ImageView imageView;
    private Vacation vacation;

    public VacationViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewVacationName = itemView.findViewById(R.id.textViewVacationName);
        textViewLocation = itemView.findViewById(R.id.textViewLocation);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        linearLayout = itemView.findViewById(R.id.linearLayoutVacation);
        imageView = itemView.findViewById(R.id.imageView);
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                VacationDatabase appDB = VacationDatabase.getInstance(itemView.getContext());
//                appDB.vacationDao().deleteVacation(vacation);
                Intent intent = new Intent(itemView.getContext(), EditAddActivity.class);
                intent.putExtra("vacation", vacation);
                itemView.getContext().startActivity(intent);
                return false;
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), ReadOnlyActivity.class);
                intent.putExtra("vacation", vacation);
                itemView.getContext().startActivity(intent);
            }
        });
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public TextView getTextViewVacationName() {
        return textViewVacationName;
    }

    public TextView getTextViewLocation() {
        return textViewLocation;
    }

    public TextView getTextViewPrice() {
        return textViewPrice;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setTextViewVacationName(TextView textViewVacationName) {
        this.textViewVacationName = textViewVacationName;
    }

    public void setTextViewLocation(TextView textViewLocation) {
        this.textViewLocation = textViewLocation;
    }

    public void setTextViewPrice(TextView textViewPrice) {
        this.textViewPrice = textViewPrice;
    }
}
