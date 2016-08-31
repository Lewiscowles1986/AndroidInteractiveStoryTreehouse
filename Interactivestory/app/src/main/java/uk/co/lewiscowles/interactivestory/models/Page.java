package uk.co.lewiscowles.interactivestory.models;

/**
 * Created by lewis on 31/08/16.
 */
public class Page {
    private int mDrawImage;
    private int mTextResource;
    private Choice[] mChoices;

    public Page(int drawImage, int textResource, Choice[] choices) {
        mDrawImage = drawImage;
        mTextResource = textResource;
        mChoices = choices;
    }

    public Page(int drawImage, int textResource) {
        mDrawImage = drawImage;
        mTextResource = textResource;
        mChoices = new Choice[]{};
    }

    public int getDrawImage() {
        return mDrawImage;
    }

    public void setDrawImage(int drawImage) {
        mDrawImage = drawImage;
    }

    public int getTextResource() {
        return mTextResource;
    }

    public void setTextResource(int textResource) {
        mTextResource = textResource;
    }

    public Choice[] getChoices() {
        return mChoices;
    }

    public void setChoices(Choice[] choices) {
        mChoices = choices;
    }
}
