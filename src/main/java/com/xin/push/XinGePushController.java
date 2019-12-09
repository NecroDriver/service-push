package com.xin.push;

import com.xin.push.config.XinGePushUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author creator mafh 2019/12/9 16:10
 * @author updater
 * @version 1.0.0
 */
@RestController
@RequestMapping("/XinGe/push")
public class XinGePushController {

    @Autowired
    private XinGePushUtils xinGePushUtils;

    @RequestMapping("/singlePushAccountMsg")
    public void singlePushAccountMsg(String msgTitle, String msgContent, String account, Integer userRole) {
        xinGePushUtils.singlePushAccountMsg(msgTitle, msgContent, account, userRole);
    }
}
