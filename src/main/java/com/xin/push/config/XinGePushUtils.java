package com.xin.push.config;

import com.tencent.xinge.bean.Environment;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 信鸽推送工具类
 *
 * @author creator mafh 2019/12/9 14:45
 * @author updater
 * @version 1.0.0
 */
@Component
public class XinGePushUtils {

    /**
     * 安卓教师端
     */
    @Autowired
    private XinGe xinGe4at;
    /**
     * 安卓学生端
     */
    @Autowired
    private XinGe xinGe4as;
    /**
     * 苹果教师端
     */
    @Autowired
    private XinGe xinGe4it;
    /**
     * 苹果学生端
     */
    @Autowired
    private XinGe xinGe4is;

    /**
     * @param msgTitle   消息标题
     * @param msgContent 消息内容
     * @param account    账户
     * @param userRole   用户角色
     * @return 消息是否推送成功
     */
    public boolean singlePushAccountMsg(String msgTitle, String msgContent, String account, Integer userRole) {

        /*------------------------------- 参数声明 -------------------------------*/
        JSONObject json4i = null;
        JSONObject json4a = null;
        Assert.notNull(msgTitle, "消息标题不能为空！");
        Assert.notNull(msgContent, "msgContent不能为空！");
        Assert.notNull(account, "account不能为空！");
        Assert.notNull(userRole, "用户角色不能为空！");

        /*------------------------------- 业务处理 -------------------------------*/
        // 获取参数
        Map<String, Object> param = new HashMap<>();
        param.put("userCode", "YH123sfo234");
        param.put("userName", "巴哥");
        // 根据不同的用户角色选用不同的操作
        if (userRole.equals(10)) {
            json4i = xinGe4it.pushAccountIos(msgTitle, msgContent, account, Environment.dev.getName(), param);
            json4a = xinGe4at.pushAccountAndroid(msgTitle, msgContent, account, param);
        } else if (userRole.equals(20)) {
            json4i = xinGe4is.pushAccountIos(msgTitle, msgContent, account, Environment.dev.getName(), param);
            json4a = xinGe4as.pushAccountAndroid(msgTitle, msgContent, account, param);
        }
        System.out.println(json4i);
        System.out.println(json4a);
        return true;
    }
}
