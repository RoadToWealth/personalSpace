package hzc.com.model;

import java.io.Serializable;
import java.util.Date;

public class SysUserRole implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer sysUserId;

    /**
     * 角色ID
     */
    private Integer sysRoleId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * sys_user_role
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
     * 用户ID
     * @return sys_user_id 用户ID
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 用户ID
     * @param sysUserId 用户ID
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 角色ID
     * @return sys_role_id 角色ID
     */
    public Integer getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 角色ID
     * @param sysRoleId 角色ID
     */
    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
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