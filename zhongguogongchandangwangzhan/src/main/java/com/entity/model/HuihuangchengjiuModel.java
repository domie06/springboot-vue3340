package com.entity.model;

import com.entity.HuihuangchengjiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 辉煌成就
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuihuangchengjiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 成就名称
     */
    private String huihuangchengjiuName;


    /**
     * 辉煌成就编号
     */
    private String huihuangchengjiuUuidNumber;


    /**
     * 成就照片
     */
    private String huihuangchengjiuPhoto;


    /**
     * 成就类型
     */
    private Integer huihuangchengjiuTypes;


    /**
     * 相关文件
     */
    private String huihuangchengjiuFile;


    /**
     * 成就热度
     */
    private Integer huihuangchengjiuClicknum;


    /**
     * 辉煌成就详细介绍
     */
    private String huihuangchengjiuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer huihuangchengjiuDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：成就名称
	 */
    public String getHuihuangchengjiuName() {
        return huihuangchengjiuName;
    }


    /**
	 * 设置：成就名称
	 */
    public void setHuihuangchengjiuName(String huihuangchengjiuName) {
        this.huihuangchengjiuName = huihuangchengjiuName;
    }
    /**
	 * 获取：辉煌成就编号
	 */
    public String getHuihuangchengjiuUuidNumber() {
        return huihuangchengjiuUuidNumber;
    }


    /**
	 * 设置：辉煌成就编号
	 */
    public void setHuihuangchengjiuUuidNumber(String huihuangchengjiuUuidNumber) {
        this.huihuangchengjiuUuidNumber = huihuangchengjiuUuidNumber;
    }
    /**
	 * 获取：成就照片
	 */
    public String getHuihuangchengjiuPhoto() {
        return huihuangchengjiuPhoto;
    }


    /**
	 * 设置：成就照片
	 */
    public void setHuihuangchengjiuPhoto(String huihuangchengjiuPhoto) {
        this.huihuangchengjiuPhoto = huihuangchengjiuPhoto;
    }
    /**
	 * 获取：成就类型
	 */
    public Integer getHuihuangchengjiuTypes() {
        return huihuangchengjiuTypes;
    }


    /**
	 * 设置：成就类型
	 */
    public void setHuihuangchengjiuTypes(Integer huihuangchengjiuTypes) {
        this.huihuangchengjiuTypes = huihuangchengjiuTypes;
    }
    /**
	 * 获取：相关文件
	 */
    public String getHuihuangchengjiuFile() {
        return huihuangchengjiuFile;
    }


    /**
	 * 设置：相关文件
	 */
    public void setHuihuangchengjiuFile(String huihuangchengjiuFile) {
        this.huihuangchengjiuFile = huihuangchengjiuFile;
    }
    /**
	 * 获取：成就热度
	 */
    public Integer getHuihuangchengjiuClicknum() {
        return huihuangchengjiuClicknum;
    }


    /**
	 * 设置：成就热度
	 */
    public void setHuihuangchengjiuClicknum(Integer huihuangchengjiuClicknum) {
        this.huihuangchengjiuClicknum = huihuangchengjiuClicknum;
    }
    /**
	 * 获取：辉煌成就详细介绍
	 */
    public String getHuihuangchengjiuContent() {
        return huihuangchengjiuContent;
    }


    /**
	 * 设置：辉煌成就详细介绍
	 */
    public void setHuihuangchengjiuContent(String huihuangchengjiuContent) {
        this.huihuangchengjiuContent = huihuangchengjiuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHuihuangchengjiuDelete() {
        return huihuangchengjiuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setHuihuangchengjiuDelete(Integer huihuangchengjiuDelete) {
        this.huihuangchengjiuDelete = huihuangchengjiuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
