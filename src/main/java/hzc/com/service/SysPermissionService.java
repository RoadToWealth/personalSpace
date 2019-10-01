package hzc.com.service;

import hzc.com.model.SysPermission;

import java.util.List;

/**
 * 描述：系统
 * @auther: HuangZhiCheng
 * @date: 2018/8/8 17:48
 */
public interface SysPermissionService {
    /**
     * 根据条件获取资源列表
     * @param sysPermission
     * @return
     */
     List<SysPermission> findPermissionList(SysPermission sysPermission);

    /**
     * 添加资源信息
     * @param record
     * @return
     */
    int insert(SysPermission sysPermission);

    /**
     * 增量修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysPermission sysPermission);


}
