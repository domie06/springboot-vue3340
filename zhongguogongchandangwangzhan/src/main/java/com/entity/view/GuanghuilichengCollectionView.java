package com.entity.view;

import com.entity.GuanghuilichengCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 光辉历程收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("guanghuilicheng_collection")
public class GuanghuilichengCollectionView extends GuanghuilichengCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String guanghuilichengCollectionValue;



		//级联表 guanghuilicheng
			/**
			* 光辉历程名称
			*/
			private String guanghuilichengName;
			/**
			* 光辉历程编号
			*/
			private String guanghuilichengUuidNumber;
			/**
			* 光辉历程照片
			*/
			private String guanghuilichengPhoto;
			/**
			* 历程时期
			*/
			private Integer guanghuilichengTypes;
				/**
				* 历程时期的值
				*/
				private String guanghuilichengValue;
			/**
			* 相关文件
			*/
			private String guanghuilichengFile;
			/**
			* 历程热度
			*/
			private Integer guanghuilichengClicknum;
			/**
			* 光辉历程详细介绍
			*/
			private String guanghuilichengContent;
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
			private Integer guanghuilichengDelete;

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

	public GuanghuilichengCollectionView() {

	}

	public GuanghuilichengCollectionView(GuanghuilichengCollectionEntity guanghuilichengCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, guanghuilichengCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getGuanghuilichengCollectionValue() {
				return guanghuilichengCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setGuanghuilichengCollectionValue(String guanghuilichengCollectionValue) {
				this.guanghuilichengCollectionValue = guanghuilichengCollectionValue;
			}
















				//级联表的get和set guanghuilicheng

					/**
					* 获取： 光辉历程名称
					*/
					public String getGuanghuilichengName() {
						return guanghuilichengName;
					}
					/**
					* 设置： 光辉历程名称
					*/
					public void setGuanghuilichengName(String guanghuilichengName) {
						this.guanghuilichengName = guanghuilichengName;
					}

					/**
					* 获取： 光辉历程编号
					*/
					public String getGuanghuilichengUuidNumber() {
						return guanghuilichengUuidNumber;
					}
					/**
					* 设置： 光辉历程编号
					*/
					public void setGuanghuilichengUuidNumber(String guanghuilichengUuidNumber) {
						this.guanghuilichengUuidNumber = guanghuilichengUuidNumber;
					}

					/**
					* 获取： 光辉历程照片
					*/
					public String getGuanghuilichengPhoto() {
						return guanghuilichengPhoto;
					}
					/**
					* 设置： 光辉历程照片
					*/
					public void setGuanghuilichengPhoto(String guanghuilichengPhoto) {
						this.guanghuilichengPhoto = guanghuilichengPhoto;
					}

					/**
					* 获取： 历程时期
					*/
					public Integer getGuanghuilichengTypes() {
						return guanghuilichengTypes;
					}
					/**
					* 设置： 历程时期
					*/
					public void setGuanghuilichengTypes(Integer guanghuilichengTypes) {
						this.guanghuilichengTypes = guanghuilichengTypes;
					}


						/**
						* 获取： 历程时期的值
						*/
						public String getGuanghuilichengValue() {
							return guanghuilichengValue;
						}
						/**
						* 设置： 历程时期的值
						*/
						public void setGuanghuilichengValue(String guanghuilichengValue) {
							this.guanghuilichengValue = guanghuilichengValue;
						}

					/**
					* 获取： 相关文件
					*/
					public String getGuanghuilichengFile() {
						return guanghuilichengFile;
					}
					/**
					* 设置： 相关文件
					*/
					public void setGuanghuilichengFile(String guanghuilichengFile) {
						this.guanghuilichengFile = guanghuilichengFile;
					}

					/**
					* 获取： 历程热度
					*/
					public Integer getGuanghuilichengClicknum() {
						return guanghuilichengClicknum;
					}
					/**
					* 设置： 历程热度
					*/
					public void setGuanghuilichengClicknum(Integer guanghuilichengClicknum) {
						this.guanghuilichengClicknum = guanghuilichengClicknum;
					}

					/**
					* 获取： 光辉历程详细介绍
					*/
					public String getGuanghuilichengContent() {
						return guanghuilichengContent;
					}
					/**
					* 设置： 光辉历程详细介绍
					*/
					public void setGuanghuilichengContent(String guanghuilichengContent) {
						this.guanghuilichengContent = guanghuilichengContent;
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
					public Integer getGuanghuilichengDelete() {
						return guanghuilichengDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setGuanghuilichengDelete(Integer guanghuilichengDelete) {
						this.guanghuilichengDelete = guanghuilichengDelete;
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
