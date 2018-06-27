package com.dhirajnayak.axsimageapp.view;

import com.dhirajnayak.axsimageapp.model.imageresponse.Image;

import java.util.List;

/**
 * Class: ImageView
 * Purpose: hold methods to be called from presenter to communicate to view
 */
public interface ImageView {
    void displayProgressDialog();
    void cancelProgressDialog();
    void populateImages(List<Image> images);
    void errorFromService();
}
