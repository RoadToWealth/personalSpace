package hzc.com.mapper;

import hzc.com.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
    /**
     *
     * @mbg.generated 2018-08-08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-08
     */
    int insert(SysPermission record);

    /**
     *
     * @mbg.generated 2018-08-08
     */
    int insertSelective(SysPermission record);

    /**
     *
     * @mbg.generated 2018-08-08
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-08
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     *
     * @mbg.generated 2018-08-08
     */
    int updateByPrimaryKey(SysPermission record);

    /**
     * 根据条件获取资源列表
     * @param sysPermission
     * @return
     */
    List<SysPermission> findPermissionList(SysPermission sysPermission);
}