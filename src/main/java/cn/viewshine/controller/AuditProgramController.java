package cn.viewshine.controller;

import cn.viewshine.contants.AlipayInfoConstants;
import cn.viewshine.contants.RequestUrlConstants;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.domain.RegionInfo;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanyukai on 2018-4-24.
 * 小程序提审上架
 */
@Controller
public class AuditProgramController {
    private static final Log log = LogFactory.getLog(AuditProgramController.class);
    /**
     * 提交审核
     */
    @RequestMapping("/applyAudit")
    public String applyAudit(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionAuditApplyRequest aliRequest = new AlipayOpenMiniVersionAuditApplyRequest();
        aliRequest.setAppVersion("0.0.7");
        aliRequest.setAppName("修水燃气营业厅");
        aliRequest.setAppEnglishName("xiushuiGasHall");
//        aliRequest.setAppSlogan("生活缴费");
//        FileItem AppLogo = new FileItem("C:/Downloads/ooopic_963991_7eea1f5426105f9e6069/16365_1271139700.jpg");
//        aliRequest.setAppLogo(AppLogo);
//        aliRequest.setAppCategoryIds("11_12;12_13");
//        aliRequest.setAppDesc("燃气充值缴费");
        aliRequest.setServicePhone("0792-7264567");
        aliRequest.setServiceEmail("573283658@qq.com");
        aliRequest.setVersionDesc("修水燃气营业厅能实现自己、父母、租房、朋友等地址的一键绑定，能为普表、物联网表等缴费、充值、查账；能在线服务申报、自助报数、用能分析；能及时查看燃气公司的通知公告。");
        aliRequest.setMemo("编号:10004159");
        aliRequest.setRegionType("LOCATION");
        RegionInfo regionInfo = new RegionInfo();
        regionInfo.setProvinceCode("360000");
        regionInfo.setProvinceName("江西省");
        regionInfo.setCityCode("360400");
        regionInfo.setCityName("九江市");
        regionInfo.setAreaCode("360424");
        regionInfo.setAreaName("修水县");
        List<RegionInfo>  regionInfos = new ArrayList<RegionInfo>();
        regionInfos.add(regionInfo);
        aliRequest.setServiceRegionInfo(regionInfos);
        FileItem FirstScreenShot = new FileItem("F:/images/IMG_3322.PNG");
        aliRequest.setFirstScreenShot(FirstScreenShot);
        FileItem SecondScreenShot = new FileItem("F:/images/IMG_3323.PNG");
        aliRequest.setSecondScreenShot(SecondScreenShot);
        FileItem ThirdScreenShot = new FileItem("F:/images/IMG_3324.PNG");
        aliRequest.setThirdScreenShot(ThirdScreenShot);
        FileItem FourthScreenShot = new FileItem("F:/images/IMG_3325.PNG");
        aliRequest.setFourthScreenShot(FourthScreenShot);
        FileItem FifthScreenShot = new FileItem("F:/images/IMG_3326.PNG");
        aliRequest.setFifthScreenShot(FifthScreenShot);
        try {
            AlipayOpenMiniVersionAuditApplyResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
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
     * 查询审核状态（提审后调用）
     */
    @RequestMapping("/queryAuditStatus")
    public void queryAuditStatus(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionDetailQueryRequest aliRequest = new AlipayOpenMiniVersionDetailQueryRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.6\"" +
                "  }");
        try {
            AlipayOpenMiniVersionDetailQueryResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
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
     * 退回开发（审核驳回后调用）
     */
    @RequestMapping("/cancelAudit")
    public void cancelAudit(){
        AlipayClient alipayClient = new DefaultAlipayClient(RequestUrlConstants.ALIPAY_SERVER_URL,
                AlipayInfoConstants.APP_ID,
                AlipayInfoConstants.PRIVATE_KEY,
                "json",
                "utf-8",
                AlipayInfoConstants.ALIPAY_PUBLIC_KEY,
                AlipayInfoConstants.SIGN_TYPE);
        AlipayOpenMiniVersionAuditedCancelRequest aliRequest = new AlipayOpenMiniVersionAuditedCancelRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.6\"" +
                "  }");
        try {
            AlipayOpenMiniVersionAuditedCancelResponse aliResponse = alipayClient.execute(aliRequest,null,"201805BB5028f6a8328e45dc919aa07022ddaE72");
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
     * 提交灰度（审核通过后调用）
     */
    public void uploadGray(){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenMiniVersionGrayOnlineRequest aliRequest = new AlipayOpenMiniVersionGrayOnlineRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.1\"," +
                "\"gray_strategy\":\"p10\"" +
                "  }");
        try {
            AlipayOpenMiniVersionGrayOnlineResponse aliResponse = alipayClient.execute(aliRequest);
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
     * 提交上架小程序（灰度后调用）
     */
    public void putawayProgram(){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenMiniVersionOnlineRequest aliRequest = new AlipayOpenMiniVersionOnlineRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.1\"" +
                "  }");
        try {
            AlipayOpenMiniVersionOnlineResponse aliResponse = alipayClient.execute(aliRequest);
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
     * 下架小程序
     */
    public void cancelProgram(){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayOpenMiniVersionOfflineRequest aliRequest = new AlipayOpenMiniVersionOfflineRequest();
        aliRequest.setBizContent("{" +
                "\"app_version\":\"0.0.1\"" +
                "  }");
        try {
            AlipayOpenMiniVersionOfflineResponse aliResponse = alipayClient.execute(aliRequest);
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
