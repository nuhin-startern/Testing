
package xyz.sheba.movieticketcommon.model.prefertime;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PreferTime {

    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("times")
    private ArrayList<Time> mTimes;

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public ArrayList<Time> getmTimes() {
        return mTimes;
    }

    public void setmTimes(ArrayList<Time> mTimes) {
        this.mTimes = mTimes;
    }

    @Override
    public String toString() {
        return "PreferTime{" +
                "mCode=" + mCode +
                ", mMessage='" + mMessage + '\'' +
                ", mTimes=" + mTimes +
                '}';
    }
}
