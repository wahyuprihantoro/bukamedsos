package id.prihantoro.bukamedsos.api;

import android.content.Context;
import android.util.Log;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import id.prihantoro.bukamedsos.api.result.BasicResult;
import id.prihantoro.bukamedsos.storage.Prefs;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahyu on 13 Maret 2017.
 */

@EBean
public class Retrofit {
    public static final String BASE_URL = "https://api.bukalapak.com/v2/";

    private static retrofit2.Retrofit retrofit;
    @RootContext
    Context context;
    @Bean
    Prefs prefs;

    public <T> T getGeneralService(Class<T> service) {
        return getRetrofit().create(service);
    }

    public <T> T getServiceBasicAuth(Class<T> service, String username, String password) {
        return getRetrofit(username, password).create(service);
    }

    private retrofit2.Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request;
                request = original.newBuilder()
                        .header("authorization", prefs.getToken())
                        .method(original.method(), original.body())
                        .build();


                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    private retrofit2.Retrofit getRetrofit(String username, String password) {
        final String basic = Credentials.basic(username, password);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request;
                request = original.newBuilder()
                        .header("Authorization", basic)
                        .method(original.method(), original.body())
                        .build();


                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public Callback getCallback(final BasicResult result) {
        return new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                if (response.isSuccessful()) {
                    result.status = true;
                    Log.d("wahyu success", response.raw().toString());
                } else {
                    result.status = false;
                }
                result.resultCode = response.code();
                result.response = response.body();
                result.message = response.message();
                EventBus.getDefault().post(result);
                Log.d("wahyu api", response.raw().toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if (t.getMessage() != null && t.getMessage() != null) {
                    result.message = t.getMessage();
                }
                Log.d("wahyu fail", result.message);
                EventBus.getDefault().post(result);
            }
        };
    }
}
