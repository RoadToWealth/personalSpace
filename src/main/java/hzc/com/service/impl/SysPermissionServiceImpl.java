package hzc.com.service.impl;

import hzc.com.mapper.SysPermissionMapper;
import hzc.com.model.SysPermission;
import hzc.com.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：系统资源业务逻辑层实现类
 * @auther: HuangZhiCheng
 * @date: 2018/8/8 17:53
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {


    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findPermissionList(SysPermission sysPermission) {
       return sysPermissionMapper.findPermissionList(sysPermission);
    }

    @Override
    public int insert(SysPermission sysPermission) {
        return sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    }

}
