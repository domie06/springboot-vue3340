
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 辉煌成就
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huihuangchengjiu")
public class HuihuangchengjiuController {
    private static final Logger logger = LoggerFactory.getLogger(HuihuangchengjiuController.class);

    @Autowired
    private HuihuangchengjiuService huihuangchengjiuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("huihuangchengjiuDeleteStart",1);params.put("huihuangchengjiuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huihuangchengjiuService.queryPage(params);

        //字典表数据转换
        List<HuihuangchengjiuView> list =(List<HuihuangchengjiuView>)page.getList();
        for(HuihuangchengjiuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuihuangchengjiuEntity huihuangchengjiu = huihuangchengjiuService.selectById(id);
        if(huihuangchengjiu !=null){
            //entity转view
            HuihuangchengjiuView view = new HuihuangchengjiuView();
            BeanUtils.copyProperties( huihuangchengjiu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuihuangchengjiuEntity huihuangchengjiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huihuangchengjiu:{}",this.getClass().getName(),huihuangchengjiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuihuangchengjiuEntity> queryWrapper = new EntityWrapper<HuihuangchengjiuEntity>()
            .eq("huihuangchengjiu_name", huihuangchengjiu.getHuihuangchengjiuName())
            .eq("huihuangchengjiu_uuid_number", huihuangchengjiu.getHuihuangchengjiuUuidNumber())
            .eq("huihuangchengjiu_types", huihuangchengjiu.getHuihuangchengjiuTypes())
            .eq("huihuangchengjiu_clicknum", huihuangchengjiu.getHuihuangchengjiuClicknum())
            .eq("shangxia_types", huihuangchengjiu.getShangxiaTypes())
            .eq("huihuangchengjiu_delete", huihuangchengjiu.getHuihuangchengjiuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuihuangchengjiuEntity huihuangchengjiuEntity = huihuangchengjiuService.selectOne(queryWrapper);
        if(huihuangchengjiuEntity==null){
            huihuangchengjiu.setHuihuangchengjiuClicknum(1);
            huihuangchengjiu.setShangxiaTypes(1);
            huihuangchengjiu.setHuihuangchengjiuDelete(1);
            huihuangchengjiu.setCreateTime(new Date());
            huihuangchengjiuService.insert(huihuangchengjiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuihuangchengjiuEntity huihuangchengjiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huihuangchengjiu:{}",this.getClass().getName(),huihuangchengjiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuihuangchengjiuEntity> queryWrapper = new EntityWrapper<HuihuangchengjiuEntity>()
            .notIn("id",huihuangchengjiu.getId())
            .andNew()
            .eq("huihuangchengjiu_name", huihuangchengjiu.getHuihuangchengjiuName())
            .eq("huihuangchengjiu_uuid_number", huihuangchengjiu.getHuihuangchengjiuUuidNumber())
            .eq("huihuangchengjiu_types", huihuangchengjiu.getHuihuangchengjiuTypes())
            .eq("huihuangchengjiu_clicknum", huihuangchengjiu.getHuihuangchengjiuClicknum())
            .eq("shangxia_types", huihuangchengjiu.getShangxiaTypes())
            .eq("huihuangchengjiu_delete", huihuangchengjiu.getHuihuangchengjiuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuihuangchengjiuEntity huihuangchengjiuEntity = huihuangchengjiuService.selectOne(queryWrapper);
        if("".equals(huihuangchengjiu.getHuihuangchengjiuPhoto()) || "null".equals(huihuangchengjiu.getHuihuangchengjiuPhoto())){
                huihuangchengjiu.setHuihuangchengjiuPhoto(null);
        }
        if("".equals(huihuangchengjiu.getHuihuangchengjiuFile()) || "null".equals(huihuangchengjiu.getHuihuangchengjiuFile())){
                huihuangchengjiu.setHuihuangchengjiuFile(null);
        }
        if(huihuangchengjiuEntity==null){
            huihuangchengjiuService.updateById(huihuangchengjiu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<HuihuangchengjiuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuihuangchengjiuEntity huihuangchengjiuEntity = new HuihuangchengjiuEntity();
            huihuangchengjiuEntity.setId(id);
            huihuangchengjiuEntity.setHuihuangchengjiuDelete(2);
            list.add(huihuangchengjiuEntity);
        }
        if(list != null && list.size() >0){
            huihuangchengjiuService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuihuangchengjiuEntity> huihuangchengjiuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuihuangchengjiuEntity huihuangchengjiuEntity = new HuihuangchengjiuEntity();
//                            huihuangchengjiuEntity.setHuihuangchengjiuName(data.get(0));                    //成就名称 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuUuidNumber(data.get(0));                    //辉煌成就编号 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuPhoto("");//详情和图片
//                            huihuangchengjiuEntity.setHuihuangchengjiuTypes(Integer.valueOf(data.get(0)));   //成就类型 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuFile(data.get(0));                    //相关文件 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuClicknum(Integer.valueOf(data.get(0)));   //成就热度 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuContent("");//详情和图片
//                            huihuangchengjiuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            huihuangchengjiuEntity.setHuihuangchengjiuDelete(1);//逻辑删除字段
//                            huihuangchengjiuEntity.setCreateTime(date);//时间
                            huihuangchengjiuList.add(huihuangchengjiuEntity);


                            //把要查询是否重复的字段放入map中
                                //辉煌成就编号
                                if(seachFields.containsKey("huihuangchengjiuUuidNumber")){
                                    List<String> huihuangchengjiuUuidNumber = seachFields.get("huihuangchengjiuUuidNumber");
                                    huihuangchengjiuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huihuangchengjiuUuidNumber = new ArrayList<>();
                                    huihuangchengjiuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huihuangchengjiuUuidNumber",huihuangchengjiuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //辉煌成就编号
                        List<HuihuangchengjiuEntity> huihuangchengjiuEntities_huihuangchengjiuUuidNumber = huihuangchengjiuService.selectList(new EntityWrapper<HuihuangchengjiuEntity>().in("huihuangchengjiu_uuid_number", seachFields.get("huihuangchengjiuUuidNumber")).eq("huihuangchengjiu_delete", 1));
                        if(huihuangchengjiuEntities_huihuangchengjiuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuihuangchengjiuEntity s:huihuangchengjiuEntities_huihuangchengjiuUuidNumber){
                                repeatFields.add(s.getHuihuangchengjiuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [辉煌成就编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huihuangchengjiuService.insertBatch(huihuangchengjiuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huihuangchengjiuService.queryPage(params);

        //字典表数据转换
        List<HuihuangchengjiuView> list =(List<HuihuangchengjiuView>)page.getList();
        for(HuihuangchengjiuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuihuangchengjiuEntity huihuangchengjiu = huihuangchengjiuService.selectById(id);
            if(huihuangchengjiu !=null){

                //点击数量加1
                huihuangchengjiu.setHuihuangchengjiuClicknum(huihuangchengjiu.getHuihuangchengjiuClicknum()+1);
                huihuangchengjiuService.updateById(huihuangchengjiu);

                //entity转view
                HuihuangchengjiuView view = new HuihuangchengjiuView();
                BeanUtils.copyProperties( huihuangchengjiu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuihuangchengjiuEntity huihuangchengjiu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huihuangchengjiu:{}",this.getClass().getName(),huihuangchengjiu.toString());
        Wrapper<HuihuangchengjiuEntity> queryWrapper = new EntityWrapper<HuihuangchengjiuEntity>()
            .eq("huihuangchengjiu_name", huihuangchengjiu.getHuihuangchengjiuName())
            .eq("huihuangchengjiu_uuid_number", huihuangchengjiu.getHuihuangchengjiuUuidNumber())
            .eq("huihuangchengjiu_types", huihuangchengjiu.getHuihuangchengjiuTypes())
            .eq("huihuangchengjiu_clicknum", huihuangchengjiu.getHuihuangchengjiuClicknum())
            .eq("shangxia_types", huihuangchengjiu.getShangxiaTypes())
            .eq("huihuangchengjiu_delete", huihuangchengjiu.getHuihuangchengjiuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuihuangchengjiuEntity huihuangchengjiuEntity = huihuangchengjiuService.selectOne(queryWrapper);
        if(huihuangchengjiuEntity==null){
            huihuangchengjiu.setHuihuangchengjiuDelete(1);
            huihuangchengjiu.setCreateTime(new Date());
        huihuangchengjiuService.insert(huihuangchengjiu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
