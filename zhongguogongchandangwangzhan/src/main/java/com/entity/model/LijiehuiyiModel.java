package com.entity.model;

import com.entity.LijiehuiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 历届会议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LijiehuiyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 历届会议名称
     */
    private String lijiehuiyiName;


    /**
     * 历届会议编号
     */
    private String lijiehuiyiUuidNumber;


    /**
     * 历届会议照片
     */
    private String lijiehuiyiPhoto;


    /**
     * 开会地点
     */
    private String lijiehuiyiAddress;


    /**
     * 开会时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date lijiehuiyiTime;


    /**
     * 开会摘要
     */
    private String lijiehuiyiZhaiyao;


    /**
     * 几大会议
     */
    private Integer lijiehuiyiTypes;


    /**
     * 会议类型
     */
    private Integer huiyileixingTypes;


    /**
     * 会议文件
     */
    private String lijiehuiyiFile;


    /**
     * 历届会议详细介绍
     */
    private String lijiehuiyiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer lijiehuiyiDelete;


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
	 * 获取：历届会议名称
	 */
    public String getLijiehuiyiName() {
        return lijiehuiyiName;
    }


    /**
	 * 设置：历届会议名称
	 */
    public void setLijiehuiyiName(String lijiehuiyiName) {
        this.lijiehuiyiName = lijiehuiyiName;
    }
    /**
	 * 获取：历届会议编号
	 */
    public String getLijiehuiyiUuidNumber() {
        return lijiehuiyiUuidNumber;
    }


    /**
	 * 设置：历届会议编号
	 */
    public void setLijiehuiyiUuidNumber(String lijiehuiyiUuidNumber) {
        this.lijiehuiyiUuidNumber = lijiehuiyiUuidNumber;
    }
    /**
	 * 获取：历届会议照片
	 */
    public String getLijiehuiyiPhoto() {
        return lijiehuiyiPhoto;
    }


    /**
	 * 设置：历届会议照片
	 */
    public void setLijiehuiyiPhoto(String lijiehuiyiPhoto) {
        this.lijiehuiyiPhoto = lijiehuiyiPhoto;
    }
    /**
	 * 获取：开会地点
	 */
    public String getLijiehuiyiAddress() {
        return lijiehuiyiAddress;
    }


    /**
	 * 设置：开会地点
	 */
    public void setLijiehuiyiAddress(String lijiehuiyiAddress) {
        this.lijiehuiyiAddress = lijiehuiyiAddress;
    }
    /**
	 * 获取：开会时间
	 */
    public Date getLijiehuiyiTime() {
        return lijiehuiyiTime;
    }


    /**
	 * 设置：开会时间
	 */
    public void setLijiehuiyiTime(Date lijiehuiyiTime) {
        this.lijiehuiyiTime = lijiehuiyiTime;
    }
    /**
	 * 获取：开会摘要
	 */
    public String getLijiehuiyiZhaiyao() {
        return lijiehuiyiZhaiyao;
    }


    /**
	 * 设置：开会摘要
	 */
    public void setLijiehuiyiZhaiyao(String lijiehuiyiZhaiyao) {
        this.lijiehuiyiZhaiyao = lijiehuiyiZhaiyao;
    }
    /**
	 * 获取：几大会议
	 */
    public Integer getLijiehuiyiTypes() {
        return lijiehuiyiTypes;
    }


    /**
	 * 设置：几大会议
	 */
    public void setLijiehuiyiTypes(Integer lijiehuiyiTypes) {
        this.lijiehuiyiTypes = lijiehuiyiTypes;
    }
    /**
	 * 获取：会议类型
	 */
    public Integer getHuiyileixingTypes() {
        return huiyileixingTypes;
    }


    /**
	 * 设置：会议类型
	 */
    public void setHuiyileixingTypes(Integer huiyileixingTypes) {
        this.huiyileixingTypes = huiyileixingTypes;
    }
    /**
	 * 获取：会议文件
	 */
    public String getLijiehuiyiFile() {
        return lijiehuiyiFile;
    }


    /**
	 * 设置：会议文件
	 */
    public void setLijiehuiyiFile(String lijiehuiyiFile) {
        this.lijiehuiyiFile = lijiehuiyiFile;
    }
    /**
	 * 获取：历届会议详细介绍
	 */
    public String getLijiehuiyiContent() {
        return lijiehuiyiContent;
    }


    /**
	 * 设置：历届会议详细介绍
	 */
    public void setLijiehuiyiContent(String lijiehuiyiContent) {
        this.lijiehuiyiContent = lijiehuiyiContent;
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
    public Integer getLijiehuiyiDelete() {
        return lijiehuiyiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setLijiehuiyiDelete(Integer lijiehuiyiDelete) {
        this.lijiehuiyiDelete = lijiehuiyiDelete;
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
