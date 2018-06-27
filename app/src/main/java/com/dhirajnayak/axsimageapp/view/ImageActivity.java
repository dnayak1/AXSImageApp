package com.dhirajnayak.axsimageapp.view;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dhirajnayak.axsimageapp.R;
import com.dhirajnayak.axsimageapp.businessaccesslayer.image.ImageBusiness;
import com.dhirajnayak.axsimageapp.model.imageresponse.Image;
import com.dhirajnayak.axsimageapp.presenter.ImagePresenter;

import java.util.List;

/**
 * Name: ImageActivity
 * Purpose: Home screen where user interacts with the application
 */
public class ImageActivity extends AppCompatActivity implements ImageView {

    private RecyclerView mImageRecyclerView;
    private ProgressBar mImageProgressBar;

    private ImagePresenter mImagePresenter;

    private ImageAdapter mImageAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private DividerItemDecoration mDividerItemDecoration;
    private Snackbar mSnackbar;
    private View mParentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting UI components
        setupUI();

        mImagePresenter =new ImagePresenter(this,new ImageBusiness());
        mImagePresenter.getImagesFromService();
    }

    private void setupUI() {
        mImageRecyclerView = findViewById(R.id.imageRecyclerView);
        mImageProgressBar = findViewById(R.id.imageProgressBar);
    }

    @Override
    public void displayProgressDialog() {
        mImageProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void cancelProgressDialog() {
        mImageProgressBar.setVisibility(View.INVISIBLE);
    }

    /**
     * setting the adapter and layout to recycler view
     * @param images
     */
    @Override
    public void populateImages(List<Image> images) {
        mImageAdapter = new ImageAdapter(images,this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mImageRecyclerView.setAdapter(mImageAdapter);
        mImageRecyclerView.setLayoutManager(mLinearLayoutManager);
        //adding divider between items
        mDividerItemDecoration = new DividerItemDecoration(mImageRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mImageRecyclerView.addItemDecoration(mDividerItemDecoration);
        mImageAdapter.notifyDataSetChanged();

    }

    /**
     * setting error message for user in case service failure
     */
    @Override
    public void errorFromService() {
        mImageProgressBar.setVisibility(View.INVISIBLE);
        mSnackbar= Snackbar.make(mParentView,R.string.service_error,Snackbar.LENGTH_LONG);
        mSnackbar.setActionTextColor(Color.RED);
        mSnackbar.show();

    }
}
