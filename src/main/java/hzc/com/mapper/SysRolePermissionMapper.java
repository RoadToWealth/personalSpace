package hzc.com.mapper;

import hzc.com.model.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRolePermissionMapper {
    /**
     *
     * @mbg.generated 2018-08-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insert(SysRolePermission record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insertSelective(SysRolePermission record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    SysRolePermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKey(SysRolePermission record);
}