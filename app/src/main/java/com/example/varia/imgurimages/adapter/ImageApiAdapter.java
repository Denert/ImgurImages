package com.example.varia.imgurimages.adapter;

import com.example.varia.imgurimages.api.ApiService;
import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.ImgurItem;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;


public class ImageApiAdapter {

    private static ImageApiAdapter instance;

    private ApiService apiService;

    private ImageApiAdapter(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static ImageApiAdapter getInstance(){
        if (instance == null){
            instance = new ImageApiAdapter();
        }

        return instance;
    }

    public Observable<ImgurItem> getCurrentImages(int page){
        return apiService.getData(page);
    }

    public Observable<Comments> getCurrentComment(String galleryHash) {
        return apiService.getCommentsData(galleryHash);
    }
}
