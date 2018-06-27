package com.dhirajnayak.axsimageapp.presenter;

import com.dhirajnayak.axsimageapp.businessaccesslayer.image.ImageBusiness;
import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.dhirajnayak.axsimageapp.view.ImageView;

import java.util.List;

/**
 * Name: ImagePresenter
 * Purpose: Handles the communication between ImageView and Image model
 */
public class ImagePresenter implements ImageInteractor {
    private ImageView mImageView;
    private ImageBusiness mImageBusiness;

    public ImagePresenter(ImageView mImageView, ImageBusiness mImageBusiness) {
        this.mImageView = mImageView;
        this.mImageBusiness = mImageBusiness;
    }

    /**
     * called by view to request data
     */
    public void getImagesFromService(){
        //show loading
        mImageView.displayProgressDialog();
        //call business method to get data
        mImageBusiness.getImageRequest(this);
        //hide loding
        mImageView.cancelProgressDialog();
    }

    /**
     * method called when business returns success to request
     * @param images
     */
    @Override
    public void onImageRequestSuccess(List<Image> images) {
        mImageView.populateImages(images);
    }

    /**
     * method called when business returns failure to request
     */
    @Override
    public void onImageRequestFailure() {
        mImageView.errorFromService();
    }
}
