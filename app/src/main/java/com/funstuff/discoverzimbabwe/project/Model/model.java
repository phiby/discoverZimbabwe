package com.funstuff.discoverzimbabwe.project.Model;

/**
 * Created by phiby on 29/10/17
 */

public class model {

    //this is were we set the content for our view through using a model layou,
    //this ensures that all layouts and list are equal in size and also mantain;
    // the same shape
    private String mName;
    private String mDescription;
    private int mImageResourceId;

    public model(String name, String description, int imageResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

}