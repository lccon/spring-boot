package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/5/13
 * @Author:lc
 */
public class Department implements Serializable {
    private Long id;
    private String departName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                '}';
    }
}
