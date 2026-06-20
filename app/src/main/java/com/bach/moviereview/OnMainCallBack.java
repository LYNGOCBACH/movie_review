package com.bach.moviereview;

public interface OnMainCallBack {
    void showFragment(String tag, Object data, Boolean isBack);

    void backToPrevious();
}
