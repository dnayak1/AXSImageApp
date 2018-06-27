package com.dhirajnayak.axsimageapp.presenter;

import com.dhirajnayak.axsimageapp.model.imageresponse.Image;

import java.util.List;

/**
 * Name: ImageInteractor
 * Purpose: contains methods to interact with business
 */
public interface ImageInteractor {
    void onImageRequestSuccess(List<Image> images);
    void onImageRequestFailure();
}

