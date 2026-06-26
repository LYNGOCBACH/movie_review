package com.bach.moviereview.view.base;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.bach.moviereview.OnAPICallBack;
import com.bach.moviereview.OnMainCallBack;
import com.bach.moviereview.view.fragment.LoginFragment;
import com.bach.moviereview.viewmodel.BaseViewModel;

import okhttp3.ResponseBody;

public abstract class BaseFragment<B extends ViewBinding, M extends BaseViewModel> extends Fragment implements View.OnClickListener, OnAPICallBack {
    protected Context context;
    protected B binding;
    protected M viewModel;
    protected OnMainCallBack callBack;
    protected Object mData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewModel = new ViewModelProvider(this).get(initViewModel());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        clickView(v);
    }

    protected void clickView(View v) {
    }

    protected abstract void initViews();


    protected abstract Class<M> initViewModel();

    protected abstract B initViewBinding(LayoutInflater inflater, ViewGroup container);

    public void setData(Object data) {
        mData = data;
    }

    public void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void apiSuccess(String key, Object data) {
//        do nothing
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if (code == 401) {
            callBack.showFragment(LoginFragment.TAG, null, false);
            Toast.makeText(context, "Phiên đăng nhập đã hết hạn", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Error: " + code + ", " + data, Toast.LENGTH_SHORT).show();
        }
    }

}

