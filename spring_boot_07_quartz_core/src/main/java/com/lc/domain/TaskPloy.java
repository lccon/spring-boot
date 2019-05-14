package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
public class TaskPloy implements Serializable {

     private Long id;
     private String cname;
     private String ename;
     private PropertyDict propertyDict;
     private String description;
     private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public PropertyDict getPropertyDict() {
        return propertyDict;
    }

    public void setPropertyDict(PropertyDict propertyDict) {
        this.propertyDict = propertyDict;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
