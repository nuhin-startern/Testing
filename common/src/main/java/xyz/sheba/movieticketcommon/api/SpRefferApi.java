package xyz.sheba.movieticketcommon.api;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;
import xyz.sheba.movieticketcommon.network.ApiServiceGenerator;


public class SpRefferApi implements SpRefferApiHelper{

    private Context context;
    private SpRefferApiClient apiClient;

    public SpRefferApi(Context context) {
        this.context = context;
        this.apiClient = new ApiServiceGenerator().createService("", SpRefferApiClient.class);
    }

    @Override
    public void getAllCategoriesData(final SpRefferCallback.categoriesCallBack categoriesCallBack) {
        Call<PreferTime> call = apiClient.getCategoriesData();

        call.enqueue(new Callback<PreferTime>() {
            @Override
            public void onResponse(Call<PreferTime> call, Response<PreferTime> response) {
                if (response.isSuccessful()){
                    if (response.body().getmCode() == 200){
                        categoriesCallBack.onSuccess(response.body());
                    } else {
                        categoriesCallBack.onError(response.body().getmMessage(), response.body().getmCode());
                    }
                } else {
                    categoriesCallBack.onFailed("Something went wrong!");
                }
            }

            @Override
            public void onFailure(Call<PreferTime> call, Throwable t) {
                categoriesCallBack.onFailed(t.toString());
            }
        });
    }


}
