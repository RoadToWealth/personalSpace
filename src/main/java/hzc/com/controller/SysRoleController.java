package hzc.com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzc.com.model.SysRole;
import hzc.com.service.SysRoleService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述：系统角色控制层
 * @auther: HuangZhiCheng
 * @date: 2018/8/7 16:50
 */
@Controller
@RequestMapping(value = "/role")
public class SysRoleController {
    Logger log=Logger.getLogger(SysRoleController.class);

   @Autowired
   private SysRoleService sysRoleService;

    /**
     * 跳转到系统角色页面
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "sys/role/list";
    }

    /**
     * 获取系统角色信息
     * @param sysRole  角色信息
     * @param pageNum  当前页数
     * @param pageSize 展示行数
     * @return
     */
     @RequestMapping(value = "/query/{pageNum}/{pageSize}",method = RequestMethod.POST)
     @ResponseBody
     public Object query(@RequestBody SysRole sysRole,  @PathVariable int pageNum, @PathVariable int pageSize){
         //请求参数
         log.info("请求参数："+ JSON.toJSONString(sysRole));
         //分页
         PageHelper.startPage(pageNum,pageSize);
         PageHelper.orderBy("create_date desc");
         //获取全部的角色信息
         List<SysRole> list= sysRoleService.findRoleALL(sysRole);

         JSONObject obj=new JSONObject();
         obj.put("status","1" );
         obj.put("data",new PageInfo<SysRole>(list));

         return obj;
     }

    /**
     * 逻辑删除用户信息
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(@RequestBody SysRole sysRole){
        //请求参数
        log.info("del请求参数："+ JSON.toJSONString(sysRole));
        //锁定用户能够修改的字段
        SysRole role=new SysRole();
        role.setId(sysRole.getId());
        role.setAvailable("1");
        try {
            sysRoleService.updateByPrimaryKeySelective(role);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    /**
     * 添加角色信息
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody SysRole sysRole){
       //请求参数
        log.info("del请求参数："+ JSON.toJSONString(sysRole));
        //添加角色信息
        try {
            sysRoleService.saveSysRole(sysRole);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    /**
     * 修改信息
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody SysRole sysRole){
        //请求参数
        log.info("del请求参数："+ JSON.toJSONString(sysRole));
        //锁定用户能够修改的字段
        SysRole role=new SysRole();
        role.setId(sysRole.getId());
        role.setName(sysRole.getName());
        role.setRemark(sysRole.getRemark());
        //添加角色信息
        try {
            sysRoleService.updateByPrimaryKeySelective(role);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }


}
