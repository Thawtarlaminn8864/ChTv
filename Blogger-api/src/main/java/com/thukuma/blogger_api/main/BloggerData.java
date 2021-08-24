package com.thukuma.blogger_api.main;


import com.thukuma.blogger_api.listener.BlogInfoListener;
import com.thukuma.blogger_api.listener.PagesListListener;
import com.thukuma.blogger_api.listener.PostListListener;
import com.thukuma.blogger_api.listener.SpecificPostListener;
import com.thukuma.blogger_api.model.BlogInfo;
import com.thukuma.blogger_api.model.BloggerItems;
import com.thukuma.blogger_api.model.PagesList;
import com.thukuma.blogger_api.model.PostList;
import com.thukuma.blogger_api.network.Koneksi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class BloggerData {

    static void getPagesListData(String url, final PagesListListener listListener){
        Call<PagesList> getPages = Koneksi.getBloggerApi().getPagesList(url);
        getPages.enqueue(new Callback<PagesList>() {
            @Override
            public void onResponse(Call<PagesList> call, Response<PagesList> response) {
                listListener.onPagesListListener(response.body());
            }

            @Override
            public void onFailure(Call<PagesList> call, Throwable t) {
                listListener.onFailureListener(t);
            }
        });
    }

    static void getBlogData(String url, final BlogInfoListener listener) {
        Call<BlogInfo> getBlog = Koneksi.getBloggerApi().getBlogInfo(url);
        getBlog.enqueue(new Callback<BlogInfo>() {
            @Override
            public void onResponse(Call<BlogInfo> call, Response<BlogInfo> response) {
                listener.onBlogInfoSuccessListener(response.body());
            }

            @Override
            public void onFailure(Call<BlogInfo> call, Throwable t) {
                listener.onFailureListener(t);
            }
        });
    }

    static void getPostListData(String url, final PostListListener listener){
        Call<PostList> getPost = Koneksi.getBloggerApi().getPostList(url);
        getPost.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                listener.onPostListSuccessListener(response.body());
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                listener.onFailureListener(t);
            }
        });
    }

    static void getSpecificPostData(String url, final SpecificPostListener listener){
        Call<BloggerItems> getItems = Koneksi.getBloggerApi().getItems(url);
        getItems.enqueue(new Callback<BloggerItems>() {
            @Override
            public void onResponse(Call<BloggerItems> call, Response<BloggerItems> response) {
                listener.onSpecificPostSuccessListener(response.body());
            }

            @Override
            public void onFailure(Call<BloggerItems> call, Throwable t) {
                listener.onFailureListener(t);
            }
        });
    }

}
