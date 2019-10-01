package hzc.com.mapper;

import hzc.com.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    /**
     *
     * @mbg.generated 2018-08-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insert(SysRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insertSelective(SysRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKey(SysRole record);

    /**
     * 获取系统角色信息
     * @param sysRole
     * @return
     */
    List<SysRole> findRoleALL(SysRole sysRole);
}