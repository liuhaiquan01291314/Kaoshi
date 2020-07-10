package com.example.kaoshi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apiservice {
//    http://yun918.cn/ks/jiekou1.json
    String url="http://yun918.cn/";
    @GET("ks/jiekou1.json")
    Observable<Bean> data();
}
