package com.funstuff.discoverzimbabwe.project.Recycler;

/**
 * Created by phiby on 29/10/17.
 */

public class Album {

    //this ensures that all lists contain th same type of info.
    //Thus an image and text values.

    private String name;
    private int image;


    public Album(String name, int image){
        this.name=name;
        this.image=image;

    }


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getImage() {return image;}

    public void setImage(int image) {this.image = image;}


}
