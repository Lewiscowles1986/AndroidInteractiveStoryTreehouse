package uk.co.lewiscowles.interactivestory.models;

/**
 * Created by lewis on 31/08/16.
 */
public class Choice {
    private int mTextResource;

    private int mPageId;

    public Choice(int textResource, int page_id) {
        mTextResource = textResource;
        mPageId = page_id;
    }

    public int getPageId() {
        return mPageId;
    }

    public void setPageId(int pageId) {
        mPageId = pageId;
    }

    public int getTextResource() {
        return mTextResource;
    }

    public void setTextResource(int textResource) {
        mTextResource = textResource;
    }
}
