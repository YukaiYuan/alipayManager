

/**

 * Alipay.com Inc.

 * Copyright (c) 2004-2014 All Rights Reserved.

 */

package cn.viewshine.contants;


/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 * 
 * @author taixu.zqq
 * @version $Id: AlipayServiceConstants.java, v 0.1 2014年7月24日 下午4:33:49 taixu.zqq Exp $
 */
public class AlipayInfoConstants {

    /**支付宝公钥-从支付宝生活号详情页面获取*/
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhlbpb6JxgNgRq0eYbtedWhugNaPVIgGLDxzZ/yYCKXiEH0mmb+zNFI8V2mthQgVWKZLuuRWIoh9m8u5jjvJitoEGk7ifPjp0nmdVpx8BKxODxLBDHjImBAJbNuHmGJ073kAECI0vyrrj8hTja3oAfOKbL9vLlEtU1Nm37IPPlkg+boy8bqBCfwJ6NFl2WfIihu2KkdrP0okUWQuj6U9DSkrC1qJKbFXX4RUCCQkUKMA84QhLdwmQMa/ds8VMBCanTIGQnlCNFN9qEKk/MABLv8OBKnan2jW/rgweH/bFHwyfxxHV0MWgffaYv64NcZEpP0e+AKoorPNThLyEiCmG2wIDAQAB";

    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA2";
    
    /**开发者账号PID*/
    public static final String PARTNER           = "2088221418844035";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID            = "2018031602386561";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbS7EfW2wevzLGt0jL4ZJsocSPYc70Hv5k5YS+ElOh+6tjlzibLCWlEZapWp7xUV+I4SQymqaIc+jt7/SwDYZSVu+qFHzVGCrTsHafA3S5UZFgKhh6gJuY9RNf8PveCfNH8aTcHCFDMAx0MutogfI38nwvIM8eeUNCbZ8mf8vFq+a76P5Gshk8eRTKVnUz83Ph7Xl92uoqJOZpH5KtMMYF/+mW0fWo3R9g9xuwxHSu5lc+O+0BHpCFts/ywHryVw9LBYeSCuexIgj4T9Al96k6nViu6gyJ8CfymxqP0XAFX4/64rmt/0YZwewtRO4zPlImrdzZW85K9sLxq6EUf2aJAgMBAAECggEAb0CMhXBTRrumvqFzb0wMP/KsBCQHxO+nQ9UBgcFTVModAF3HWbMIzPaKvoyDLVIkZMUVz4LnJv4SstKisrUds0NAstG2lFqZ48mZUVWCe3ip8wB1RN15mtyHosXbSjhKpxHAD0e/tIhpg50u9FGTmu0GdiTE/InW23H4//Wxn8vm5G+EOaZfFWbcuobl6HEek3ld7zh8HC5Z9BwLHy5wHjirW3Y/CtWlggJ+psUKPGwHYQN/3EzPGMxZRrF7vlGr3jPHSrzplEd2EIDrsgGvonBeU/WWbft4nH+uGmpYjluJMZfjFDeBwjNzcm409W2lvcmFAY/YZt0ODNLZyNmIAQKBgQDLdN1zwspGrIG1LqVu+Kf1GtcsM8A8ohhv4csOptzN7O9Jmoa/Kt6fnJsZboeP3e/TQYhr3HCGIg3bo7ewS062IYLjRgr0UiPB2XOA/gNjSVbouEcbNtDQQVg5LC6zoXobecBrtT3+aCZmAEta0A/u3K+1gbrkRHLt9aP/4TEFgQKBgQDDZsQhTma7wsNa2I45Mf+AioUUkXc2WDzZRdrwCMMkCAxq9rDQZEEKdiLiOSUETXSaULiadJQnpm+G7HgFv7mnvCTQ6EU9nkJ6KDvTsWr3smVItriyS31EFcMckkDHqZG6LsAF6NG8dSGpBLyNr5zRkNC33P6n1nr+ZzZYJeK1CQKBgQDAYgcs+Rnv7hrQSgVgg3u+Bt1EDMNQEi5tTOKHPj038zzpKlcT2OOdpaX7TEqfPUsTRbpL06wLCZR1BcAh0XPiQJnVclvVXv40xPu1E3v8nFKzx9xk3VZiNgfIOAEJFj2yUVQkBMNUFwOIG+slOex2/vKe/MbOJfNPE6E5yaRjAQKBgAwzUnOx7YAzvPbjJp4znPxtqbmLC6J9B++ZCP6LzYNmbUAQfyHD4LvCfJMbdlA6ddlcyOn79XQ0VCpcgXH6cqEigjn5Brm+M/BkqrehEEi+/sv3fLjFNeEWasRR7XGKCOtTF/JGgzH9LkjbXtqJ6IS9Qgr45X2dSrivwRjn5KvhAoGAUbXxwUSC7h5GYXjEklm1XYjQYC5SWF/yIJGEhf6SkQ6JEsZGY3C5XsJpdEHRYklGTgS0u6UON0zi5tt01yeB8xfDKT1+PVlyeqqei48rX71yZDaK+hcVD/13tX9YBOCjgspRVIrO1wj4mrc34mx4ZOMiyvMoH6jeSlXLwKKNA1E=";

    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm0uxH1tsHr8yxrdIy+GSbKHEj2HO9B7+ZOWEvhJTofurY5c4mywlpRGWqVqe8VFfiOEkMpqmiHPo7e/0sA2GUlbvqhR81Rgq07B2nwN0uVGRYCoYeoCbmPUTX/D73gnzR/Gk3BwhQzAMdDLraIHyN/J8LyDPHnlDQm2fJn/Lxavmu+j+RrIZPHkUylZ1M/Nz4e15fdrqKiTmaR+SrTDGBf/pltH1qN0fYPcbsMR0ruZXPjvtAR6QhbbP8sB68lcPSwWHkgrnsSII+E/QJfepOp1YruoMifAn8psaj9FwBV+P+uK5rf9GGcHsLUTuMz5SJq3c2VvOSvbC8auhFH9miQIDAQAB";

    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}