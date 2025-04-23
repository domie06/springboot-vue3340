package com.dao;

import com.entity.GuanghuilichengLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanghuilichengLiuyanView;

/**
 * 光辉历程留言 Dao 接口
 *
 * @author 
 */
public interface GuanghuilichengLiuyanDao extends BaseMapper<GuanghuilichengLiuyanEntity> {

   List<GuanghuilichengLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
