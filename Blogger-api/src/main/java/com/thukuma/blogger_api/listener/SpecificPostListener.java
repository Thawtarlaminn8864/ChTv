package com.thukuma.blogger_api.listener;

import com.thukuma.blogger_api.model.BloggerItems;

public interface SpecificPostListener {
    void onSpecificPostSuccessListener(BloggerItems items);
    void onFailureListener(Throwable t);
}
