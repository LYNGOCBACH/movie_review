package com.bach.moviereview.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bach.moviereview.databinding.FragmentWelcomeBinding;
import com.bach.moviereview.view.base.BaseFragment;
import com.bach.moviereview.viewmodel.CommonVM;

public class WelcomeFragment extends BaseFragment<FragmentWelcomeBinding, CommonVM> {
    @Override
    protected void initViews() {
        binding.btnLoginWelcome.setOnClickListener(this);
        binding.btnRegisterWelcome.setOnClickListener(this);
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FragmentWelcomeBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentWelcomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected void clickView(View v) {
        if (v.getId() == binding.btnLoginWelcome.getId()) {
            callBack.showFragment(LoginFragment.class.getName(), null, true);
        } else if (v.getId() == binding.btnRegisterWelcome.getId()) {
            callBack.showFragment(RegisterFragment.class.getName(), null, true);
        }
    }
}
