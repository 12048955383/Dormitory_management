package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户(TSUser)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Data
@Getter
@Setter
public class TSUser implements Serializable {
    private static final long serialVersionUID = 424024938151610080L;
    /**
     * 用户ID
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 职务
     */
    private String position;
    /**
     * 职务说明
     */
    private String positionDesc;
    /**
     * 真是姓名
     */
    private String realName;
    /**
     * 1 : 正常  2 :禁用
     */
    private Integer status;
    /**
     * 用户名
     */
    private String username;
    /**
     * 部门ID
     */
    private String departid;

    /**
     * 对应的角色
     */
    private List<TSRole> roles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    public List<TSRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TSRole> roles) {
        this.roles = roles;
    }
}