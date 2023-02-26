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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phone;

    private String name;

    private String gender;

    private String password;

    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getname() {
        return name;
    }

    public void setname(String username) {
        this.name = username;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" +
            "phone=" + phone +
            ", username=" + name +
            ", gender=" + gender +
            ", password=" + password +
            ", userid=" + userid +
        "}";
    }
}
