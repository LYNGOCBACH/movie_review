package com.bach.moviereview;

public interface OnAPICallBack {
    void apiSuccess(String key, Object data);

    void apiError(String key, int code, Object data);


}
