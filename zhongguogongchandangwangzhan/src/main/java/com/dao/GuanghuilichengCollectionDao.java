package com.dao;

import com.entity.GuanghuilichengCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanghuilichengCollectionView;

/**
 * 光辉历程收藏 Dao 接口
 *
 * @author 
 */
public interface GuanghuilichengCollectionDao extends BaseMapper<GuanghuilichengCollectionEntity> {

   List<GuanghuilichengCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
