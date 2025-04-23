package com.dao;

import com.entity.GemingxianbeiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GemingxianbeiCollectionView;

/**
 * 革命先辈收藏 Dao 接口
 *
 * @author 
 */
public interface GemingxianbeiCollectionDao extends BaseMapper<GemingxianbeiCollectionEntity> {

   List<GemingxianbeiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
