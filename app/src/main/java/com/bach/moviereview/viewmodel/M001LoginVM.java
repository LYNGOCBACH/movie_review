package com.bach.moviereview.viewmodel;

import android.util.Log;
import android.widget.Toast;

import com.bach.moviereview.api.req.AccountReq;
import com.bach.moviereview.api.req.RequestTokenReq;
import com.bach.moviereview.api.res.AuthenRes;
import com.bach.moviereview.view.fragment.LoginFragment;
import com.bach.moviereview.view.fragment.WelcomeFragment;

import okhttp3.ResponseBody;

public class M001LoginVM extends BaseViewModel {

    private static final String TAG = M001LoginVM.class.getName();
    private static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    private static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    public static final String KEY_API_CREATE_SESSION_ID = "KEY_API_CREATE_SESSION_ID";
    private String userName, password;

    public void getAuthen(String userName, String password) {
        this.userName = userName;
        this.password = password;

        getAPI().getAuthen().enqueue(initHandlerResponse(KEY_API_AUTHEN));
    }

    public void createSession(String requestToken) {
        getAPI().createSession(new AccountReq(userName, requestToken, password)).enqueue(initHandlerResponse(KEY_API_CREATE_SESSION));
    }

    private void createSessionId(String requestToken) {
        getAPI().createSessionID(new RequestTokenReq(requestToken)).enqueue(initHandlerResponse(KEY_API_CREATE_SESSION_ID));

    }

    @Override
    protected void handleSuccess(String key, Object body) {
        Log.i(TAG, "handleSuccess: " + key);
        Log.i(TAG, "handleSuccess: " + body);
        if (key.equals(KEY_API_AUTHEN)) {
            createSession(((AuthenRes) body).requestToken);
        } else if (key.equals(KEY_API_CREATE_SESSION)) {
            createSessionId(((AuthenRes) body).requestToken);
        } else if (key.equals(KEY_API_CREATE_SESSION_ID)) {// go to UI
            callBack.apiSuccess(key, body);
        }
    }


}
