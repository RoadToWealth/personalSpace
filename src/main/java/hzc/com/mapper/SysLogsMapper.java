package hzc.com.mapper;

import hzc.com.model.SysLogs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogsMapper {
    /**
     *
     * @mbg.generated 2018-08-06
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insert(SysLogs record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int insertSelective(SysLogs record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    SysLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKeySelective(SysLogs record);

    /**
     *
     * @mbg.generated 2018-08-06
     */
    int updateByPrimaryKey(SysLogs record);
}