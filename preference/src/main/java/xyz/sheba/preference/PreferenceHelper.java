package xyz.sheba.preference;


import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;

/**
 * Created by nuhin13 on 7/18/2018.
 */

public interface PreferenceHelper {

    PreferTime getTopUpSettings();
    boolean setTopUpSettings(PreferTime preferTime);

    int getCurrentUserId();
    void setCurrentUserId(int userId);

}
