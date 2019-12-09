package com.xin.push;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * XinGeAccountConfig 信鸽账户配置项
 *
 * @author lemon 2019/12/8 22:24
 * @version 0.0.1
 **/
@Configuration
@PropertySource(value = "classpath:application.properties")
public class XinGeAccountConfig {

    /**
     * 安卓老师端
     */
    @Value("${xinge.appId4at}")
    private String appId4at;
    @Value("${xinge.secretKey4at}")
    private String secretKey4at;
    /**
     * 安卓学生端
     */
    @Value("${xinge.appId4as}")
    private String appId4as;
    @Value("${xinge.secretKey4as}")
    private String secretKey4as;
    /**
     * 苹果老师端
     */
    @Value("${xinge.appId4it}")
    private String appId4it;
    @Value("${xinge.secretKey4it}")
    private String secretKey4it;
    /**
     * 苹果学生端
     */
    @Value("${xinge.appId4is}")
    private String appId4is;
    @Value("${xinge.secretKey4is}")
    private String secretKey4is;

    public String getAppId4at() {
        return appId4at;
    }

    public void setAppId4at(String appId4at) {
        this.appId4at = appId4at;
    }

    public String getSecretKey4at() {
        return secretKey4at;
    }

    public void setSecretKey4at(String secretKey4at) {
        this.secretKey4at = secretKey4at;
    }

    public String getAppId4as() {
        return appId4as;
    }

    public void setAppId4as(String appId4as) {
        this.appId4as = appId4as;
    }

    public String getSecretKey4as() {
        return secretKey4as;
    }

    public void setSecretKey4as(String secretKey4as) {
        this.secretKey4as = secretKey4as;
    }

    public String getAppId4it() {
        return appId4it;
    }

    public void setAppId4it(String appId4it) {
        this.appId4it = appId4it;
    }

    public String getSecretKey4it() {
        return secretKey4it;
    }

    public void setSecretKey4it(String secretKey4it) {
        this.secretKey4it = secretKey4it;
    }

    public String getAppId4is() {
        return appId4is;
    }

    public void setAppId4is(String appId4is) {
        this.appId4is = appId4is;
    }

    public String getSecretKey4is() {
        return secretKey4is;
    }

    public void setSecretKey4is(String secretKey4is) {
        this.secretKey4is = secretKey4is;
    }
}
