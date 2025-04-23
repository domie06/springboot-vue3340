package com.dao;

import com.entity.GemingxianbeiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GemingxianbeiLiuyanView;

/**
 * 革命先辈留言 Dao 接口
 *
 * @author 
 */
public interface GemingxianbeiLiuyanDao extends BaseMapper<GemingxianbeiLiuyanEntity> {

   List<GemingxianbeiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
