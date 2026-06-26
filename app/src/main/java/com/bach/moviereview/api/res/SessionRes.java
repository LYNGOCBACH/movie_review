package com.bach.moviereview.api.res;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SessionRes implements Serializable {
    @SerializedName("success")
    public boolean success;
    @SerializedName("session_id")

    public String sessionId;

    @NonNull
    @Override
    public String toString() {
        return "SessionRes{" +
                "sessionId='" + sessionId + '\'' +
                ", success=" + success +
                '}';
    }
}
