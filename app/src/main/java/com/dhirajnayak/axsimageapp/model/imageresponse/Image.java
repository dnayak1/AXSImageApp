package com.dhirajnayak.axsimageapp.model.imageresponse;

import com.google.gson.annotations.SerializedName;

/**
 * Class: Image
 * Purpose: forms the pojo and holds the response from service
 */
public class Image {
    @SerializedName("title")
    public String mTitle;

    @SerializedName("url_m")
    public String mUrl;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
