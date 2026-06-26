package com.bach.moviereview.api.req;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestTokenReq implements Serializable {
    @SerializedName("request_token")

    public String requestToken;

    public RequestTokenReq(String requestToken) {
        this.requestToken = requestToken;
    }
}
