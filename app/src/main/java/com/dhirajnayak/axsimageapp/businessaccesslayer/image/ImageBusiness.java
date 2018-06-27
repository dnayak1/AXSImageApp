package com.dhirajnayak.axsimageapp.businessaccesslayer.image;

import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.dhirajnayak.axsimageapp.dataaccesslayer.image.ImageServiceRepository;
import com.dhirajnayak.axsimageapp.presenter.ImageInteractor;

import java.util.List;

/**
 * Name: ImageBusiness
 * Purpose: Contains the business logic related to image data
 */
public class ImageBusiness implements ImageResponseListener{

    private ImageInteractor mImageInteractor;

    /**
     * method to get image data from service
     * @param imageInteractor
     */
    public void getImageRequest(ImageInteractor imageInteractor){
        mImageInteractor = imageInteractor;
        ImageServiceRepository imageServiceRepository = new ImageServiceRepository();
        imageServiceRepository.imageRequest(this);
    }

    /**
     * method called if service returns list of images
     * @param images
     */
    @Override
    public void onImageRequestSuccess(List<Image> images) {
        mImageInteractor.onImageRequestSuccess(images);
    }

    /**
     * method called on service error
     */
    @Override
    public void onImageRequestFailure() {
        mImageInteractor.onImageRequestFailure();
    }
}
