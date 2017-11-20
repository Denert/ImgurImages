package com.example.varia.imgurimages.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.varia.imgurimages.adapter.ImageAdapter;
import com.example.varia.imgurimages.R;
import com.example.varia.imgurimages.adapter.ItemDecoration;
import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.ImgurItem;
import com.example.varia.imgurimages.presenter.ImagePresenter;
import com.example.varia.imgurimages.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridFragment extends MvpFragment<MainView, ImagePresenter> implements MainView {

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.main_fragment) ViewGroup rootLayout;
    private View view;
    private boolean isLoading = false;
    public static int page = 1;
    private ImageAdapter rcAdapter;
    ImagePresenter presenter;


    public GridFragment() {
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
        view = inflater.inflate(R.layout.fragment_grid, container, false);

        ButterKnife.bind(this, view);

        recyclerView.setHasFixedSize(true);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        presenter = createPresenter();
        presenter.doObtainImage(page);
        recyclerView.addItemDecoration(new ItemDecoration(10));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = staggeredGridLayoutManager.getChildCount();
                int totalItemCount = staggeredGridLayoutManager.getItemCount();
                int[] firstVisibleItemPosition = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);

                if (!isLoading) {
                    if ((visibleItemCount + (firstVisibleItemPosition[0] + firstVisibleItemPosition[1])) >= totalItemCount
                            && firstVisibleItemPosition[0] >= 0) {
                        presenter.doObtainImage(++page);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        hideLoading();
        Snackbar.make(rootLayout, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onImageObtained(ImgurItem image) {
        showImages(image);
    }

    @Override
    public void onCommentsObtained(Comments comments) {}

    @Override
    public boolean getLoading() {
        return isLoading;
    }

    @Override
    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    private void showImages(ImgurItem item){

        if(page == 1) {
            rcAdapter = new ImageAdapter(getContext(), item, recyclerView);
            recyclerView.setAdapter(new ImageAdapter(getContext(), item, recyclerView));
        } else rcAdapter.updateData(item);

        hideLoading();
        setLoading(false);
    }
}
