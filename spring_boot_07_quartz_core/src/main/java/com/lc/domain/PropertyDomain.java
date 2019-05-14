package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
public class PropertyDomain implements Serializable {

    private Long id;
    private String domainName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
