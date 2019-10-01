package hzc.com.service.impl;

import hzc.com.mapper.SysRoleMapper;
import hzc.com.model.SysRole;
import hzc.com.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：系统角色业务逻辑层实现类
 * @auther: HuangZhiCheng
 * @date: 2018/7/23 17:39
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findRoleALL(SysRole sysRole) {
        return sysRoleMapper.findRoleALL(sysRole);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void saveSysRole(SysRole record) {
        sysRoleMapper.insert(record);
    }

}
