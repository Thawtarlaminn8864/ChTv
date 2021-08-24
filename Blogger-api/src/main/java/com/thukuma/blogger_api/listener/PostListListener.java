package com.thukuma.blogger_api.listener;

import com.thukuma.blogger_api.model.PostList;

public interface PostListListener {
    void onPostListSuccessListener(PostList postList);
    void onFailureListener(Throwable t);
}
