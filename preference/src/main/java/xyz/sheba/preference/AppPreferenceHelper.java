package xyz.sheba.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;

/**
 * Created by nuhin13 on 2/05/2018.
 */

public class AppPreferenceHelper implements PreferenceHelper {

    private static final String PREF_KEY_PREF_NAME = "PREF_KEY_PREF_NAME";
    private static final String PREF_KEY_TOP_UP_SETTINGS = "PREF_KEY_TOP_UP_SETTINGS";

    private final SharedPreferences prefs;
    private Context mContext;

    public AppPreferenceHelper(Context context) {
        this.mContext = context;
        prefs = mContext.getSharedPreferences(PREF_KEY_PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public PreferTime getTopUpSettings() {
        Gson gson = new Gson();
        String json = prefs.getString(PREF_KEY_TOP_UP_SETTINGS, "");
        return gson.fromJson(json, PreferTime.class);
    }

    @Override
    public boolean setTopUpSettings(PreferTime topUpSettings) {
        Gson gson = new Gson();
        String json = gson.toJson(topUpSettings);
        return prefs.edit().putString(PREF_KEY_TOP_UP_SETTINGS, json).commit();
    }

    @Override
    public int getCurrentUserId() {
        return prefs.getInt(PREF_KEY_PREF_NAME, 0);
    }

    @Override
    public void setCurrentUserId(int userId) {
        prefs.edit().putInt(PREF_KEY_PREF_NAME, userId).apply();
    }

}
