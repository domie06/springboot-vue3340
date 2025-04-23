package com.entity.view;

import com.entity.GuanghuilichengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 光辉历程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("guanghuilicheng")
public class GuanghuilichengView extends GuanghuilichengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 历程时期的值
		*/
		private String guanghuilichengValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public GuanghuilichengView() {

	}

	public GuanghuilichengView(GuanghuilichengEntity guanghuilichengEntity) {
		try {
			BeanUtils.copyProperties(this, guanghuilichengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
