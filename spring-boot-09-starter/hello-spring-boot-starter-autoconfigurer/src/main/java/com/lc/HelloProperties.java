package com.lc;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * @Date:2019/5/20
 * @Author:lc
 */
@ConfigurationProperties(prefix = "lc.hello")
public class HelloProperties {

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
