package com.thukuma.blogger_api.main;

import static com.thukuma.blogger_api.main.BloggerData.getBlogData;
import static com.thukuma.blogger_api.main.BloggerData.getPagesListData;
import static com.thukuma.blogger_api.main.BloggerData.getPostListData;
import static com.thukuma.blogger_api.main.BloggerData.getSpecificPostData;
import static com.thukuma.blogger_api.main.BloggerUrl.BASE_URL;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_BLOG;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_BY_PATH;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_BY_URL;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_DAN_KEY;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_KEY;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_PAGES;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_POST;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_PUT_URL;
import static com.thukuma.blogger_api.main.BloggerUrl.TAG_SEARCH_QUERY;

import com.thukuma.blogger_api.listener.BlogInfoListener;
import com.thukuma.blogger_api.listener.PagesListListener;
import com.thukuma.blogger_api.listener.PostListListener;
import com.thukuma.blogger_api.listener.SpecificPostListener;

public class BloggerApi {
    private String blogId;
    private String apikey;

    public BloggerApi(String blogId, String apikey) {
        this.blogId = blogId;
        this.apikey = apikey;
    }

    public void getBlogInfo(String urlBlog, BlogInfoListener listener){
        String url = BASE_URL + TAG_BY_URL + TAG_PUT_URL + urlBlog + TAG_DAN_KEY + apikey;
        getBlogData(url, listener);
    }

    public void getBlogInfo(BlogInfoListener listener){
        String url = BASE_URL  + TAG_BLOG + blogId + TAG_KEY + apikey;
        getBlogData(url, listener);
    }

    public void getPostList(PostListListener listener){
        String url = BASE_URL + TAG_BLOG + blogId + TAG_POST + TAG_KEY + apikey;
        getPostListData(url, listener);
    }

    public void getPagesList(PagesListListener listListener){
        String url = BASE_URL + TAG_BLOG + blogId + TAG_PAGES + TAG_KEY + apikey;

        getPagesListData(url, listListener);
    }

    public void getPostListFromQuery (String query, PostListListener listener){
        String url = BASE_URL + TAG_BLOG + blogId + TAG_POST + TAG_SEARCH_QUERY + query + TAG_DAN_KEY + apikey;
        getPostListData(url, listener);
    }

    public void getSpecificPost(String postId, SpecificPostListener listener){
        String url = BASE_URL + TAG_BLOG + blogId + TAG_POST + postId + TAG_KEY + apikey;
        getSpecificPostData(url, listener);
    }

    public void getSpecificPostFromSelfLink(String selfLink, SpecificPostListener listener){
        String url = selfLink + TAG_KEY + apikey;
        getSpecificPostData(url, listener);
    }

    /**
     * example url path = /2019/12/this-is-the-url-path.html
     */
    public void getSpecificPostFromPath(String urlPath, SpecificPostListener listener){
        String url = BASE_URL + TAG_BLOG + blogId + TAG_POST + TAG_BY_PATH + urlPath + TAG_DAN_KEY + apikey;
        getSpecificPostData(url, listener);
    }

}
