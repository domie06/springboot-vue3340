package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 历届会议
 *
 * @author 
 * @email
 */
@TableName("lijiehuiyi")
public class LijiehuiyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LijiehuiyiEntity() {

	}

	public LijiehuiyiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 历届会议名称
     */
    @TableField(value = "lijiehuiyi_name")

    private String lijiehuiyiName;


    /**
     * 历届会议编号
     */
    @TableField(value = "lijiehuiyi_uuid_number")

    private String lijiehuiyiUuidNumber;


    /**
     * 历届会议照片
     */
    @TableField(value = "lijiehuiyi_photo")

    private String lijiehuiyiPhoto;


    /**
     * 开会地点
     */
    @TableField(value = "lijiehuiyi_address")

    private String lijiehuiyiAddress;


    /**
     * 开会时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "lijiehuiyi_time")

    private Date lijiehuiyiTime;


    /**
     * 开会摘要
     */
    @TableField(value = "lijiehuiyi_zhaiyao")

    private String lijiehuiyiZhaiyao;


    /**
     * 几大会议
     */
    @TableField(value = "lijiehuiyi_types")

    private Integer lijiehuiyiTypes;


    /**
     * 会议类型
     */
    @TableField(value = "huiyileixing_types")

    private Integer huiyileixingTypes;


    /**
     * 会议文件
     */
    @TableField(value = "lijiehuiyi_file")

    private String lijiehuiyiFile;


    /**
     * 历届会议详细介绍
     */
    @TableField(value = "lijiehuiyi_content")

    private String lijiehuiyiContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "lijiehuiyi_delete")

    private Integer lijiehuiyiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：历届会议名称
	 */
    public String getLijiehuiyiName() {
        return lijiehuiyiName;
    }
    /**
	 * 获取：历届会议名称
	 */

    public void setLijiehuiyiName(String lijiehuiyiName) {
        this.lijiehuiyiName = lijiehuiyiName;
    }
    /**
	 * 设置：历届会议编号
	 */
    public String getLijiehuiyiUuidNumber() {
        return lijiehuiyiUuidNumber;
    }
    /**
	 * 获取：历届会议编号
	 */

    public void setLijiehuiyiUuidNumber(String lijiehuiyiUuidNumber) {
        this.lijiehuiyiUuidNumber = lijiehuiyiUuidNumber;
    }
    /**
	 * 设置：历届会议照片
	 */
    public String getLijiehuiyiPhoto() {
        return lijiehuiyiPhoto;
    }
    /**
	 * 获取：历届会议照片
	 */

    public void setLijiehuiyiPhoto(String lijiehuiyiPhoto) {
        this.lijiehuiyiPhoto = lijiehuiyiPhoto;
    }
    /**
	 * 设置：开会地点
	 */
    public String getLijiehuiyiAddress() {
        return lijiehuiyiAddress;
    }
    /**
	 * 获取：开会地点
	 */

    public void setLijiehuiyiAddress(String lijiehuiyiAddress) {
        this.lijiehuiyiAddress = lijiehuiyiAddress;
    }
    /**
	 * 设置：开会时间
	 */
    public Date getLijiehuiyiTime() {
        return lijiehuiyiTime;
    }
    /**
	 * 获取：开会时间
	 */

    public void setLijiehuiyiTime(Date lijiehuiyiTime) {
        this.lijiehuiyiTime = lijiehuiyiTime;
    }
    /**
	 * 设置：开会摘要
	 */
    public String getLijiehuiyiZhaiyao() {
        return lijiehuiyiZhaiyao;
    }
    /**
	 * 获取：开会摘要
	 */

    public void setLijiehuiyiZhaiyao(String lijiehuiyiZhaiyao) {
        this.lijiehuiyiZhaiyao = lijiehuiyiZhaiyao;
    }
    /**
	 * 设置：几大会议
	 */
    public Integer getLijiehuiyiTypes() {
        return lijiehuiyiTypes;
    }
    /**
	 * 获取：几大会议
	 */

    public void setLijiehuiyiTypes(Integer lijiehuiyiTypes) {
        this.lijiehuiyiTypes = lijiehuiyiTypes;
    }
    /**
	 * 设置：会议类型
	 */
    public Integer getHuiyileixingTypes() {
        return huiyileixingTypes;
    }
    /**
	 * 获取：会议类型
	 */

    public void setHuiyileixingTypes(Integer huiyileixingTypes) {
        this.huiyileixingTypes = huiyileixingTypes;
    }
    /**
	 * 设置：会议文件
	 */
    public String getLijiehuiyiFile() {
        return lijiehuiyiFile;
    }
    /**
	 * 获取：会议文件
	 */

    public void setLijiehuiyiFile(String lijiehuiyiFile) {
        this.lijiehuiyiFile = lijiehuiyiFile;
    }
    /**
	 * 设置：历届会议详细介绍
	 */
    public String getLijiehuiyiContent() {
        return lijiehuiyiContent;
    }
    /**
	 * 获取：历届会议详细介绍
	 */

    public void setLijiehuiyiContent(String lijiehuiyiContent) {
        this.lijiehuiyiContent = lijiehuiyiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLijiehuiyiDelete() {
        return lijiehuiyiDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setLijiehuiyiDelete(Integer lijiehuiyiDelete) {
        this.lijiehuiyiDelete = lijiehuiyiDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Lijiehuiyi{" +
            "id=" + id +
            ", lijiehuiyiName=" + lijiehuiyiName +
            ", lijiehuiyiUuidNumber=" + lijiehuiyiUuidNumber +
            ", lijiehuiyiPhoto=" + lijiehuiyiPhoto +
            ", lijiehuiyiAddress=" + lijiehuiyiAddress +
            ", lijiehuiyiTime=" + lijiehuiyiTime +
            ", lijiehuiyiZhaiyao=" + lijiehuiyiZhaiyao +
            ", lijiehuiyiTypes=" + lijiehuiyiTypes +
            ", huiyileixingTypes=" + huiyileixingTypes +
            ", lijiehuiyiFile=" + lijiehuiyiFile +
            ", lijiehuiyiContent=" + lijiehuiyiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", lijiehuiyiDelete=" + lijiehuiyiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
