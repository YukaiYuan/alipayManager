package cn.viewshine.sevice.impl;

import cn.viewshine.entity.Company;
import cn.viewshine.mapper.CompanyMapper;
import cn.viewshine.sevice.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanyukai on 2018-5-25.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;
    @Override
    public Company getCompanyByAppid(String appid) {
        return companyMapper.getCompanyByAppid(appid);
    }
}
