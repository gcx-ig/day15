package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Course implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 课程编码
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程名
     *
     * @return name - 课程名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名
     *
     * @param name 课程名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取课程编码
     *
     * @return code - 课程编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置课程编码
     *
     * @param code 课程编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}