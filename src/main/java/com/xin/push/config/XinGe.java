package com.xin.push.config;

import com.tencent.xinge.XingeApp;
import com.tencent.xinge.bean.*;
import com.tencent.xinge.bean.ios.Alert;
import com.tencent.xinge.bean.ios.Aps;
import com.tencent.xinge.push.app.PushAppRequest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * 信鸽实体类
 *
 * @author creator mafh 2019/12/9 14:45
 * @author updater
 * @version 1.0.0
 */
public class XinGe {

    XingeApp xingeApp;

    public XinGe(String appid, String secretKey) {
        this.xingeApp = new XingeApp.Builder()
                .appId(appid)
                .secretKey(secretKey)
                .build();
    }

    public XinGe(String appid, String secretKey, String domainUrl) {
        this.xingeApp = new XingeApp.Builder()
                .appId(appid)
                .secretKey(secretKey)
                .domainUrl(domainUrl)
                .build();
    }

    /**
     * android Token 单推
     *
     * @param title   标题
     * @param content 内容
     * @param token   令牌
     * @return 结果
     */
    public JSONObject pushTokenAndroid(String title, String content, String token) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        pushAppRequest.setMessage(message);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add(token);
        pushAppRequest.setToken_list(tokenList);

        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android 设备列表推送
     *
     * @param title   标题
     * @param content 内容
     * @param tokens  令牌列表
     * @return 结果
     */
    public JSONObject pushTokenListAndroid(String title, String content, ArrayList<String> tokens) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token_list);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);
        pushAppRequest.setToken_list(tokens);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android 账号单推
     *
     * @param title   标题
     * @param content 内容
     * @param account 账户
     * @param params  参数
     * @return 结果
     */
    public JSONObject pushAccountAndroid(String title, String content, String account, Map<String, Object> params) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setAccount_push_type(1);
        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        // 添加自定义参数
        messageAndroid.setCustom_content(params);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);

        ArrayList<String> accountList = new ArrayList<>();
        accountList.add(account);
        pushAppRequest.setAccount_list(accountList);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android  账号列表推送
     *
     * @param title    标题
     * @param content  内容
     * @param accounts 账户列表
     * @param params   参数
     * @return 结果
     */
    public JSONObject pushAccountListAndroid(String title, String content, ArrayList<String> accounts, Map<String, Object> params) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account_list);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        // 添加自定义参数
        messageAndroid.setCustom_content(params);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);
        pushAppRequest.setAccount_list(accounts);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android  全推
     *
     * @param title   标题
     * @param content 内容
     * @return 结果
     */
    public JSONObject pushAllAndroid(String title, String content) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.all);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();


        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);
        pushAppRequest.setMessage(message);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * android  标签推送
     *
     * @param title   标题
     * @param content 内容
     * @param tag     标签
     * @return 结果
     */
    public JSONObject pushTagAndroid(String title, String content, String tag) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.tag);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);
        pushAppRequest.setMessage(message);

        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        TagListObject tagListObject = new TagListObject();
        tagListObject.setTags(tagList);
        tagListObject.setOp(OpType.OR);

        pushAppRequest.setTag_list(tagListObject);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * Ios 设备单推
     *
     * @param title       标题
     * @param content     内容
     * @param token       令牌
     * @param environment 环境
     * @return 结果
     */
    public JSONObject pushTokenIos(String title, String content, String token, String environment) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add(token);
        pushAppRequest.setToken_list(tokenList);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * IOS  设备列表推送
     *
     * @param title       标题
     * @param content     内容
     * @param tokens      令牌列表
     * @param environment 环境
     * @return 结果
     */
    public JSONObject pushTokenListIos(String title, String content, ArrayList<String> tokens, String environment) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token_list);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        pushAppRequest.setToken_list(tokens);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * ios 账号单推
     *
     * @param title       标题
     * @param content     内容
     * @param account     账户
     * @param environment 环境
     * @param params      参数
     * @return 结果
     */
    public JSONObject pushAccountIos(String title, String content, String account, String environment, Map<String, Object> params) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        // 自定义参数
        messageIOS.setCustom(params);
        pushAppRequest.setMessage(message);

        ArrayList<String> accountList = new ArrayList<>();
        accountList.add(account);
        pushAppRequest.setAccount_list(accountList);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * ios 账号列表推送
     *
     * @param title       标题
     * @param content     内容
     * @param accounts    账户列表
     * @param environment 环境
     * @param params      参数
     * @return 结果
     */
    public JSONObject pushAccountListIos(String title, String content, ArrayList<String> accounts, String environment, Map<String, Object> params) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        // 自定义参数
        messageIOS.setCustom(params);
        pushAppRequest.setMessage(message);

        pushAppRequest.setAccount_list(accounts);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * ios  全推
     *
     * @param title       标题
     * @param content     内容
     * @param environment 环境
     * @return 结果
     */
    public JSONObject pushAllIos(String title, String content, String environment) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.all);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * ios  标签推送
     *
     * @param title       标题
     * @param content     内容
     * @param tag         标签
     * @param environment 环境
     * @return 结果
     */
    public JSONObject pushTagIos(String title, String content, String tag, String environment) {
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.tag);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        TagListObject tagListObject = new TagListObject();
        tagListObject.setTags(tagList);
        tagListObject.setOp(OpType.OR);
        pushAppRequest.setMessage(message);
        pushAppRequest.setTag_list(tagListObject);
        return this.xingeApp.pushApp(pushAppRequest);
    }
}
