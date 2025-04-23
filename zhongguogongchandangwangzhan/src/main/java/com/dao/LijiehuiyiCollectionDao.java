package com.dao;

import com.entity.LijiehuiyiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LijiehuiyiCollectionView;

/**
 * 历届会议收藏 Dao 接口
 *
 * @author 
 */
public interface LijiehuiyiCollectionDao extends BaseMapper<LijiehuiyiCollectionEntity> {

   List<LijiehuiyiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
