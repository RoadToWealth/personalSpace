package hzc.com.service.impl;

import hzc.com.mapper.SysUserMapper;
import hzc.com.model.SysUser;
import hzc.com.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：系统用户业务逻辑层实现类
 * @auther: HuangZhiCheng
 * @date: 2018/6/22 17:00
 */
@Service
class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserCode(String loginCode) {
        return sysUserMapper.findUserCode(loginCode);
    }

    @Override
    public int lockUserCode(String loginCode) {
        return sysUserMapper.lockUserCode(loginCode);
    }

    @Override
    public List<SysUser> findUserAll(SysUser sysUser) {
        return sysUserMapper.findUserAll(sysUser);
    }
    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void insertSysUser(SysUser record) {
        sysUserMapper.insert(record);
    }

}
