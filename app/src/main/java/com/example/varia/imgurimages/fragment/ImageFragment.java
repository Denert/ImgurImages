package com.example.varia.imgurimages.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.varia.imgurimages.R;
import com.example.varia.imgurimages.adapter.CommentsAdapter;
import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.CommentsDatum;
import com.example.varia.imgurimages.model.Datum;
import com.example.varia.imgurimages.model.ImgurItem;
import com.example.varia.imgurimages.presenter.ImagePresenter;
import com.example.varia.imgurimages.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageFragment extends MvpFragment<MainView, ImagePresenter> implements MainView {

    private View view;
    @BindView(R.id.main_image_container) NestedScrollView scrollView;
    @BindView(R.id.image_container) LinearLayout imageContainer;
    @BindView(R.id.comments_container) RecyclerView recyclerView;
    @BindView(R.id.image_progress) ProgressBar progressBar;
    @BindView(R.id.textView) TextView title;
    private boolean isLoading = false;
    ImagePresenter presenter;


    public ImageFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public ImagePresenter createPresenter() {
        return new ImagePresenter(getMvpView());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        Datum images = (Datum) bundle.getSerializable("imageData");

        presenter = createPresenter();
        presenter.getDescriptionImage(images.getId());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (images.getTitle() != null)
            title.setText(images.getTitle());

        if (images.getImages() != null) {
            ImageView image = new ImageView(getContext());
            Picasso.with(getContext())
                    .load(images.getImages().get(0).getLink())
                    .placeholder(R.drawable.image_not_available)
                    .error(R.drawable.image_not_available)
                    .into(image);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(15, 15, 15, 15);
            image.setLayoutParams(params);
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageContainer.addView(image);
        }
        return view;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        scrollView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onImageObtained(ImgurItem image) {
    }

    @Override
    public void onCommentsObtained(Comments comments) {
        showComments(comments);
    }

    @Override
    public boolean getLoading() {
        return isLoading;
    }

    @Override
    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    private void showComments(Comments item) {
        List<CommentsDatum> topComments = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            topComments.add(item.getData().get(i));
        CommentsAdapter adapter = new CommentsAdapter(topComments);
        recyclerView.setAdapter(adapter);

        hideLoading();
        setLoading(false);
    }
}
