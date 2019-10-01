package hzc.com.model;

import java.io.Serializable;
import java.util.Date;

public class SysRolePermission implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer sysRoleId;

    /**
     * 权限ID
     */
    private Integer sysPermissionId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * sys_role_permission
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
     * 权限ID
     * @return sys_permission_id 权限ID
     */
    public Integer getSysPermissionId() {
        return sysPermissionId;
    }

    /**
     * 权限ID
     * @param sysPermissionId 权限ID
     */
    public void setSysPermissionId(Integer sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
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