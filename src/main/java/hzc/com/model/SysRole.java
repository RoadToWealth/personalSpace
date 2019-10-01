package hzc.com.model;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String remark;

    /**
     * 是否可用,0：可用，1不可用
     */
    private String available;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * sys_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 角色描述
     * @return remark 角色描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 角色描述
     * @param remark 角色描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否可用,0：可用，1不可用
     * @return available 是否可用,0：可用，1不可用
     */
    public String getAvailable() {
        return available;
    }

    /**
     * 是否可用,0：可用，1不可用
     * @param available 是否可用,0：可用，1不可用
     */
    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}