
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
 * 历届会议
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lijiehuiyi")
public class LijiehuiyiController {
    private static final Logger logger = LoggerFactory.getLogger(LijiehuiyiController.class);

    @Autowired
    private LijiehuiyiService lijiehuiyiService;


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
        params.put("lijiehuiyiDeleteStart",1);params.put("lijiehuiyiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = lijiehuiyiService.queryPage(params);

        //字典表数据转换
        List<LijiehuiyiView> list =(List<LijiehuiyiView>)page.getList();
        for(LijiehuiyiView c:list){
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
        LijiehuiyiEntity lijiehuiyi = lijiehuiyiService.selectById(id);
        if(lijiehuiyi !=null){
            //entity转view
            LijiehuiyiView view = new LijiehuiyiView();
            BeanUtils.copyProperties( lijiehuiyi , view );//把实体数据重构到view中

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
    public R save(@RequestBody LijiehuiyiEntity lijiehuiyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lijiehuiyi:{}",this.getClass().getName(),lijiehuiyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LijiehuiyiEntity> queryWrapper = new EntityWrapper<LijiehuiyiEntity>()
            .eq("lijiehuiyi_name", lijiehuiyi.getLijiehuiyiName())
            .eq("lijiehuiyi_uuid_number", lijiehuiyi.getLijiehuiyiUuidNumber())
            .eq("lijiehuiyi_address", lijiehuiyi.getLijiehuiyiAddress())
            .eq("lijiehuiyi_zhaiyao", lijiehuiyi.getLijiehuiyiZhaiyao())
            .eq("lijiehuiyi_types", lijiehuiyi.getLijiehuiyiTypes())
            .eq("huiyileixing_types", lijiehuiyi.getHuiyileixingTypes())
            .eq("shangxia_types", lijiehuiyi.getShangxiaTypes())
            .eq("lijiehuiyi_delete", lijiehuiyi.getLijiehuiyiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LijiehuiyiEntity lijiehuiyiEntity = lijiehuiyiService.selectOne(queryWrapper);
        if(lijiehuiyiEntity==null){
            lijiehuiyi.setShangxiaTypes(1);
            lijiehuiyi.setLijiehuiyiDelete(1);
            lijiehuiyi.setCreateTime(new Date());
            lijiehuiyiService.insert(lijiehuiyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LijiehuiyiEntity lijiehuiyi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,lijiehuiyi:{}",this.getClass().getName(),lijiehuiyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<LijiehuiyiEntity> queryWrapper = new EntityWrapper<LijiehuiyiEntity>()
            .notIn("id",lijiehuiyi.getId())
            .andNew()
            .eq("lijiehuiyi_name", lijiehuiyi.getLijiehuiyiName())
            .eq("lijiehuiyi_uuid_number", lijiehuiyi.getLijiehuiyiUuidNumber())
            .eq("lijiehuiyi_address", lijiehuiyi.getLijiehuiyiAddress())
            .eq("lijiehuiyi_zhaiyao", lijiehuiyi.getLijiehuiyiZhaiyao())
            .eq("lijiehuiyi_types", lijiehuiyi.getLijiehuiyiTypes())
            .eq("huiyileixing_types", lijiehuiyi.getHuiyileixingTypes())
            .eq("shangxia_types", lijiehuiyi.getShangxiaTypes())
            .eq("lijiehuiyi_delete", lijiehuiyi.getLijiehuiyiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LijiehuiyiEntity lijiehuiyiEntity = lijiehuiyiService.selectOne(queryWrapper);
        if("".equals(lijiehuiyi.getLijiehuiyiPhoto()) || "null".equals(lijiehuiyi.getLijiehuiyiPhoto())){
                lijiehuiyi.setLijiehuiyiPhoto(null);
        }
        if("".equals(lijiehuiyi.getLijiehuiyiFile()) || "null".equals(lijiehuiyi.getLijiehuiyiFile())){
                lijiehuiyi.setLijiehuiyiFile(null);
        }
        if(lijiehuiyiEntity==null){
            lijiehuiyiService.updateById(lijiehuiyi);//根据id更新
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
        ArrayList<LijiehuiyiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LijiehuiyiEntity lijiehuiyiEntity = new LijiehuiyiEntity();
            lijiehuiyiEntity.setId(id);
            lijiehuiyiEntity.setLijiehuiyiDelete(2);
            list.add(lijiehuiyiEntity);
        }
        if(list != null && list.size() >0){
            lijiehuiyiService.updateBatchById(list);
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
            List<LijiehuiyiEntity> lijiehuiyiList = new ArrayList<>();//上传的东西
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
                            LijiehuiyiEntity lijiehuiyiEntity = new LijiehuiyiEntity();
//                            lijiehuiyiEntity.setLijiehuiyiName(data.get(0));                    //历届会议名称 要改的
//                            lijiehuiyiEntity.setLijiehuiyiUuidNumber(data.get(0));                    //历届会议编号 要改的
//                            lijiehuiyiEntity.setLijiehuiyiPhoto("");//详情和图片
//                            lijiehuiyiEntity.setLijiehuiyiAddress(data.get(0));                    //开会地点 要改的
//                            lijiehuiyiEntity.setLijiehuiyiTime(sdf.parse(data.get(0)));          //开会时间 要改的
//                            lijiehuiyiEntity.setLijiehuiyiZhaiyao(data.get(0));                    //开会摘要 要改的
//                            lijiehuiyiEntity.setLijiehuiyiTypes(Integer.valueOf(data.get(0)));   //几大会议 要改的
//                            lijiehuiyiEntity.setHuiyileixingTypes(Integer.valueOf(data.get(0)));   //会议类型 要改的
//                            lijiehuiyiEntity.setLijiehuiyiFile(data.get(0));                    //会议文件 要改的
//                            lijiehuiyiEntity.setLijiehuiyiContent("");//详情和图片
//                            lijiehuiyiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            lijiehuiyiEntity.setLijiehuiyiDelete(1);//逻辑删除字段
//                            lijiehuiyiEntity.setCreateTime(date);//时间
                            lijiehuiyiList.add(lijiehuiyiEntity);


                            //把要查询是否重复的字段放入map中
                                //历届会议编号
                                if(seachFields.containsKey("lijiehuiyiUuidNumber")){
                                    List<String> lijiehuiyiUuidNumber = seachFields.get("lijiehuiyiUuidNumber");
                                    lijiehuiyiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> lijiehuiyiUuidNumber = new ArrayList<>();
                                    lijiehuiyiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("lijiehuiyiUuidNumber",lijiehuiyiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //历届会议编号
                        List<LijiehuiyiEntity> lijiehuiyiEntities_lijiehuiyiUuidNumber = lijiehuiyiService.selectList(new EntityWrapper<LijiehuiyiEntity>().in("lijiehuiyi_uuid_number", seachFields.get("lijiehuiyiUuidNumber")).eq("lijiehuiyi_delete", 1));
                        if(lijiehuiyiEntities_lijiehuiyiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LijiehuiyiEntity s:lijiehuiyiEntities_lijiehuiyiUuidNumber){
                                repeatFields.add(s.getLijiehuiyiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [历届会议编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        lijiehuiyiService.insertBatch(lijiehuiyiList);
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
        PageUtils page = lijiehuiyiService.queryPage(params);

        //字典表数据转换
        List<LijiehuiyiView> list =(List<LijiehuiyiView>)page.getList();
        for(LijiehuiyiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LijiehuiyiEntity lijiehuiyi = lijiehuiyiService.selectById(id);
            if(lijiehuiyi !=null){


                //entity转view
                LijiehuiyiView view = new LijiehuiyiView();
                BeanUtils.copyProperties( lijiehuiyi , view );//把实体数据重构到view中

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
    public R add(@RequestBody LijiehuiyiEntity lijiehuiyi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,lijiehuiyi:{}",this.getClass().getName(),lijiehuiyi.toString());
        Wrapper<LijiehuiyiEntity> queryWrapper = new EntityWrapper<LijiehuiyiEntity>()
            .eq("lijiehuiyi_name", lijiehuiyi.getLijiehuiyiName())
            .eq("lijiehuiyi_uuid_number", lijiehuiyi.getLijiehuiyiUuidNumber())
            .eq("lijiehuiyi_address", lijiehuiyi.getLijiehuiyiAddress())
            .eq("lijiehuiyi_zhaiyao", lijiehuiyi.getLijiehuiyiZhaiyao())
            .eq("lijiehuiyi_types", lijiehuiyi.getLijiehuiyiTypes())
            .eq("huiyileixing_types", lijiehuiyi.getHuiyileixingTypes())
            .eq("shangxia_types", lijiehuiyi.getShangxiaTypes())
            .eq("lijiehuiyi_delete", lijiehuiyi.getLijiehuiyiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LijiehuiyiEntity lijiehuiyiEntity = lijiehuiyiService.selectOne(queryWrapper);
        if(lijiehuiyiEntity==null){
            lijiehuiyi.setLijiehuiyiDelete(1);
            lijiehuiyi.setCreateTime(new Date());
        lijiehuiyiService.insert(lijiehuiyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
