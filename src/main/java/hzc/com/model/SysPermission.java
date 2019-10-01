package hzc.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysPermission implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型：menu,button,
     */
    private String type;

    /**
     * 访问url地址
     */
    private String url;

    /**
     * 权限代码字符串
     */
    private String percode;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父结点id
     */
    private Integer parentid;

    /**
     * 排序号
     */
    private String sortstring;

    /**
     * 是否可用,0：可用，1不可用
     */
    private String available;

    /**
     * 是否展示,0：展示，1不展示
     */
    private String viewFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 是否按照序列号排序查询
     */
    private String isSortstring;

    /**
     * 子资源
     */
    private List<SysPermission> funcList;

    /**
     * sys_permission
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
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 资源类型：menu,button,
     * @return type 资源类型：menu,button,
     */
    public String getType() {
        return type;
    }

    /**
     * 资源类型：menu,button,
     * @param type 资源类型：menu,button,
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 访问url地址
     * @return url 访问url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 访问url地址
     * @param url 访问url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 权限代码字符串
     * @return percode 权限代码字符串
     */
    public String getPercode() {
        return percode;
    }

    /**
     * 权限代码字符串
     * @param percode 权限代码字符串
     */
    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    /**
     * 图标
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 父结点id
     * @return parentid 父结点id
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 父结点id
     * @param parentid 父结点id
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 排序号
     * @return sortstring 排序号
     */
    public String getSortstring() {
        return sortstring;
    }

    /**
     * 排序号
     * @param sortstring 排序号
     */
    public void setSortstring(String sortstring) {
        this.sortstring = sortstring == null ? null : sortstring.trim();
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
     * 是否展示,0：展示，1不展示
     * @return view_flag 是否展示,0：展示，1不展示
     */
    public String getViewFlag() {
        return viewFlag;
    }

    /**
     * 是否展示,0：展示，1不展示
     * @param viewFlag 是否展示,0：展示，1不展示
     */
    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag == null ? null : viewFlag.trim();
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

    /**
     * 是否按照序列号排序查询
     * @return
     */
    public String getIsSortstring() {
        return isSortstring;
    }

    /**
     * 是否按照序列号排序查询
     * @param isSortstring
     */
    public void setIsSortstring(String isSortstring) {
        this.isSortstring = isSortstring;
    }

    public List<SysPermission> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<SysPermission> funcList) {
        this.funcList = funcList;
    }
}