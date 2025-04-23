package com.entity.view;

import com.entity.GemingxianbeiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 革命先辈收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gemingxianbei_collection")
public class GemingxianbeiCollectionView extends GemingxianbeiCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String gemingxianbeiCollectionValue;



		//级联表 gemingxianbei
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
				* 革命先辈类型的值
				*/
				private String gemingxianbeiValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer gemingxianbeiDelete;

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

	public GemingxianbeiCollectionView() {

	}

	public GemingxianbeiCollectionView(GemingxianbeiCollectionEntity gemingxianbeiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, gemingxianbeiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getGemingxianbeiCollectionValue() {
				return gemingxianbeiCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setGemingxianbeiCollectionValue(String gemingxianbeiCollectionValue) {
				this.gemingxianbeiCollectionValue = gemingxianbeiCollectionValue;
			}







				//级联表的get和set gemingxianbei

					/**
					* 获取： 革命先辈名称
					*/
					public String getGemingxianbeiName() {
						return gemingxianbeiName;
					}
					/**
					* 设置： 革命先辈名称
					*/
					public void setGemingxianbeiName(String gemingxianbeiName) {
						this.gemingxianbeiName = gemingxianbeiName;
					}

					/**
					* 获取： 革命先辈编号
					*/
					public String getGemingxianbeiUuidNumber() {
						return gemingxianbeiUuidNumber;
					}
					/**
					* 设置： 革命先辈编号
					*/
					public void setGemingxianbeiUuidNumber(String gemingxianbeiUuidNumber) {
						this.gemingxianbeiUuidNumber = gemingxianbeiUuidNumber;
					}

					/**
					* 获取： 先辈生辰
					*/
					public String getGemingxianbeiShengchen() {
						return gemingxianbeiShengchen;
					}
					/**
					* 设置： 先辈生辰
					*/
					public void setGemingxianbeiShengchen(String gemingxianbeiShengchen) {
						this.gemingxianbeiShengchen = gemingxianbeiShengchen;
					}

					/**
					* 获取： 先辈忌日
					*/
					public String getGemingxianbeiJiri() {
						return gemingxianbeiJiri;
					}
					/**
					* 设置： 先辈忌日
					*/
					public void setGemingxianbeiJiri(String gemingxianbeiJiri) {
						this.gemingxianbeiJiri = gemingxianbeiJiri;
					}

					/**
					* 获取： 家庭住址
					*/
					public String getGemingxianbeiZhuzhi() {
						return gemingxianbeiZhuzhi;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setGemingxianbeiZhuzhi(String gemingxianbeiZhuzhi) {
						this.gemingxianbeiZhuzhi = gemingxianbeiZhuzhi;
					}

					/**
					* 获取： 先辈照片
					*/
					public String getGemingxianbeiPhoto() {
						return gemingxianbeiPhoto;
					}
					/**
					* 设置： 先辈照片
					*/
					public void setGemingxianbeiPhoto(String gemingxianbeiPhoto) {
						this.gemingxianbeiPhoto = gemingxianbeiPhoto;
					}

					/**
					* 获取： 革命先辈类型
					*/
					public Integer getGemingxianbeiTypes() {
						return gemingxianbeiTypes;
					}
					/**
					* 设置： 革命先辈类型
					*/
					public void setGemingxianbeiTypes(Integer gemingxianbeiTypes) {
						this.gemingxianbeiTypes = gemingxianbeiTypes;
					}


						/**
						* 获取： 革命先辈类型的值
						*/
						public String getGemingxianbeiValue() {
							return gemingxianbeiValue;
						}
						/**
						* 设置： 革命先辈类型的值
						*/
						public void setGemingxianbeiValue(String gemingxianbeiValue) {
							this.gemingxianbeiValue = gemingxianbeiValue;
						}

					/**
					* 获取： 相关资料
					*/
					public String getGemingxianbeiFile() {
						return gemingxianbeiFile;
					}
					/**
					* 设置： 相关资料
					*/
					public void setGemingxianbeiFile(String gemingxianbeiFile) {
						this.gemingxianbeiFile = gemingxianbeiFile;
					}

					/**
					* 获取： 先辈热度
					*/
					public Integer getGemingxianbeiClicknum() {
						return gemingxianbeiClicknum;
					}
					/**
					* 设置： 先辈热度
					*/
					public void setGemingxianbeiClicknum(Integer gemingxianbeiClicknum) {
						this.gemingxianbeiClicknum = gemingxianbeiClicknum;
					}

					/**
					* 获取： 革命先辈事迹
					*/
					public String getGemingxianbeiContent() {
						return gemingxianbeiContent;
					}
					/**
					* 设置： 革命先辈事迹
					*/
					public void setGemingxianbeiContent(String gemingxianbeiContent) {
						this.gemingxianbeiContent = gemingxianbeiContent;
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
					public Integer getGemingxianbeiDelete() {
						return gemingxianbeiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setGemingxianbeiDelete(Integer gemingxianbeiDelete) {
						this.gemingxianbeiDelete = gemingxianbeiDelete;
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
