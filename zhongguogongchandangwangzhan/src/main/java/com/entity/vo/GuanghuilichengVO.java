package com.entity.vo;

import com.entity.GuanghuilichengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 光辉历程
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guanghuilicheng")
public class GuanghuilichengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 光辉历程名称
     */

    @TableField(value = "guanghuilicheng_name")
    private String guanghuilichengName;


    /**
     * 光辉历程编号
     */

    @TableField(value = "guanghuilicheng_uuid_number")
    private String guanghuilichengUuidNumber;


    /**
     * 光辉历程照片
     */

    @TableField(value = "guanghuilicheng_photo")
    private String guanghuilichengPhoto;


    /**
     * 历程时期
     */

    @TableField(value = "guanghuilicheng_types")
    private Integer guanghuilichengTypes;


    /**
     * 相关文件
     */

    @TableField(value = "guanghuilicheng_file")
    private String guanghuilichengFile;


    /**
     * 历程热度
     */

    @TableField(value = "guanghuilicheng_clicknum")
    private Integer guanghuilichengClicknum;


    /**
     * 光辉历程详细介绍
     */

    @TableField(value = "guanghuilicheng_content")
    private String guanghuilichengContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "guanghuilicheng_delete")
    private Integer guanghuilichengDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：光辉历程名称
	 */
    public String getGuanghuilichengName() {
        return guanghuilichengName;
    }


    /**
	 * 获取：光辉历程名称
	 */

    public void setGuanghuilichengName(String guanghuilichengName) {
        this.guanghuilichengName = guanghuilichengName;
    }
    /**
	 * 设置：光辉历程编号
	 */
    public String getGuanghuilichengUuidNumber() {
        return guanghuilichengUuidNumber;
    }


    /**
	 * 获取：光辉历程编号
	 */

    public void setGuanghuilichengUuidNumber(String guanghuilichengUuidNumber) {
        this.guanghuilichengUuidNumber = guanghuilichengUuidNumber;
    }
    /**
	 * 设置：光辉历程照片
	 */
    public String getGuanghuilichengPhoto() {
        return guanghuilichengPhoto;
    }


    /**
	 * 获取：光辉历程照片
	 */

    public void setGuanghuilichengPhoto(String guanghuilichengPhoto) {
        this.guanghuilichengPhoto = guanghuilichengPhoto;
    }
    /**
	 * 设置：历程时期
	 */
    public Integer getGuanghuilichengTypes() {
        return guanghuilichengTypes;
    }


    /**
	 * 获取：历程时期
	 */

    public void setGuanghuilichengTypes(Integer guanghuilichengTypes) {
        this.guanghuilichengTypes = guanghuilichengTypes;
    }
    /**
	 * 设置：相关文件
	 */
    public String getGuanghuilichengFile() {
        return guanghuilichengFile;
    }


    /**
	 * 获取：相关文件
	 */

    public void setGuanghuilichengFile(String guanghuilichengFile) {
        this.guanghuilichengFile = guanghuilichengFile;
    }
    /**
	 * 设置：历程热度
	 */
    public Integer getGuanghuilichengClicknum() {
        return guanghuilichengClicknum;
    }


    /**
	 * 获取：历程热度
	 */

    public void setGuanghuilichengClicknum(Integer guanghuilichengClicknum) {
        this.guanghuilichengClicknum = guanghuilichengClicknum;
    }
    /**
	 * 设置：光辉历程详细介绍
	 */
    public String getGuanghuilichengContent() {
        return guanghuilichengContent;
    }


    /**
	 * 获取：光辉历程详细介绍
	 */

    public void setGuanghuilichengContent(String guanghuilichengContent) {
        this.guanghuilichengContent = guanghuilichengContent;
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
    public Integer getGuanghuilichengDelete() {
        return guanghuilichengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGuanghuilichengDelete(Integer guanghuilichengDelete) {
        this.guanghuilichengDelete = guanghuilichengDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
