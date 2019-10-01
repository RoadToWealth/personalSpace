package hzc.com.service;

import hzc.com.model.SysRole;

import java.util.List;

/**
 * 描述：系统角色业务逻辑层接口
 * @auther: HuangZhiCheng
 * @date: 2018/7/23 17:23
 */
public interface SysRoleService {

    /**
     * 根据条件获取系统角色信息
     * @param sysRole
     * @return
     */
    List<SysRole>  findRoleALL(SysRole sysRole);

    /**
     * 根据条件修改角色信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 添加角色信息
     * @param record
     */
    void saveSysRole(SysRole record);
}
