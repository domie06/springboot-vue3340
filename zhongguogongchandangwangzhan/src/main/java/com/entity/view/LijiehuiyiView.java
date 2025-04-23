package com.entity.view;

import com.entity.LijiehuiyiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 历届会议
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("lijiehuiyi")
public class LijiehuiyiView extends LijiehuiyiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 几大会议的值
		*/
		private String lijiehuiyiValue;
		/**
		* 会议类型的值
		*/
		private String huiyileixingValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public LijiehuiyiView() {

	}

	public LijiehuiyiView(LijiehuiyiEntity lijiehuiyiEntity) {
		try {
			BeanUtils.copyProperties(this, lijiehuiyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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




















}
