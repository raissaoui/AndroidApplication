
package fr.esilv.s8.androidapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Default implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    private final static long serialVersionUID = 6074434858878392899L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
