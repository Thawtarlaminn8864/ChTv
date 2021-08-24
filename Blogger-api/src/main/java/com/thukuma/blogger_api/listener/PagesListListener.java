package com.thukuma.blogger_api.listener;

import com.thukuma.blogger_api.model.PagesList;

public interface PagesListListener {
    void onPagesListListener(PagesList pagesList);
    void onFailureListener(Throwable t);
}
