package xyz.sheba.movieticketcommon.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.sheba.movieticketcommon.BuildConfig;

/**
 * Created by RukaRayan on 11/20/2017.
 */

public class ApiServiceGenerator {
    public static OkHttpClient client;
    public static Request request;
    public static Response response;
    public static Retrofit retrofit;

    public static  <S> S createService(final String header, Class<S> serviceClass){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("User-Agent", System.getProperty("http.agent"))
                                .addHeader("portal-name", "manager-app").build();
                        return chain.proceed(request);
                    }
                });
//                .addInterceptor(new FakeInterceptor())

        if(BuildConfig.DEBUG){
            try {
                builder.addInterceptor(interceptor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        client = builder.build();

        /*client.interceptors().add(new Interceptor() {
            @Override
            public PartnerResponse intercept(Chain chain) throws IOException {
                request = chain.request();
                request = request.newBuilder()
                        //.addHeader(AppConstants.AUTHORIZATION_HEADER, header)
                        .build();
                response = chain.proceed(request);

                int tryCount = 0;
                if(!response.isSuccessful() && tryCount <3){
                    tryCount++;
                    Log.d("intercept", "Request is not successful - " + tryCount);
                    response = chain.proceed(request);
                }

                return response;
            }
        });*/

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.dev-sheba.xyz/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(serviceClass);
    }

}
