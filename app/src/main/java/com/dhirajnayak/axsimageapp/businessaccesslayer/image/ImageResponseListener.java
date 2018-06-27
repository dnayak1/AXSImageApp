package com.dhirajnayak.axsimageapp.businessaccesslayer.image;

import com.dhirajnayak.axsimageapp.model.imageresponse.Image;

import java.util.List;

/**
 * Name: ImageResponseListener
 * Purpose: contains abstract methods to be called by service
 */
public interface ImageResponseListener {
    void onImageRequestSuccess(List<Image> images);
    void onImageRequestFailure();
}
