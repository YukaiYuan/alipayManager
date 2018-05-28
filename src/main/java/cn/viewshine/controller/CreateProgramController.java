package cn.viewshine.controller;

import cn.viewshine.entity.User;
import cn.viewshine.sevice.UserService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayOpenAgentCancelRequest;
import com.alipay.api.request.AlipayOpenAgentConfirmRequest;
import com.alipay.api.request.AlipayOpenAgentCreateRequest;
import com.alipay.api.request.AlipayOpenAgentMiniCreateRequest;
import com.alipay.api.response.AlipayOpenAgentCancelResponse;
import com.alipay.api.response.AlipayOpenAgentConfirmResponse;
import com.alipay.api.response.AlipayOpenAgentCreateResponse;
import com.alipay.api.response.AlipayOpenAgentMiniCreateResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static cn.viewshine.contants.AlipayInfoConstants.ALIPAY_PUBLIC_KEY;
import static cn.viewshine.contants.AlipayInfoConstants.PRIVATE_KEY;

/**
 * Created by yuanyukai on 2018-4-24.
 * 代商户创建小程序&获取app_auth_token
 */
@Controller
public class CreateProgramController {

    @Autowired
    private UserService userService;
    private static final Log log = LogFactory.getLog(CreateProgramController.class);
    /**
     * 用于开启一个操作事务，必须是第一个调用的接口
     */
    @RequestMapping("/createAgent")
    public String createAgent(HttpServletRequest request){
        String app_id = request.getParameter("appid");
        User user = userService.getUserInfoByAppid(app_id);
        if(user == null){
            return "register";
        }
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",user.getAppid(),PRIVATE_KEY,"json","UTF-8",ALIPAY_PUBLIC_KEY,"RSA2");
        AlipayOpenAgentCreateRequest aliRequest = new AlipayOpenAgentCreateRequest();
        StringBuffer bizContent = new StringBuffer();
        bizContent = bizContent.append("{\"account\":\"").append(user.getAccount()).append("\",\"contact_info\":{\"contact_name\":\"").append(user.getName())
                    .append("\",\"contact_mobile\":\"").append(user.getPhonenumber()).append("\",\"contact_email\":\"").append(user.getEmail()).append("\"}");
        if(user.getOrderTicket() != null){
            bizContent.append(",\"order_ticket\":\"").append(user.getOrderTicket()).append("\"}");
        }
        aliRequest.setBizContent(bizContent.toString());
//        aliRequest.setBizContent("{" +
//                "\"account\":\""+user.getAccount()+"\"," +
//                "\"contact_info\":{" +
//                "\"contact_name\":\""+user.getName()+"\"," +
//                "\"contact_mobile\":\""+user.getPhonenumber()+"\"," +
//                "\"contact_email\":\""+user.getEmail()+"\"" +
//                "    }," +
//                "\"order_ticket\":\"00ee2d475f374ad097ee0f1ac223fX00\"" +
//                "  }");
        try {
            AlipayOpenAgentCreateResponse aliResponse = alipayClient.execute(aliRequest);
            log.info(aliResponse.getBody());
            if (aliResponse.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }catch (Exception e){
            log.error(e);
        }
        return null;
    }

    /**
     *  代商户创建小程序应用
     */
    public void createAgentMiniProgram(){

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenAgentMiniCreateRequest aliRequest = new AlipayOpenAgentMiniCreateRequest();
        aliRequest.setBatchNo("2017110616474516400082883");
        aliRequest.setAppName("示例小程序");
        aliRequest.setAppEnglishName("testapp");
        aliRequest.setAppCategoryIds("107397_107223");
        aliRequest.setAppSlogan("测试小程序，专业的小程序");
        aliRequest.setServicePhone("0571-12345678");
        aliRequest.setServiceEmail("test@alipay.com");
        FileItem AppLogo = new FileItem("C:/Downloads/ooopic_963991_7eea1f5426105f9e6069/16365_1271139700.jpg");
        aliRequest.setAppLogo(AppLogo);
        aliRequest.setAppDesc("测试小程序描述信息");
        try {
            AlipayOpenAgentMiniCreateResponse aliResponse = alipayClient.execute(aliRequest);
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
     * 提交事务。得到app_auth_token
     * 只允许提交init状态的事务，submit|cancel|timeout 状态的都是终态，不允许提交，
     * 且不允许提交空事务，需要先调用代创建小程序、代签约当面付等业务接口，再提交事务。
     */
    public void commitAffair(){

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenAgentConfirmRequest aliRequest = new AlipayOpenAgentConfirmRequest();
        aliRequest.setBizContent("{" +
                "\"batch_no\":\"2017110616474516400082883\"" +
                "  }");
        try {
            AlipayOpenAgentConfirmResponse aliResponse = alipayClient.execute(aliRequest);
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
     * 取消事务接口
     * 未到终态的事务号才能调用取消接口
     */
    public void cancelAffair(){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenAgentCancelRequest aliRequest = new AlipayOpenAgentCancelRequest();
        aliRequest.setBizContent("{" +
                "\"batch_no\":\"2017110616474516400082883\"" +
                "  }");
        try {
            AlipayOpenAgentCancelResponse aliResponse = alipayClient.execute(aliRequest);
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
