package com.entity.view;

import com.entity.GemingxianbeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 革命先辈
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gemingxianbei")
public class GemingxianbeiView extends GemingxianbeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 革命先辈类型的值
		*/
		private String gemingxianbeiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public GemingxianbeiView() {

	}

	public GemingxianbeiView(GemingxianbeiEntity gemingxianbeiEntity) {
		try {
			BeanUtils.copyProperties(this, gemingxianbeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
