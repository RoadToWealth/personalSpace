package hzc.com.service;

import hzc.com.model.SysUser;

import java.util.List;

/**
 * 描述：系统用户表业务逻辑层接口
 * @auther: HuangZhiCheng
 * @date: 2018/6/22 16:58
 */
public interface SysUserService {


    /**
     * 根据登录用户名查询系统用户信息
     * @param loginCode 登录用户名
     * @return
     */
   SysUser findUserCode(String loginCode);

    /**
     * 锁定账户
     * @param loginCode 登录用户名
     * @return
     */
   int  lockUserCode(String loginCode );

    /**
     * 根据条件获取系统用户信息
     * @param sysUser 用户参数信息
     * @return
     */
   List<SysUser> findUserAll(SysUser sysUser);

    /**
     * 根据条件修改用户信息
     * @param record
     * @return
     */
   int updateByPrimaryKeySelective(SysUser record);

    /**
     * 添加系统用户信息
     * @param record
     */
   void insertSysUser(SysUser record);

}
