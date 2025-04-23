package com.dao;

import com.entity.LijiehuiyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LijiehuiyiView;

/**
 * 历届会议 Dao 接口
 *
 * @author 
 */
public interface LijiehuiyiDao extends BaseMapper<LijiehuiyiEntity> {

   List<LijiehuiyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
