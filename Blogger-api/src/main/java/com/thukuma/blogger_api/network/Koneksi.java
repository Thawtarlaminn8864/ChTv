package com.thukuma.blogger_api.network;

import com.thukuma.blogger_api.main.BloggerUrl;
import com.thukuma.blogger_api.model.BlogInfo;
import com.thukuma.blogger_api.model.BloggerItems;
import com.thukuma.blogger_api.model.PagesList;
import com.thukuma.blogger_api.model.PostList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class Koneksi {
    public interface api {
        @GET
        Call<PostList> getPostList(@Url String url);
        @GET
        Call<BlogInfo> getBlogInfo(@Url String url);
        @GET
        Call<BloggerItems> getItems(@Url String url);
        @GET
        Call<PagesList> getPagesList(@Url String url);
    }
    private static api api = null;
    public static api getBloggerApi() {
        if (api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BloggerUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(api.class);
        }
        return api;
    }
}
