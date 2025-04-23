package com.entity.view;

import com.entity.LijiehuiyiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 历届会议收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("lijiehuiyi_collection")
public class LijiehuiyiCollectionView extends LijiehuiyiCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String lijiehuiyiCollectionValue;



		//级联表 lijiehuiyi
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
				* 几大会议的值
				*/
				private String lijiehuiyiValue;
			/**
			* 会议类型
			*/
			private Integer huiyileixingTypes;
				/**
				* 会议类型的值
				*/
				private String huiyileixingValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer lijiehuiyiDelete;

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

	public LijiehuiyiCollectionView() {

	}

	public LijiehuiyiCollectionView(LijiehuiyiCollectionEntity lijiehuiyiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, lijiehuiyiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getLijiehuiyiCollectionValue() {
				return lijiehuiyiCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setLijiehuiyiCollectionValue(String lijiehuiyiCollectionValue) {
				this.lijiehuiyiCollectionValue = lijiehuiyiCollectionValue;
			}


































				//级联表的get和set lijiehuiyi

					/**
					* 获取： 历届会议名称
					*/
					public String getLijiehuiyiName() {
						return lijiehuiyiName;
					}
					/**
					* 设置： 历届会议名称
					*/
					public void setLijiehuiyiName(String lijiehuiyiName) {
						this.lijiehuiyiName = lijiehuiyiName;
					}

					/**
					* 获取： 历届会议编号
					*/
					public String getLijiehuiyiUuidNumber() {
						return lijiehuiyiUuidNumber;
					}
					/**
					* 设置： 历届会议编号
					*/
					public void setLijiehuiyiUuidNumber(String lijiehuiyiUuidNumber) {
						this.lijiehuiyiUuidNumber = lijiehuiyiUuidNumber;
					}

					/**
					* 获取： 历届会议照片
					*/
					public String getLijiehuiyiPhoto() {
						return lijiehuiyiPhoto;
					}
					/**
					* 设置： 历届会议照片
					*/
					public void setLijiehuiyiPhoto(String lijiehuiyiPhoto) {
						this.lijiehuiyiPhoto = lijiehuiyiPhoto;
					}

					/**
					* 获取： 开会地点
					*/
					public String getLijiehuiyiAddress() {
						return lijiehuiyiAddress;
					}
					/**
					* 设置： 开会地点
					*/
					public void setLijiehuiyiAddress(String lijiehuiyiAddress) {
						this.lijiehuiyiAddress = lijiehuiyiAddress;
					}

					/**
					* 获取： 开会时间
					*/
					public Date getLijiehuiyiTime() {
						return lijiehuiyiTime;
					}
					/**
					* 设置： 开会时间
					*/
					public void setLijiehuiyiTime(Date lijiehuiyiTime) {
						this.lijiehuiyiTime = lijiehuiyiTime;
					}

					/**
					* 获取： 开会摘要
					*/
					public String getLijiehuiyiZhaiyao() {
						return lijiehuiyiZhaiyao;
					}
					/**
					* 设置： 开会摘要
					*/
					public void setLijiehuiyiZhaiyao(String lijiehuiyiZhaiyao) {
						this.lijiehuiyiZhaiyao = lijiehuiyiZhaiyao;
					}

					/**
					* 获取： 几大会议
					*/
					public Integer getLijiehuiyiTypes() {
						return lijiehuiyiTypes;
					}
					/**
					* 设置： 几大会议
					*/
					public void setLijiehuiyiTypes(Integer lijiehuiyiTypes) {
						this.lijiehuiyiTypes = lijiehuiyiTypes;
					}


						/**
						* 获取： 几大会议的值
						*/
						public String getLijiehuiyiValue() {
							return lijiehuiyiValue;
						}
						/**
						* 设置： 几大会议的值
						*/
						public void setLijiehuiyiValue(String lijiehuiyiValue) {
							this.lijiehuiyiValue = lijiehuiyiValue;
						}

					/**
					* 获取： 会议类型
					*/
					public Integer getHuiyileixingTypes() {
						return huiyileixingTypes;
					}
					/**
					* 设置： 会议类型
					*/
					public void setHuiyileixingTypes(Integer huiyileixingTypes) {
						this.huiyileixingTypes = huiyileixingTypes;
					}


						/**
						* 获取： 会议类型的值
						*/
						public String getHuiyileixingValue() {
							return huiyileixingValue;
						}
						/**
						* 设置： 会议类型的值
						*/
						public void setHuiyileixingValue(String huiyileixingValue) {
							this.huiyileixingValue = huiyileixingValue;
						}

					/**
					* 获取： 会议文件
					*/
					public String getLijiehuiyiFile() {
						return lijiehuiyiFile;
					}
					/**
					* 设置： 会议文件
					*/
					public void setLijiehuiyiFile(String lijiehuiyiFile) {
						this.lijiehuiyiFile = lijiehuiyiFile;
					}

					/**
					* 获取： 历届会议详细介绍
					*/
					public String getLijiehuiyiContent() {
						return lijiehuiyiContent;
					}
					/**
					* 设置： 历届会议详细介绍
					*/
					public void setLijiehuiyiContent(String lijiehuiyiContent) {
						this.lijiehuiyiContent = lijiehuiyiContent;
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
					public Integer getLijiehuiyiDelete() {
						return lijiehuiyiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setLijiehuiyiDelete(Integer lijiehuiyiDelete) {
						this.lijiehuiyiDelete = lijiehuiyiDelete;
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
