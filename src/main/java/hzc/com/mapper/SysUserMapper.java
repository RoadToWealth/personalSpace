package hzc.com.mapper;

import hzc.com.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 描述：系统用户表数据访问层接口
 * @auther: HuangZhiCheng
 * @date: 2018/8/7 17:06
 */
@Mapper
public interface SysUserMapper {
    /**
     *
     * @mbg.generated 2018-08-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insert(SysUser record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insertSelective(SysUser record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 根据登录账号获取用户信息
     * @param loginCode
     * @return
     */
    SysUser findUserCode(String loginCode);

    /**
     * 锁定用户账号
     * @param loginCode
     * @return
     */
    int lockUserCode(String loginCode);

    /**
     * 根据条件获取系统用户信息
     * @param sysUser 用户参数信息
     * @return
     */
    List<SysUser> findUserAll(SysUser sysUser);
}