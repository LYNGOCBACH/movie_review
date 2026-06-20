package com.bach.moviereview.view.activity;

import android.view.View;

import com.bach.moviereview.databinding.ActivityMainBinding;
import com.bach.moviereview.view.base.BaseAct;
import com.bach.moviereview.view.fragment.WelcomeFragment;
import com.bach.moviereview.viewmodel.CommonVM;

public class MainActivity extends BaseAct<ActivityMainBinding, CommonVM> {

    @Override
    protected void initViews() {
        showFragment(WelcomeFragment.class.getName(), null, false);
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void clickView(View v) {
        // Handle global clicks if needed
    }
}
