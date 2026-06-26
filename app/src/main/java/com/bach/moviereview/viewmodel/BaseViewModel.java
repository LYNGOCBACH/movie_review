package com.bach.moviereview.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.bach.moviereview.OnAPICallBack;
import com.bach.moviereview.api.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseViewModel extends ViewModel {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String TAG = BaseViewModel.class.getName();
    protected OnAPICallBack callBack;

    public void setCallBack(OnAPICallBack callBack) {
        this.callBack = callBack;
    }

    protected final API getAPI() {
        Retrofit rs = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build())
                .build();
        return rs.create(API.class);
    }

    protected <T> Callback<T> initHandlerResponse(String key) {
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.code() == 200 || response.code() == 201) {
                    handleSuccess(key, response.body());
                } else {
                    handleError(key, response.code(), response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                handleException(key, t);
            }
        };
    }

    protected void handleException(String key, Throwable t) {
        callBack.apiError(key, 999, t.getMessage());
    }

    protected void handleError(String key, int code, ResponseBody responseBody) {
        Log.e(TAG, "handleError: " + code);
        callBack.apiError(key, code, responseBody);
    }

    protected void handleSuccess(String key, Object body) {
        callBack.apiSuccess(key,body);
//         nothing

//        Log.i(TAG, "handleSuccess: " + body.toString());
//        createSession(body.requestToken, "bach121103", "bach121103");
    }
}
