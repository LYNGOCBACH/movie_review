package com.bach.moviereview.view.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bach.moviereview.databinding.FragmentHomeBinding;
import com.bach.moviereview.view.base.BaseFragment;
import com.bach.moviereview.viewmodel.CommonVM;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, CommonVM> {
    @Override
    protected void initViews() {
        // Init home views
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FragmentHomeBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }
}
