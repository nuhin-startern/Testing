
package xyz.sheba.movieticketcommon.model.prefertime;

import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("isValid")
    private int mIsValid;

    @SerializedName("key")
    private String mKey;

    @SerializedName("value")
    private String mValue;

    public int getmIsValid() {
        return mIsValid;
    }

    public void setmIsValid(int mIsValid) {
        this.mIsValid = mIsValid;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    @Override
    public String toString() {
        return "Time{" +
                "mIsValid=" + mIsValid +
                ", mKey='" + mKey + '\'' +
                ", mValue='" + mValue + '\'' +
                '}';
    }
}
