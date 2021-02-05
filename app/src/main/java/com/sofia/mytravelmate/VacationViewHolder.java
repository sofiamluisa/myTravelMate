package com.sofia.mytravelmate;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VacationViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewVacationName, textViewLocation, textViewPrice;
    private final LinearLayout linearLayout;
    private ImageView imageView;

    public VacationViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewVacationName=itemView.findViewById(R.id.textViewVacationName);
        textViewLocation = itemView.findViewById(R.id.textViewLocation);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        linearLayout = itemView.findViewById(R.id.linearLayoutVacation);
        imageView = itemView.findViewById(R.id.imageView);
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
