package com.dhirajnayak.axsimageapp.apiinterface;

import com.dhirajnayak.axsimageapp.model.imageresponse.ImageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Name: ImageApiInterface
 * Purpose: Interface for Image services
 */
public interface ImageApiInterface {
    @GET(" ")
    Call<ImageResponse> getImagesFromServer();
}
