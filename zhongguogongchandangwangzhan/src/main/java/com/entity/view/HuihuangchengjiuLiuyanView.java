package com.entity.view;

import com.entity.HuihuangchengjiuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 辉煌成就留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huihuangchengjiu_liuyan")
public class HuihuangchengjiuLiuyanView extends HuihuangchengjiuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 huihuangchengjiu
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
				* 成就类型的值
				*/
				private String huihuangchengjiuValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer huihuangchengjiuDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public HuihuangchengjiuLiuyanView() {

	}

	public HuihuangchengjiuLiuyanView(HuihuangchengjiuLiuyanEntity huihuangchengjiuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, huihuangchengjiuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




























				//级联表的get和set huihuangchengjiu

					/**
					* 获取： 成就名称
					*/
					public String getHuihuangchengjiuName() {
						return huihuangchengjiuName;
					}
					/**
					* 设置： 成就名称
					*/
					public void setHuihuangchengjiuName(String huihuangchengjiuName) {
						this.huihuangchengjiuName = huihuangchengjiuName;
					}

					/**
					* 获取： 辉煌成就编号
					*/
					public String getHuihuangchengjiuUuidNumber() {
						return huihuangchengjiuUuidNumber;
					}
					/**
					* 设置： 辉煌成就编号
					*/
					public void setHuihuangchengjiuUuidNumber(String huihuangchengjiuUuidNumber) {
						this.huihuangchengjiuUuidNumber = huihuangchengjiuUuidNumber;
					}

					/**
					* 获取： 成就照片
					*/
					public String getHuihuangchengjiuPhoto() {
						return huihuangchengjiuPhoto;
					}
					/**
					* 设置： 成就照片
					*/
					public void setHuihuangchengjiuPhoto(String huihuangchengjiuPhoto) {
						this.huihuangchengjiuPhoto = huihuangchengjiuPhoto;
					}

					/**
					* 获取： 成就类型
					*/
					public Integer getHuihuangchengjiuTypes() {
						return huihuangchengjiuTypes;
					}
					/**
					* 设置： 成就类型
					*/
					public void setHuihuangchengjiuTypes(Integer huihuangchengjiuTypes) {
						this.huihuangchengjiuTypes = huihuangchengjiuTypes;
					}


						/**
						* 获取： 成就类型的值
						*/
						public String getHuihuangchengjiuValue() {
							return huihuangchengjiuValue;
						}
						/**
						* 设置： 成就类型的值
						*/
						public void setHuihuangchengjiuValue(String huihuangchengjiuValue) {
							this.huihuangchengjiuValue = huihuangchengjiuValue;
						}

					/**
					* 获取： 相关文件
					*/
					public String getHuihuangchengjiuFile() {
						return huihuangchengjiuFile;
					}
					/**
					* 设置： 相关文件
					*/
					public void setHuihuangchengjiuFile(String huihuangchengjiuFile) {
						this.huihuangchengjiuFile = huihuangchengjiuFile;
					}

					/**
					* 获取： 成就热度
					*/
					public Integer getHuihuangchengjiuClicknum() {
						return huihuangchengjiuClicknum;
					}
					/**
					* 设置： 成就热度
					*/
					public void setHuihuangchengjiuClicknum(Integer huihuangchengjiuClicknum) {
						this.huihuangchengjiuClicknum = huihuangchengjiuClicknum;
					}

					/**
					* 获取： 辉煌成就详细介绍
					*/
					public String getHuihuangchengjiuContent() {
						return huihuangchengjiuContent;
					}
					/**
					* 设置： 辉煌成就详细介绍
					*/
					public void setHuihuangchengjiuContent(String huihuangchengjiuContent) {
						this.huihuangchengjiuContent = huihuangchengjiuContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getHuihuangchengjiuDelete() {
						return huihuangchengjiuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setHuihuangchengjiuDelete(Integer huihuangchengjiuDelete) {
						this.huihuangchengjiuDelete = huihuangchengjiuDelete;
					}

























				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}






}
