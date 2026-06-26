package com.bach.moviereview.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bach.moviereview.CommonUtils;
import com.bach.moviereview.api.res.SessionRes;
import com.bach.moviereview.databinding.FragmentLoginBinding;
import com.bach.moviereview.view.base.BaseFragment;
import com.bach.moviereview.viewmodel.M001LoginVM;

import okhttp3.ResponseBody;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, M001LoginVM> {
    public static final String TAG = LoginFragment.class.getName();
    private static final String KEY_SESSION_ID = "KEY_SESSION_ID";

    @Override
    protected void initViews() {
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    protected Class<M001LoginVM> initViewModel() {
        return M001LoginVM.class;
    }

    @Override
    protected FragmentLoginBinding initViewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentLoginBinding.inflate(inflater, container, false);
    }


    @Override
    protected void clickView(View v) {
//        if (v.getId() == binding.btnLogin.getId()) {
//            // Giả lập đăng nhập thành công
//            callBack.showFragment(HomeFragment.class.getName(), null, false);
//        }

        if (v.getId() == binding.btnLogin.getId()) {
            viewModel.getAuthen(
                    binding.edtEmail.getText().toString(),
                    binding.edtPassword.getText().toString()
            );
        }
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if (code == 401) {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không phù hợp!!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error: " + code + ", " + data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void apiSuccess(String key, Object data) {
        if (key.equals(M001LoginVM.KEY_API_CREATE_SESSION_ID)) {
            SessionRes res = (SessionRes) data;
            CommonUtils.getINSTANCE().savePref(KEY_SESSION_ID, res.sessionId);
            Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
    }


}
