package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
public class PropertyDict implements Serializable {

    private Long id;
    private PropertyDomain propertyDomain;
    private String displayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropertyDomain getPropertyDomain() {
        return propertyDomain;
    }

    public void setPropertyDomain(PropertyDomain propertyDomain) {
        this.propertyDomain = propertyDomain;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
