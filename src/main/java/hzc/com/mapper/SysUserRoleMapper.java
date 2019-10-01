package hzc.com.mapper;

import hzc.com.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {
    /**
     *
     * @mbg.generated 2018-08-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insert(SysUserRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insertSelective(SysUserRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    SysUserRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKey(SysUserRole record);
}