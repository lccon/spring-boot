package com.lc;

/**
 * Description:
 *
 * @Date:2019/5/20
 * @Author:lc
 */
public class HelloService {

    //注入文件
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }

}
