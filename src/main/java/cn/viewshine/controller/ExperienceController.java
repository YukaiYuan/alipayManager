package cn.viewshine.controller;

import cn.viewshine.contants.AlipayInfoConstants;
import cn.viewshine.contants.RequestUrlConstants;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuanyukai on 2018-4-24.
 * 体验版相关操作
 */
@Controller
public class ExperienceController {
    private static final Log log = LogFactory.getLog(ExperienceController.class);
    /**
     * 创建体验版
     */
    @RequestMapping("createExperience")
    public String createExperienceProgram(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniExperienceCreateRequest aliRequest = new AlipayOpenMiniExperienceCreateRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("app_version", "0.0.7");
        aliRequest.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniExperienceCreateResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
                return "success";
            } else {
                System.out.println("调用失败");
                return "fail";
            }
        }catch (Exception e){
            log.error(e);
        }
        return null;
    }
    /**
     * 取消体验版
     */
    public String cancelExperienceProgram(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniExperienceCancelRequest aliRequest = new AlipayOpenMiniExperienceCancelRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("app_version", "0.0.1");
        aliRequest.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniExperienceCancelResponse aliResponse = alipayClient.execute(aliRequest);
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
                return "success";
            } else {
                System.out.println("调用失败");
                return "fail";
            }
        }catch (Exception e){
            log.error(e);
        }
        return null;
    }

    /**
     * 查询体验版状态,获取体验二维码
     */
    @RequestMapping("queryExperience")
    public String queryExperienceStatus(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniExperienceQueryRequest aliRequest = new AlipayOpenMiniExperienceQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("app_version", "0.0.7");
        aliRequest.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniExperienceQueryResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
            String url = aliResponse.getExpQrCodeUrl();
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
                return "redirect:"+url;
            } else {
                System.out.println("调用失败");
                return "fail";
            }
        }catch (Exception e){
            log.error(e);
        }
        return null;
    }

    /**
     * 添加体验者
     */
    @RequestMapping("/addMember")
    public String addMember(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenAppMembersCreateRequest aliRequest = new AlipayOpenAppMembersCreateRequest();
        aliRequest.setBizContent("{" +
                "\"logon_id\":\"13588278219\"," +
                "\"role\":\"DEVELOPER\"" +
                "  }");
        try {
            AlipayOpenAppMembersCreateResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
                return "success";
            } else {
                System.out.println("调用失败");
                return "fail";
            }
        }catch (Exception e){
            log.error(e);
        }
        return "hello";
    }

    /**
     * 删除体验者
     */
    public void deleteMember(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenAppMembersDeleteRequest aliRequest = new AlipayOpenAppMembersDeleteRequest();
        aliRequest.setBizContent("{" +
                "\"user_id\":\"2088222943898172\"," +
                "\"role\":\"DEVELOPER\"" +
                "  }");
        try {
            AlipayOpenAppMembersDeleteResponse aliResponse = alipayClient.execute(aliRequest);
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }catch (Exception e){
            log.error(e);
        }
    }

    /**
     * 查询体验者
     */
    public void queryMember(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenAppMembersQueryRequest aliRequest = new AlipayOpenAppMembersQueryRequest();
        aliRequest.setBizContent("{" +
                "\"role\":\"DEVELOPER\"" +
                "  }");
        try {
            AlipayOpenAppMembersQueryResponse aliResponse = alipayClient.execute(aliRequest);
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }catch (Exception e){
            log.error(e);
        }
    }
}
