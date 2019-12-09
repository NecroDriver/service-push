package com.xin.push.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * XinGeTemplate 信鸽对象
 *
 * @author lemon 2019/12/8 22:35
 * @version 0.0.1
 **/
@Component
public class XinGeTemplate {

    /**
     * 信鸽配置
     */
    @Autowired
    private XinGeAccountConfig xinGeAccountConfig;

    /**
     * @return 安卓教师端
     */
    @Bean("xinGe4at")
    public XinGe xinGe4at() {
        return new XinGe(xinGeAccountConfig.getAppId4at(), xinGeAccountConfig.getSecretKey4at());
    }

    /**
     * @return 安卓学生端
     */
    @Bean("xinGe4as")
    public XinGe xinGe4as() {
        return new XinGe(xinGeAccountConfig.getAppId4as(), xinGeAccountConfig.getSecretKey4as());
    }

    /**
     * @return 苹果教师端
     */
    @Bean("xinGe4it")
    public XinGe xinGe4it() {
        return new XinGe(xinGeAccountConfig.getAppId4it(), xinGeAccountConfig.getSecretKey4it());
    }

    /**
     * @return 苹果学生端
     */
    @Bean("xinGe4is")
    public XinGe xinGe4is() {
        return new XinGe(xinGeAccountConfig.getAppId4is(), xinGeAccountConfig.getSecretKey4is());
    }
}
