package hzc.com.model;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 登录名
     */
    private String userCode;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String note;

    /**
     * 账号是否锁定，1：锁定，0未锁定
     */
    private Integer locked;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Long loginCount;

    /**
     * 是否删除 0 正常 1删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * sys_user
     */
    private static final long serialVersionUID = 1L;


    public SysUser() {
    }

    public SysUser(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public SysUser(Integer id, String userName, String phone, String email, Integer gender, String address, String note) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.note = note;
    }


    /**
     * 记录登录信息
     * @param loginCount 登录次数
     * @param lastLoginDate  最后一次登录时间
     * @param id 主键ID
     */
    public SysUser(Long loginCount, Date lastLoginDate, Integer id) {
        this.loginCount = loginCount;
        this.lastLoginDate = lastLoginDate;
        this.id = id;
    }

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
     * 用户姓名
     * @return user_name 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户姓名
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 登录名
     * @return user_code 登录名
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 登录名
     * @param userCode 登录名
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * 登录密码
     * @return password 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 密码加盐
     * @return salt 密码加盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 密码加盐
     * @param salt 密码加盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 性别
     * @return gender 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 备注
     * @return note 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 备注
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     * @return locked 账号是否锁定，1：锁定，0未锁定
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 账号是否锁定，1：锁定，0未锁定
     * @param locked 账号是否锁定，1：锁定，0未锁定
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 最后一次登录时间
     * @return last_login_date 最后一次登录时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 最后一次登录时间
     * @param lastLoginDate 最后一次登录时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 登录次数
     * @return login_count 登录次数
     */
    public Long getLoginCount() {
        return loginCount;
    }

    /**
     * 登录次数
     * @param loginCount 登录次数
     */
    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 是否删除 0 正常 1删除
     * @return is_deleted 是否删除 0 正常 1删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 0 正常 1删除
     * @param isDeleted 是否删除 0 正常 1删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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