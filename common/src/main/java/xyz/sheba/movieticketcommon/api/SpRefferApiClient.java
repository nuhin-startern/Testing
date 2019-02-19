package xyz.sheba.movieticketcommon.api;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;

public interface SpRefferApiClient {

    @GET("v2/times?for=app")
    Call<PreferTime> getCategoriesData();

}
