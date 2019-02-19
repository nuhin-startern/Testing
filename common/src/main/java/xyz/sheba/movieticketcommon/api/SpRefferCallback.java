package xyz.sheba.movieticketcommon.api;

import java.util.ArrayList;

import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;
import xyz.sheba.movieticketcommon.model.prefertime.Time;

public interface SpRefferCallback {
    public interface categoriesCallBack{
        void onSuccess(PreferTime allCategories);
        void onError(String msg, int code);
        void onFailed(String msg);
    }
}
