package com.hehui.model;

import javax.persistence.*;

/**
 * Created by he_hui on 2019/8/2.
 */
@Entity
@Table(name = "category")
public class CateGory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoryid")
    private Integer categoryid;
    private String categoryname;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
