package com.bach.moviereview.api.res;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthenRes implements Serializable {
    @SerializedName("success")
    public boolean success;
    @SerializedName("expires_at")

    public String expiresAt;
    @SerializedName("request_token")

    public String requestToken;

    @NonNull
    @Override
    public String toString() {
        return "AuthenRes{" +
                "expiresAt='" + expiresAt + '\'' +
                ", success=" + success +
                ", requestToken='" + requestToken + '\'' +
                '}';
    }
}
