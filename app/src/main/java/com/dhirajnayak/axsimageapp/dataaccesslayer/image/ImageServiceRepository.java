package com.dhirajnayak.axsimageapp.dataaccesslayer.image;

import com.dhirajnayak.axsimageapp.apiinterface.ImageApiInterface;
import com.dhirajnayak.axsimageapp.businessaccesslayer.image.ImageResponseListener;
import com.dhirajnayak.axsimageapp.dataaccesslayer.ResponseMapper;
import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.dhirajnayak.axsimageapp.model.imageresponse.ImageResponse;
import com.dhirajnayak.axsimageapp.network.HTTPRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Name: ImageServiceRepository
 * Purpose: Image Web service repository
 */

public class ImageServiceRepository {

    ResponseMapper responseMapper;

    /**
     * builds the json string for image request, calls the image request service, formats the response
     * @param imageResponseListener
     */
    public void imageRequest(final ImageResponseListener imageResponseListener) {
        Call<ImageResponse> call = HTTPRequest.createService(ImageApiInterface.class).getImagesFromServer();

        //call web service
        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response.isSuccessful()) {
                    ImageResponse imageResponse = response.body();
                    if (imageResponse != null){
                        responseMapper = new ResponseMapper();
                        //map the response to image pojo
                        List<Image> images = responseMapper.mapImages(imageResponse);
                        //call the success method in business
                        imageResponseListener.onImageRequestSuccess(images);
                    }
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                //call the failure method in business
                imageResponseListener.onImageRequestFailure();
            }
        });

    }
}
