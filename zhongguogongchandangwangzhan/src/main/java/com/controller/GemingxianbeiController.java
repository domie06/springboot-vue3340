
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
 * 革命先辈
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gemingxianbei")
public class GemingxianbeiController {
    private static final Logger logger = LoggerFactory.getLogger(GemingxianbeiController.class);

    @Autowired
    private GemingxianbeiService gemingxianbeiService;


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
        params.put("gemingxianbeiDeleteStart",1);params.put("gemingxianbeiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gemingxianbeiService.queryPage(params);

        //字典表数据转换
        List<GemingxianbeiView> list =(List<GemingxianbeiView>)page.getList();
        for(GemingxianbeiView c:list){
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
        GemingxianbeiEntity gemingxianbei = gemingxianbeiService.selectById(id);
        if(gemingxianbei !=null){
            //entity转view
            GemingxianbeiView view = new GemingxianbeiView();
            BeanUtils.copyProperties( gemingxianbei , view );//把实体数据重构到view中

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
    public R save(@RequestBody GemingxianbeiEntity gemingxianbei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gemingxianbei:{}",this.getClass().getName(),gemingxianbei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GemingxianbeiEntity> queryWrapper = new EntityWrapper<GemingxianbeiEntity>()
            .eq("gemingxianbei_name", gemingxianbei.getGemingxianbeiName())
            .eq("gemingxianbei_uuid_number", gemingxianbei.getGemingxianbeiUuidNumber())
            .eq("gemingxianbei_shengchen", gemingxianbei.getGemingxianbeiShengchen())
            .eq("gemingxianbei_jiri", gemingxianbei.getGemingxianbeiJiri())
            .eq("gemingxianbei_zhuzhi", gemingxianbei.getGemingxianbeiZhuzhi())
            .eq("gemingxianbei_types", gemingxianbei.getGemingxianbeiTypes())
            .eq("gemingxianbei_clicknum", gemingxianbei.getGemingxianbeiClicknum())
            .eq("shangxia_types", gemingxianbei.getShangxiaTypes())
            .eq("gemingxianbei_delete", gemingxianbei.getGemingxianbeiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GemingxianbeiEntity gemingxianbeiEntity = gemingxianbeiService.selectOne(queryWrapper);
        if(gemingxianbeiEntity==null){
            gemingxianbei.setGemingxianbeiClicknum(1);
            gemingxianbei.setShangxiaTypes(1);
            gemingxianbei.setGemingxianbeiDelete(1);
            gemingxianbei.setCreateTime(new Date());
            gemingxianbeiService.insert(gemingxianbei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GemingxianbeiEntity gemingxianbei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gemingxianbei:{}",this.getClass().getName(),gemingxianbei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GemingxianbeiEntity> queryWrapper = new EntityWrapper<GemingxianbeiEntity>()
            .notIn("id",gemingxianbei.getId())
            .andNew()
            .eq("gemingxianbei_name", gemingxianbei.getGemingxianbeiName())
            .eq("gemingxianbei_uuid_number", gemingxianbei.getGemingxianbeiUuidNumber())
            .eq("gemingxianbei_shengchen", gemingxianbei.getGemingxianbeiShengchen())
            .eq("gemingxianbei_jiri", gemingxianbei.getGemingxianbeiJiri())
            .eq("gemingxianbei_zhuzhi", gemingxianbei.getGemingxianbeiZhuzhi())
            .eq("gemingxianbei_types", gemingxianbei.getGemingxianbeiTypes())
            .eq("gemingxianbei_clicknum", gemingxianbei.getGemingxianbeiClicknum())
            .eq("shangxia_types", gemingxianbei.getShangxiaTypes())
            .eq("gemingxianbei_delete", gemingxianbei.getGemingxianbeiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GemingxianbeiEntity gemingxianbeiEntity = gemingxianbeiService.selectOne(queryWrapper);
        if("".equals(gemingxianbei.getGemingxianbeiPhoto()) || "null".equals(gemingxianbei.getGemingxianbeiPhoto())){
                gemingxianbei.setGemingxianbeiPhoto(null);
        }
        if("".equals(gemingxianbei.getGemingxianbeiFile()) || "null".equals(gemingxianbei.getGemingxianbeiFile())){
                gemingxianbei.setGemingxianbeiFile(null);
        }
        if(gemingxianbeiEntity==null){
            gemingxianbeiService.updateById(gemingxianbei);//根据id更新
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
        ArrayList<GemingxianbeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GemingxianbeiEntity gemingxianbeiEntity = new GemingxianbeiEntity();
            gemingxianbeiEntity.setId(id);
            gemingxianbeiEntity.setGemingxianbeiDelete(2);
            list.add(gemingxianbeiEntity);
        }
        if(list != null && list.size() >0){
            gemingxianbeiService.updateBatchById(list);
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
            List<GemingxianbeiEntity> gemingxianbeiList = new ArrayList<>();//上传的东西
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
                            GemingxianbeiEntity gemingxianbeiEntity = new GemingxianbeiEntity();
//                            gemingxianbeiEntity.setGemingxianbeiName(data.get(0));                    //革命先辈名称 要改的
//                            gemingxianbeiEntity.setGemingxianbeiUuidNumber(data.get(0));                    //革命先辈编号 要改的
//                            gemingxianbeiEntity.setGemingxianbeiShengchen(data.get(0));                    //先辈生辰 要改的
//                            gemingxianbeiEntity.setGemingxianbeiJiri(data.get(0));                    //先辈忌日 要改的
//                            gemingxianbeiEntity.setGemingxianbeiZhuzhi(data.get(0));                    //家庭住址 要改的
//                            gemingxianbeiEntity.setGemingxianbeiPhoto("");//详情和图片
//                            gemingxianbeiEntity.setGemingxianbeiTypes(Integer.valueOf(data.get(0)));   //革命先辈类型 要改的
//                            gemingxianbeiEntity.setGemingxianbeiFile(data.get(0));                    //相关资料 要改的
//                            gemingxianbeiEntity.setGemingxianbeiClicknum(Integer.valueOf(data.get(0)));   //先辈热度 要改的
//                            gemingxianbeiEntity.setGemingxianbeiContent("");//详情和图片
//                            gemingxianbeiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            gemingxianbeiEntity.setGemingxianbeiDelete(1);//逻辑删除字段
//                            gemingxianbeiEntity.setCreateTime(date);//时间
                            gemingxianbeiList.add(gemingxianbeiEntity);


                            //把要查询是否重复的字段放入map中
                                //革命先辈编号
                                if(seachFields.containsKey("gemingxianbeiUuidNumber")){
                                    List<String> gemingxianbeiUuidNumber = seachFields.get("gemingxianbeiUuidNumber");
                                    gemingxianbeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gemingxianbeiUuidNumber = new ArrayList<>();
                                    gemingxianbeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gemingxianbeiUuidNumber",gemingxianbeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //革命先辈编号
                        List<GemingxianbeiEntity> gemingxianbeiEntities_gemingxianbeiUuidNumber = gemingxianbeiService.selectList(new EntityWrapper<GemingxianbeiEntity>().in("gemingxianbei_uuid_number", seachFields.get("gemingxianbeiUuidNumber")).eq("gemingxianbei_delete", 1));
                        if(gemingxianbeiEntities_gemingxianbeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GemingxianbeiEntity s:gemingxianbeiEntities_gemingxianbeiUuidNumber){
                                repeatFields.add(s.getGemingxianbeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [革命先辈编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gemingxianbeiService.insertBatch(gemingxianbeiList);
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
        PageUtils page = gemingxianbeiService.queryPage(params);

        //字典表数据转换
        List<GemingxianbeiView> list =(List<GemingxianbeiView>)page.getList();
        for(GemingxianbeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GemingxianbeiEntity gemingxianbei = gemingxianbeiService.selectById(id);
            if(gemingxianbei !=null){

                //点击数量加1
                gemingxianbei.setGemingxianbeiClicknum(gemingxianbei.getGemingxianbeiClicknum()+1);
                gemingxianbeiService.updateById(gemingxianbei);

                //entity转view
                GemingxianbeiView view = new GemingxianbeiView();
                BeanUtils.copyProperties( gemingxianbei , view );//把实体数据重构到view中

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
    public R add(@RequestBody GemingxianbeiEntity gemingxianbei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gemingxianbei:{}",this.getClass().getName(),gemingxianbei.toString());
        Wrapper<GemingxianbeiEntity> queryWrapper = new EntityWrapper<GemingxianbeiEntity>()
            .eq("gemingxianbei_name", gemingxianbei.getGemingxianbeiName())
            .eq("gemingxianbei_uuid_number", gemingxianbei.getGemingxianbeiUuidNumber())
            .eq("gemingxianbei_shengchen", gemingxianbei.getGemingxianbeiShengchen())
            .eq("gemingxianbei_jiri", gemingxianbei.getGemingxianbeiJiri())
            .eq("gemingxianbei_zhuzhi", gemingxianbei.getGemingxianbeiZhuzhi())
            .eq("gemingxianbei_types", gemingxianbei.getGemingxianbeiTypes())
            .eq("gemingxianbei_clicknum", gemingxianbei.getGemingxianbeiClicknum())
            .eq("shangxia_types", gemingxianbei.getShangxiaTypes())
            .eq("gemingxianbei_delete", gemingxianbei.getGemingxianbeiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GemingxianbeiEntity gemingxianbeiEntity = gemingxianbeiService.selectOne(queryWrapper);
        if(gemingxianbeiEntity==null){
            gemingxianbei.setGemingxianbeiDelete(1);
            gemingxianbei.setCreateTime(new Date());
        gemingxianbeiService.insert(gemingxianbei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
