package com.example.varia.imgurimages.view;

import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.ImgurItem;
import com.hannesdorfmann.mosby.mvp.MvpView;


public interface MainView extends MvpView {

    void showLoading();
    void hideLoading();

    void showError(String error);

    void onImageObtained(ImgurItem image);

    void onCommentsObtained(Comments comments);

    boolean getLoading();

    void setLoading(boolean loading);

}
