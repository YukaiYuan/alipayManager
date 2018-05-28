package cn.viewshine.entity;

/**
 * Created by yuanyukai on 2018-4-26.
 */
public class User {
    private String name;
    private String account;
    private String email;
    private int phonenumber;
    private String appid;
    private String key;
    private String alikey;

    public String getOrderTicket() {
        return orderTicket;
    }

    public void setOrderTicket(String orderTicket) {
        this.orderTicket = orderTicket;
    }

    private String orderTicket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlikey() {
        return alikey;
    }

    public void setAlikey(String alikey) {
        this.alikey = alikey;
    }
}
