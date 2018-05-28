package cn.viewshine.sevice.impl;

import cn.viewshine.entity.User;
import cn.viewshine.mapper.UserMapper;
import cn.viewshine.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanyukai on 2018-4-26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserInfoByAppid(String appid) {
        return userMapper.getUserInfoByAppid(appid);
    }
}
