package com.dhirajnayak.axsimageapp.dataaccesslayer;

import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.dhirajnayak.axsimageapp.model.imageresponse.ImageResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseMapper {
    public List<Image> mapImages(ImageResponse imageResponse){
        List<Image> images = new ArrayList<>();
        images.addAll(imageResponse.getmImageEntity().getmImages());
        return images;
    }
}
