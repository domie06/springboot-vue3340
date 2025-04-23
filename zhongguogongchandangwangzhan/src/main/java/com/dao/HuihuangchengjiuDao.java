package com.dao;

import com.entity.HuihuangchengjiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuihuangchengjiuView;

/**
 * 辉煌成就 Dao 接口
 *
 * @author 
 */
public interface HuihuangchengjiuDao extends BaseMapper<HuihuangchengjiuEntity> {

   List<HuihuangchengjiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
