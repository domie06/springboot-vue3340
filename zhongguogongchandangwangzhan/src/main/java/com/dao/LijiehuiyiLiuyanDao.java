package com.dao;

import com.entity.LijiehuiyiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LijiehuiyiLiuyanView;

/**
 * 历届会议留言 Dao 接口
 *
 * @author 
 */
public interface LijiehuiyiLiuyanDao extends BaseMapper<LijiehuiyiLiuyanEntity> {

   List<LijiehuiyiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
