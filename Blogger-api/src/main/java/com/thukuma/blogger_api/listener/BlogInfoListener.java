package com.thukuma.blogger_api.listener;


import com.thukuma.blogger_api.model.BlogInfo;

public interface BlogInfoListener {
    void onBlogInfoSuccessListener(BlogInfo blogInfo);
    void onFailureListener(Throwable t);
}
