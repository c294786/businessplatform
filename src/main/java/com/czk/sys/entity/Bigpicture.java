package com.czk.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
public class Bigpicture implements Serializable {

    private static final long serialVersionUID = 1L;

    private String picturehttp;

    public String getPicturehttp() {
        return picturehttp;
    }

    public void setPicturehttp(String picturehttp) {
        this.picturehttp = picturehttp;
    }

    @Override
    public String toString() {
        return "Bigpicture{" +
            "picturehttp=" + picturehttp +
        "}";
    }
}
