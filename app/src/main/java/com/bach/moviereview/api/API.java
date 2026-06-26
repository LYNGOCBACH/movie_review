package com.bach.moviereview.api;

import com.bach.moviereview.api.req.AccountReq;
import com.bach.moviereview.api.req.RequestTokenReq;
import com.bach.moviereview.api.res.AuthenRes;
import com.bach.moviereview.api.res.SessionRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    public String API_KEY = "3d5369cd1b61aea16acb3af47f745216";

    @GET("authentication/token/new?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> getAuthen();

    @POST("authentication/token/validate_with_login?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<AuthenRes> createSession(@Body AccountReq acc );

    @POST("authentication/session/new?api_key=" + API_KEY)
    @Headers("Content-Type: application/json")
    Call<SessionRes> createSessionID(@Body RequestTokenReq tokenReq );
}
