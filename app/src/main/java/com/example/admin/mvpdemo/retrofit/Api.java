package com.example.admin.mvpdemo.retrofit;

import com.example.admin.mvpdemo.bean.CategoryBean;
import com.example.admin.mvpdemo.bean.CollectBean;
import com.example.admin.mvpdemo.bean.LoginBean;
import com.example.admin.mvpdemo.config.HttpArray;
import com.example.admin.mvpdemo.config.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/3/27.
 *
 */

public interface Api {

    @FormUrlEncoded
    @POST("api/User/login")
    Observable<HttpResult<LoginBean>> login(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/Collect/collectList")
    Observable<HttpArray<CollectBean>> collect(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST("api/VideoCategory/category")
    Observable<HttpArray<CategoryBean>> category(@FieldMap Map<String, String> map);
}
