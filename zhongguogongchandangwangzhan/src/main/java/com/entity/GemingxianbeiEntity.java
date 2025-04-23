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
 * 革命先辈
 *
 * @author 
 * @email
 */
@TableName("gemingxianbei")
public class GemingxianbeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GemingxianbeiEntity() {

	}

	public GemingxianbeiEntity(T t) {
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
     * 革命先辈名称
     */
    @TableField(value = "gemingxianbei_name")

    private String gemingxianbeiName;


    /**
     * 革命先辈编号
     */
    @TableField(value = "gemingxianbei_uuid_number")

    private String gemingxianbeiUuidNumber;


    /**
     * 先辈生辰
     */
    @TableField(value = "gemingxianbei_shengchen")

    private String gemingxianbeiShengchen;


    /**
     * 先辈忌日
     */
    @TableField(value = "gemingxianbei_jiri")

    private String gemingxianbeiJiri;


    /**
     * 家庭住址
     */
    @TableField(value = "gemingxianbei_zhuzhi")

    private String gemingxianbeiZhuzhi;


    /**
     * 先辈照片
     */
    @TableField(value = "gemingxianbei_photo")

    private String gemingxianbeiPhoto;


    /**
     * 革命先辈类型
     */
    @TableField(value = "gemingxianbei_types")

    private Integer gemingxianbeiTypes;


    /**
     * 相关资料
     */
    @TableField(value = "gemingxianbei_file")

    private String gemingxianbeiFile;


    /**
     * 先辈热度
     */
    @TableField(value = "gemingxianbei_clicknum")

    private Integer gemingxianbeiClicknum;


    /**
     * 革命先辈事迹
     */
    @TableField(value = "gemingxianbei_content")

    private String gemingxianbeiContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "gemingxianbei_delete")

    private Integer gemingxianbeiDelete;


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
	 * 设置：革命先辈名称
	 */
    public String getGemingxianbeiName() {
        return gemingxianbeiName;
    }
    /**
	 * 获取：革命先辈名称
	 */

    public void setGemingxianbeiName(String gemingxianbeiName) {
        this.gemingxianbeiName = gemingxianbeiName;
    }
    /**
	 * 设置：革命先辈编号
	 */
    public String getGemingxianbeiUuidNumber() {
        return gemingxianbeiUuidNumber;
    }
    /**
	 * 获取：革命先辈编号
	 */

    public void setGemingxianbeiUuidNumber(String gemingxianbeiUuidNumber) {
        this.gemingxianbeiUuidNumber = gemingxianbeiUuidNumber;
    }
    /**
	 * 设置：先辈生辰
	 */
    public String getGemingxianbeiShengchen() {
        return gemingxianbeiShengchen;
    }
    /**
	 * 获取：先辈生辰
	 */

    public void setGemingxianbeiShengchen(String gemingxianbeiShengchen) {
        this.gemingxianbeiShengchen = gemingxianbeiShengchen;
    }
    /**
	 * 设置：先辈忌日
	 */
    public String getGemingxianbeiJiri() {
        return gemingxianbeiJiri;
    }
    /**
	 * 获取：先辈忌日
	 */

    public void setGemingxianbeiJiri(String gemingxianbeiJiri) {
        this.gemingxianbeiJiri = gemingxianbeiJiri;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getGemingxianbeiZhuzhi() {
        return gemingxianbeiZhuzhi;
    }
    /**
	 * 获取：家庭住址
	 */

    public void setGemingxianbeiZhuzhi(String gemingxianbeiZhuzhi) {
        this.gemingxianbeiZhuzhi = gemingxianbeiZhuzhi;
    }
    /**
	 * 设置：先辈照片
	 */
    public String getGemingxianbeiPhoto() {
        return gemingxianbeiPhoto;
    }
    /**
	 * 获取：先辈照片
	 */

    public void setGemingxianbeiPhoto(String gemingxianbeiPhoto) {
        this.gemingxianbeiPhoto = gemingxianbeiPhoto;
    }
    /**
	 * 设置：革命先辈类型
	 */
    public Integer getGemingxianbeiTypes() {
        return gemingxianbeiTypes;
    }
    /**
	 * 获取：革命先辈类型
	 */

    public void setGemingxianbeiTypes(Integer gemingxianbeiTypes) {
        this.gemingxianbeiTypes = gemingxianbeiTypes;
    }
    /**
	 * 设置：相关资料
	 */
    public String getGemingxianbeiFile() {
        return gemingxianbeiFile;
    }
    /**
	 * 获取：相关资料
	 */

    public void setGemingxianbeiFile(String gemingxianbeiFile) {
        this.gemingxianbeiFile = gemingxianbeiFile;
    }
    /**
	 * 设置：先辈热度
	 */
    public Integer getGemingxianbeiClicknum() {
        return gemingxianbeiClicknum;
    }
    /**
	 * 获取：先辈热度
	 */

    public void setGemingxianbeiClicknum(Integer gemingxianbeiClicknum) {
        this.gemingxianbeiClicknum = gemingxianbeiClicknum;
    }
    /**
	 * 设置：革命先辈事迹
	 */
    public String getGemingxianbeiContent() {
        return gemingxianbeiContent;
    }
    /**
	 * 获取：革命先辈事迹
	 */

    public void setGemingxianbeiContent(String gemingxianbeiContent) {
        this.gemingxianbeiContent = gemingxianbeiContent;
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
    public Integer getGemingxianbeiDelete() {
        return gemingxianbeiDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setGemingxianbeiDelete(Integer gemingxianbeiDelete) {
        this.gemingxianbeiDelete = gemingxianbeiDelete;
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
        return "Gemingxianbei{" +
            "id=" + id +
            ", gemingxianbeiName=" + gemingxianbeiName +
            ", gemingxianbeiUuidNumber=" + gemingxianbeiUuidNumber +
            ", gemingxianbeiShengchen=" + gemingxianbeiShengchen +
            ", gemingxianbeiJiri=" + gemingxianbeiJiri +
            ", gemingxianbeiZhuzhi=" + gemingxianbeiZhuzhi +
            ", gemingxianbeiPhoto=" + gemingxianbeiPhoto +
            ", gemingxianbeiTypes=" + gemingxianbeiTypes +
            ", gemingxianbeiFile=" + gemingxianbeiFile +
            ", gemingxianbeiClicknum=" + gemingxianbeiClicknum +
            ", gemingxianbeiContent=" + gemingxianbeiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", gemingxianbeiDelete=" + gemingxianbeiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
