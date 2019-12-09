package com.xin.push;

import com.tencent.xinge.XingeApp;
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

    @Bean("xinge4at")
    public XingeApp xinge4at(){
        return new XingeApp(xinGeAccountConfig.getAppId4at(), xinGeAccountConfig.getSecretKey4at());
    }

}
