package hzc.com.model;

import java.io.Serializable;
import java.util.Date;

public class SysLogs implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 请求地址
     */
    private String httpUrl;

    /**
     * 请求方式
     */
    private String httpMethod;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 请求方法
     */
    private String classMethod;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * sys_logs
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
     * 请求地址
     * @return http_url 请求地址
     */
    public String getHttpUrl() {
        return httpUrl;
    }

    /**
     * 请求地址
     * @param httpUrl 请求地址
     */
    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl == null ? null : httpUrl.trim();
    }

    /**
     * 请求方式
     * @return http_method 请求方式
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * 请求方式
     * @param httpMethod 请求方式
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod == null ? null : httpMethod.trim();
    }

    /**
     * ip地址
     * @return ip ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip地址
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 请求参数
     * @return params 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 请求参数
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * 请求方法
     * @return class_method 请求方法
     */
    public String getClassMethod() {
        return classMethod;
    }

    /**
     * 请求方法
     * @param classMethod 请求方法
     */
    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod == null ? null : classMethod.trim();
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