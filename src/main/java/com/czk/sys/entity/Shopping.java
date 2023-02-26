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
public class Shopping implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "oi" , type = IdType.AUTO)
    private Integer oi;
    private String http;
    private String pn;

    private Integer ui;

    private Double pp;

    private String py;

    public Integer getOi() {
        return oi;
    }

    public void setOi(Integer oi) {
        this.oi = oi;
    }
    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }
    public Integer getUi() {
        return ui;
    }

    public void setUi(Integer ui) {
        this.ui = ui;
    }
    public Double getPp() {
        return pp;
    }

    public void setPp(Double pp) {
        this.pp = pp;
    }
    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "Shopping{" +
            "oi=" + oi +
            ", pn=" + pn +
            ", ui=" + ui +
            ", pp=" + pp +
            ", py=" + py +
        "}";
    }


    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }
}
