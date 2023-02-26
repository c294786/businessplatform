package com.czk.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-02-25
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "productid", type = IdType.AUTO)
    private Integer productid;
    private String name;

    private String picturehttp;

    private String category;

    private Double price;

    private String introduction;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPicturehttp() {
        return picturehttp;
    }

    public void setPicturehttp(String picturehttp) {
        this.picturehttp = picturehttp;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Product{" +
            "productid=" + productid +
            ", name=" + name +
            ", picturehttp=" + picturehttp +
            ", category=" + category +
            ", price=" + price +
            ", introduction=" + introduction +
        "}";
    }
}
