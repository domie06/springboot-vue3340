package com.entity.model;

import com.entity.GemingxianbeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 革命先辈
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GemingxianbeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 革命先辈名称
     */
    private String gemingxianbeiName;


    /**
     * 革命先辈编号
     */
    private String gemingxianbeiUuidNumber;


    /**
     * 先辈生辰
     */
    private String gemingxianbeiShengchen;


    /**
     * 先辈忌日
     */
    private String gemingxianbeiJiri;


    /**
     * 家庭住址
     */
    private String gemingxianbeiZhuzhi;


    /**
     * 先辈照片
     */
    private String gemingxianbeiPhoto;


    /**
     * 革命先辈类型
     */
    private Integer gemingxianbeiTypes;


    /**
     * 相关资料
     */
    private String gemingxianbeiFile;


    /**
     * 先辈热度
     */
    private Integer gemingxianbeiClicknum;


    /**
     * 革命先辈事迹
     */
    private String gemingxianbeiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer gemingxianbeiDelete;


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
	 * 获取：革命先辈名称
	 */
    public String getGemingxianbeiName() {
        return gemingxianbeiName;
    }


    /**
	 * 设置：革命先辈名称
	 */
    public void setGemingxianbeiName(String gemingxianbeiName) {
        this.gemingxianbeiName = gemingxianbeiName;
    }
    /**
	 * 获取：革命先辈编号
	 */
    public String getGemingxianbeiUuidNumber() {
        return gemingxianbeiUuidNumber;
    }


    /**
	 * 设置：革命先辈编号
	 */
    public void setGemingxianbeiUuidNumber(String gemingxianbeiUuidNumber) {
        this.gemingxianbeiUuidNumber = gemingxianbeiUuidNumber;
    }
    /**
	 * 获取：先辈生辰
	 */
    public String getGemingxianbeiShengchen() {
        return gemingxianbeiShengchen;
    }


    /**
	 * 设置：先辈生辰
	 */
    public void setGemingxianbeiShengchen(String gemingxianbeiShengchen) {
        this.gemingxianbeiShengchen = gemingxianbeiShengchen;
    }
    /**
	 * 获取：先辈忌日
	 */
    public String getGemingxianbeiJiri() {
        return gemingxianbeiJiri;
    }


    /**
	 * 设置：先辈忌日
	 */
    public void setGemingxianbeiJiri(String gemingxianbeiJiri) {
        this.gemingxianbeiJiri = gemingxianbeiJiri;
    }
    /**
	 * 获取：家庭住址
	 */
    public String getGemingxianbeiZhuzhi() {
        return gemingxianbeiZhuzhi;
    }


    /**
	 * 设置：家庭住址
	 */
    public void setGemingxianbeiZhuzhi(String gemingxianbeiZhuzhi) {
        this.gemingxianbeiZhuzhi = gemingxianbeiZhuzhi;
    }
    /**
	 * 获取：先辈照片
	 */
    public String getGemingxianbeiPhoto() {
        return gemingxianbeiPhoto;
    }


    /**
	 * 设置：先辈照片
	 */
    public void setGemingxianbeiPhoto(String gemingxianbeiPhoto) {
        this.gemingxianbeiPhoto = gemingxianbeiPhoto;
    }
    /**
	 * 获取：革命先辈类型
	 */
    public Integer getGemingxianbeiTypes() {
        return gemingxianbeiTypes;
    }


    /**
	 * 设置：革命先辈类型
	 */
    public void setGemingxianbeiTypes(Integer gemingxianbeiTypes) {
        this.gemingxianbeiTypes = gemingxianbeiTypes;
    }
    /**
	 * 获取：相关资料
	 */
    public String getGemingxianbeiFile() {
        return gemingxianbeiFile;
    }


    /**
	 * 设置：相关资料
	 */
    public void setGemingxianbeiFile(String gemingxianbeiFile) {
        this.gemingxianbeiFile = gemingxianbeiFile;
    }
    /**
	 * 获取：先辈热度
	 */
    public Integer getGemingxianbeiClicknum() {
        return gemingxianbeiClicknum;
    }


    /**
	 * 设置：先辈热度
	 */
    public void setGemingxianbeiClicknum(Integer gemingxianbeiClicknum) {
        this.gemingxianbeiClicknum = gemingxianbeiClicknum;
    }
    /**
	 * 获取：革命先辈事迹
	 */
    public String getGemingxianbeiContent() {
        return gemingxianbeiContent;
    }


    /**
	 * 设置：革命先辈事迹
	 */
    public void setGemingxianbeiContent(String gemingxianbeiContent) {
        this.gemingxianbeiContent = gemingxianbeiContent;
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
    public Integer getGemingxianbeiDelete() {
        return gemingxianbeiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setGemingxianbeiDelete(Integer gemingxianbeiDelete) {
        this.gemingxianbeiDelete = gemingxianbeiDelete;
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
