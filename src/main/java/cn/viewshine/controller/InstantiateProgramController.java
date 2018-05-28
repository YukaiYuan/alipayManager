package cn.viewshine.controller;

import cn.viewshine.contants.AlipayInfoConstants;
import cn.viewshine.contants.RequestUrlConstants;
import cn.viewshine.entity.Company;
import cn.viewshine.sevice.CompanyService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenMiniVersionBuildQueryRequest;
import com.alipay.api.request.AlipayOpenMiniVersionDeleteRequest;
import com.alipay.api.request.AlipayOpenMiniVersionUploadRequest;
import com.alipay.api.response.AlipayOpenMiniVersionBuildQueryResponse;
import com.alipay.api.response.AlipayOpenMiniVersionDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniVersionUploadResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by yuanyukai on 2018-4-24.
 * 给商家实例化小程序
 */
@Controller
public class InstantiateProgramController {
    private static final Log log = LogFactory.getLog(InstantiateProgramController.class);

    @Autowired
    CompanyService companyService;
    /**
     * 构建版本并上传,基于模板
     */
    @RequestMapping("/uploadVersion")
    public String uploadVersion(HttpServletRequest request){
        String appid = request.getParameter("appid");
        String template_version = request.getParameter("template_version");
        String template_id = request.getParameter("template_id");
        String app_version = request.getParameter("app_version");
        String ext = request.getParameter("ext");
        Company company = companyService.getCompanyByAppid(appid);
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionUploadRequest aliRequest = new AlipayOpenMiniVersionUploadRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("template_version",template_version);
        bizContent.put("template_id",template_id);
        bizContent.put("ext","{\"extEnable\": true,\"extAppid\": \"2018052460224203\",\"ext\":{\"requestUrl\":\"https://ecs.vs-gascloud.com/miniProgram/\",\"minName\":\"修水燃气营业厅\",\"appID\":\"2018052460224203\",\"companyCode\":\"VS000201\",\"serviceTel\":\"0792-7264567\"},\"window\": {\"defaultTitle\": \"修水燃气营业厅\"}}");
        //bizContent.put("ext",ext);
        bizContent.put("app_version",app_version);
        aliRequest.setBizContent(bizContent.toJSONString());
        try {
            AlipayOpenMiniVersionUploadResponse aliResponse = alipayClient.execute(aliRequest,null,company.getApp_auth_token());
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
     * 小程序查询版本构建状态
     */
    @RequestMapping("/queryVersion")
    public void queryVersion(HttpServletRequest request, HttpServletResponse response){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionBuildQueryRequest aliRequest = new AlipayOpenMiniVersionBuildQueryRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.1\"" +
                "  }");
        try {
            AlipayOpenMiniVersionBuildQueryResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
            String createStauts = aliResponse.getCreateStatus();
//            switch (createStauts){
//                case "2":
//                    response.;
//            }
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
     * 小程序删除版本
     */
    @RequestMapping("/deleteVersion")
    public void deleteVersion(HttpServletRequest request) {
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionDeleteRequest aliRequest = new AlipayOpenMiniVersionDeleteRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.1\"" +
                "  }");
        try {
            AlipayOpenMiniVersionDeleteResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
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
