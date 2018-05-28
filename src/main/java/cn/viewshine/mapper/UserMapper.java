package cn.viewshine.mapper;

import cn.viewshine.entity.User;

/**
 * Created by yuanyukai on 2018-4-26.
 */
public interface UserMapper {
    //@Select("SELECT * FROM app WHERE appid = #{appid}")
    public User getUserInfoByAppid(String appid);
}
