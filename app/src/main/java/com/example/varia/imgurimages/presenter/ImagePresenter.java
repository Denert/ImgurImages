package com.example.varia.imgurimages.presenter;

import android.view.View;

import com.example.varia.imgurimages.adapter.ImageApiAdapter;
import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.ImgurItem;
import com.example.varia.imgurimages.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;


public class ImagePresenter extends MvpBasePresenter<MainView> {

    MainView view;

    public ImagePresenter(MainView view) {
        this.view = view;
    }

    public void doObtainImage(int page){
        if (view == null){
            return;
        }

        if(page == 1)
            view.showLoading();
        view.setLoading(true);

        ImageApiAdapter.getInstance().getCurrentImages(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImgurItem>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ImgurItem imgurItem) {
                        view.onImageObtained(imgurItem);
                    }
                });
    }

    public void getDescriptionImage(String galleryHash){
        if (view == null){
            return;
        }

        view.showLoading();
        view.setLoading(true);

        ImageApiAdapter.getInstance().getCurrentComment(galleryHash)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Comments>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Comments comments) {
                        view.onCommentsObtained(comments);
                    }
                });
    }

}
