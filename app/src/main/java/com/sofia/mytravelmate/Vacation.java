package com.sofia.mytravelmate;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "vacation")
public class Vacation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String vacationName;
    private String location;
    private int price;
    private int imageUrl;

    public Vacation() {}

    public Vacation(int id, String vacationName, String location, int price , int imageUrl) {
        this.id = id;
        this.vacationName = vacationName;
        this.location = location;
        this.price = price;
        this.imageUrl = imageUrl;

    }

    @Ignore
    public Vacation(String vacationName, String location, int price , int imageUrl) {
        this.vacationName = vacationName;
        this.location = location;
        this.price = price;
        this.imageUrl = imageUrl;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVacationName() {
        return vacationName;
    }

    public void setVacationName(String vacationName) {
        this.vacationName = vacationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Vacation{"+
                "id='" + id +'\''+", vacationName='" + vacationName+'\''+
                ", location='" + location +'\'' + ", price='" + price +'\''+'}';
    }
}
