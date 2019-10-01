package hzc.com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzc.com.model.SysPermission;
import hzc.com.service.SysPermissionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：资源权限表控制层
 * @auther: HuangZhiCheng
 * @date: 2018/8/8 17:43
 */
@Controller
@RequestMapping(value = "/permission")
public class SysPermissionController {

    private Logger log=Logger.getLogger(SysPermissionController.class);

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 跳转到资源首页
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "sys/permission/list";
    }

    /**
     * 获取系统资源信息
     * @param sysPermission
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/query/{pageNum}/{pageSize}")
    @ResponseBody
    public Object query( @RequestBody SysPermission sysPermission,@PathVariable int pageNum, @PathVariable int pageSize){
        //获取请求参数
        log.info("请求参数："+ JSON.toJSONString(sysPermission));
        //分页插件
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("create_date desc");
        //获取系统资源列表
        List<SysPermission>  permissionList = sysPermissionService.findPermissionList(sysPermission);
        //返回结果
        JSONObject obj=new JSONObject();
        obj.put("status", "1");
        obj.put("data",new PageInfo<SysPermission>(permissionList));

        return obj;
    }

    /**
     * 获取父类菜单
     * @return
     */
    @RequestMapping(value = "/findParentMenu",method = RequestMethod.POST)
    @ResponseBody
    public Object findParentMenu(){
        //获取全部的父类菜单
        SysPermission sysPermission=new SysPermission();
        sysPermission.setParentid(0);
        sysPermission.setType("menu");
        sysPermission.setAvailable("0");
        List<SysPermission>  permissionList = sysPermissionService.findPermissionList(sysPermission);
        log.info("父类菜单："+JSON.toJSONString(permissionList));
        //返回结果
        JSONObject obj=new JSONObject();
        obj.put("status", "1");
        obj.put("data",permissionList);
        return obj;
    }

    /**
     * 添加资源信息
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Object savePermission(@RequestBody SysPermission sysPermission){
        //获取请求参数
        log.info("请求参数："+ JSON.toJSONString(sysPermission));
        try {
            sysPermissionService.insert(sysPermission);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }

    /**
     * 修改资源信息
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePermission(@RequestBody SysPermission sysPermission){
        //获取请求参数
        log.info("请求参数："+ JSON.toJSONString(sysPermission));
        try {
            sysPermissionService.updateByPrimaryKeySelective(sysPermission);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 修改用户状态
     * @param sysPermission
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Object delPermission(@RequestBody SysPermission sysPermission){
        //获取请求参数
        log.info("请求参数："+ JSON.toJSONString(sysPermission));
        try {
            SysPermission ps=new SysPermission();
            ps.setId(sysPermission.getId());
            //判断当条数据的状态 如果是启动则修改为停用，否则反之
            if(sysPermission.getAvailable().equals("0")){
                ps.setAvailable("1");
            }else{
                ps.setAvailable("0");
            }
            sysPermissionService.updateByPrimaryKeySelective(ps);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }



}
