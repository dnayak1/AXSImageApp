package com.dhirajnayak.axsimageapp.model.imageresponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: ImageEntity
 * Purpose: format the response from service
 */
public class ImageEntity {
    @SerializedName("photo")
    private ArrayList<Image> mImages;

    public List<Image> getmImages() {
        return mImages;
    }

    public void setmImages(ArrayList<Image> mImages) {
        this.mImages = mImages;
    }
}
