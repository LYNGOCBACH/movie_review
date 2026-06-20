package com.bach.moviereview.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bach.moviereview.databinding.FragmentRegisterBinding;
import com.bach.moviereview.view.base.BaseFragment;
import com.bach.moviereview.viewmodel.CommonVM;

public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, CommonVM> {
    @Override
    protected void initViews() {
        binding.ivBack.setOnClickListener(this);
        binding.btnCreateAccount.setOnClickListener(this);
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FragmentRegisterBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentRegisterBinding.inflate(inflater, container, false);
    }

    @Override
    protected void clickView(View v) {
        if (v.getId() == binding.ivBack.getId()) {
            getParentFragmentManager().popBackStack();
        } else if (v.getId() == binding.btnCreateAccount.getId()) {
            // Giả lập đăng ký thành công và quay lại đăng nhập hoặc vào Home
            callBack.showFragment(LoginFragment.class.getName(), null, false);
        }
    }
}
