
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
 * 光辉历程
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guanghuilicheng")
public class GuanghuilichengController {
    private static final Logger logger = LoggerFactory.getLogger(GuanghuilichengController.class);

    @Autowired
    private GuanghuilichengService guanghuilichengService;


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
        params.put("guanghuilichengDeleteStart",1);params.put("guanghuilichengDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = guanghuilichengService.queryPage(params);

        //字典表数据转换
        List<GuanghuilichengView> list =(List<GuanghuilichengView>)page.getList();
        for(GuanghuilichengView c:list){
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
        GuanghuilichengEntity guanghuilicheng = guanghuilichengService.selectById(id);
        if(guanghuilicheng !=null){
            //entity转view
            GuanghuilichengView view = new GuanghuilichengView();
            BeanUtils.copyProperties( guanghuilicheng , view );//把实体数据重构到view中

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
    public R save(@RequestBody GuanghuilichengEntity guanghuilicheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guanghuilicheng:{}",this.getClass().getName(),guanghuilicheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GuanghuilichengEntity> queryWrapper = new EntityWrapper<GuanghuilichengEntity>()
            .eq("guanghuilicheng_name", guanghuilicheng.getGuanghuilichengName())
            .eq("guanghuilicheng_uuid_number", guanghuilicheng.getGuanghuilichengUuidNumber())
            .eq("guanghuilicheng_types", guanghuilicheng.getGuanghuilichengTypes())
            .eq("guanghuilicheng_clicknum", guanghuilicheng.getGuanghuilichengClicknum())
            .eq("shangxia_types", guanghuilicheng.getShangxiaTypes())
            .eq("guanghuilicheng_delete", guanghuilicheng.getGuanghuilichengDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanghuilichengEntity guanghuilichengEntity = guanghuilichengService.selectOne(queryWrapper);
        if(guanghuilichengEntity==null){
            guanghuilicheng.setGuanghuilichengClicknum(1);
            guanghuilicheng.setShangxiaTypes(1);
            guanghuilicheng.setGuanghuilichengDelete(1);
            guanghuilicheng.setCreateTime(new Date());
            guanghuilichengService.insert(guanghuilicheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuanghuilichengEntity guanghuilicheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,guanghuilicheng:{}",this.getClass().getName(),guanghuilicheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GuanghuilichengEntity> queryWrapper = new EntityWrapper<GuanghuilichengEntity>()
            .notIn("id",guanghuilicheng.getId())
            .andNew()
            .eq("guanghuilicheng_name", guanghuilicheng.getGuanghuilichengName())
            .eq("guanghuilicheng_uuid_number", guanghuilicheng.getGuanghuilichengUuidNumber())
            .eq("guanghuilicheng_types", guanghuilicheng.getGuanghuilichengTypes())
            .eq("guanghuilicheng_clicknum", guanghuilicheng.getGuanghuilichengClicknum())
            .eq("shangxia_types", guanghuilicheng.getShangxiaTypes())
            .eq("guanghuilicheng_delete", guanghuilicheng.getGuanghuilichengDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanghuilichengEntity guanghuilichengEntity = guanghuilichengService.selectOne(queryWrapper);
        if("".equals(guanghuilicheng.getGuanghuilichengPhoto()) || "null".equals(guanghuilicheng.getGuanghuilichengPhoto())){
                guanghuilicheng.setGuanghuilichengPhoto(null);
        }
        if("".equals(guanghuilicheng.getGuanghuilichengFile()) || "null".equals(guanghuilicheng.getGuanghuilichengFile())){
                guanghuilicheng.setGuanghuilichengFile(null);
        }
        if(guanghuilichengEntity==null){
            guanghuilichengService.updateById(guanghuilicheng);//根据id更新
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
        ArrayList<GuanghuilichengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GuanghuilichengEntity guanghuilichengEntity = new GuanghuilichengEntity();
            guanghuilichengEntity.setId(id);
            guanghuilichengEntity.setGuanghuilichengDelete(2);
            list.add(guanghuilichengEntity);
        }
        if(list != null && list.size() >0){
            guanghuilichengService.updateBatchById(list);
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
            List<GuanghuilichengEntity> guanghuilichengList = new ArrayList<>();//上传的东西
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
                            GuanghuilichengEntity guanghuilichengEntity = new GuanghuilichengEntity();
//                            guanghuilichengEntity.setGuanghuilichengName(data.get(0));                    //光辉历程名称 要改的
//                            guanghuilichengEntity.setGuanghuilichengUuidNumber(data.get(0));                    //光辉历程编号 要改的
//                            guanghuilichengEntity.setGuanghuilichengPhoto("");//详情和图片
//                            guanghuilichengEntity.setGuanghuilichengTypes(Integer.valueOf(data.get(0)));   //历程时期 要改的
//                            guanghuilichengEntity.setGuanghuilichengFile(data.get(0));                    //相关文件 要改的
//                            guanghuilichengEntity.setGuanghuilichengClicknum(Integer.valueOf(data.get(0)));   //历程热度 要改的
//                            guanghuilichengEntity.setGuanghuilichengContent("");//详情和图片
//                            guanghuilichengEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            guanghuilichengEntity.setGuanghuilichengDelete(1);//逻辑删除字段
//                            guanghuilichengEntity.setCreateTime(date);//时间
                            guanghuilichengList.add(guanghuilichengEntity);


                            //把要查询是否重复的字段放入map中
                                //光辉历程编号
                                if(seachFields.containsKey("guanghuilichengUuidNumber")){
                                    List<String> guanghuilichengUuidNumber = seachFields.get("guanghuilichengUuidNumber");
                                    guanghuilichengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guanghuilichengUuidNumber = new ArrayList<>();
                                    guanghuilichengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guanghuilichengUuidNumber",guanghuilichengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //光辉历程编号
                        List<GuanghuilichengEntity> guanghuilichengEntities_guanghuilichengUuidNumber = guanghuilichengService.selectList(new EntityWrapper<GuanghuilichengEntity>().in("guanghuilicheng_uuid_number", seachFields.get("guanghuilichengUuidNumber")).eq("guanghuilicheng_delete", 1));
                        if(guanghuilichengEntities_guanghuilichengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuanghuilichengEntity s:guanghuilichengEntities_guanghuilichengUuidNumber){
                                repeatFields.add(s.getGuanghuilichengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [光辉历程编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guanghuilichengService.insertBatch(guanghuilichengList);
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
        PageUtils page = guanghuilichengService.queryPage(params);

        //字典表数据转换
        List<GuanghuilichengView> list =(List<GuanghuilichengView>)page.getList();
        for(GuanghuilichengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuanghuilichengEntity guanghuilicheng = guanghuilichengService.selectById(id);
            if(guanghuilicheng !=null){

                //点击数量加1
                guanghuilicheng.setGuanghuilichengClicknum(guanghuilicheng.getGuanghuilichengClicknum()+1);
                guanghuilichengService.updateById(guanghuilicheng);

                //entity转view
                GuanghuilichengView view = new GuanghuilichengView();
                BeanUtils.copyProperties( guanghuilicheng , view );//把实体数据重构到view中

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
    public R add(@RequestBody GuanghuilichengEntity guanghuilicheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,guanghuilicheng:{}",this.getClass().getName(),guanghuilicheng.toString());
        Wrapper<GuanghuilichengEntity> queryWrapper = new EntityWrapper<GuanghuilichengEntity>()
            .eq("guanghuilicheng_name", guanghuilicheng.getGuanghuilichengName())
            .eq("guanghuilicheng_uuid_number", guanghuilicheng.getGuanghuilichengUuidNumber())
            .eq("guanghuilicheng_types", guanghuilicheng.getGuanghuilichengTypes())
            .eq("guanghuilicheng_clicknum", guanghuilicheng.getGuanghuilichengClicknum())
            .eq("shangxia_types", guanghuilicheng.getShangxiaTypes())
            .eq("guanghuilicheng_delete", guanghuilicheng.getGuanghuilichengDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanghuilichengEntity guanghuilichengEntity = guanghuilichengService.selectOne(queryWrapper);
        if(guanghuilichengEntity==null){
            guanghuilicheng.setGuanghuilichengDelete(1);
            guanghuilicheng.setCreateTime(new Date());
        guanghuilichengService.insert(guanghuilicheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
