package com.example.varia.imgurimages.api;


import com.example.varia.imgurimages.model.Comments;
import com.example.varia.imgurimages.model.ImgurItem;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import rx.Observable;


public interface ApiService {

    String BASE_URL = "https://api.imgur.com/";

    @Headers("authorization: Client-ID 107d35a9b9b95b8")
    @GET("3/gallery/top/top/{page}")
    Observable<ImgurItem> getData(
            @Path("page") int page);

    @Headers("authorization: Client-ID 107d35a9b9b95b8")
    @GET("3/gallery/{galleryHash}/comments/top")
    Observable<Comments> getCommentsData(
            @Path("galleryHash") String page);
}
