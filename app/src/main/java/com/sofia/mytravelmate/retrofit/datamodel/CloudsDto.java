package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

public class CloudsDto {

    @SerializedName("all")
    private int all;

    public int getAll() {
        return all;
    }
}
