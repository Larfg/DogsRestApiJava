package org.adaschool.retrofit;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class JWTInterceptor implements Interceptor {
    private final SharedPreferencesStorage tokenStorage;

    public JWTInterceptor(SharedPreferencesStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
    }

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        String token = tokenStorage.getToken();
        if (token != null) {
            requestBuilder.addHeader("Authorization", "Bearer " + token);
        }
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
