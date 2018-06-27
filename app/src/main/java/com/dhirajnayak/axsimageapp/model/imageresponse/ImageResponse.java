package com.dhirajnayak.axsimageapp.model.imageresponse;

import com.google.gson.annotations.SerializedName;

/**
 * Class: ImageResponse
 * Purpose: format the response from service
 */
public class ImageResponse {
    @SerializedName("photos")
    public ImageEntity mImageEntity;

    public ImageEntity getmImageEntity() {
        return mImageEntity;
    }

    public void setmImageEntity(ImageEntity mImageEntity) {
        this.mImageEntity = mImageEntity;
    }
}
