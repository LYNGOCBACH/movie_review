package com.bach.moviereview.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bach.moviereview.databinding.FragmentLoginBinding;
import com.bach.moviereview.view.base.BaseFragment;
import com.bach.moviereview.viewmodel.CommonVM;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, CommonVM> {
    @Override
    protected void initViews() {
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FragmentLoginBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentLoginBinding.inflate(inflater, container, false);
    }

    @Override
    protected void clickView(View v) {
        if (v.getId() == binding.btnLogin.getId()) {
            // Giả lập đăng nhập thành công
            callBack.showFragment(HomeFragment.class.getName(), null, false);
        }
    }
}
