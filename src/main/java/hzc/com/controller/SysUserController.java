package hzc.com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzc.com.model.SysUser;
import hzc.com.service.SysUserService;
import hzc.com.utils.ConfigProperties;
import hzc.com.utils.ShiroPassWordUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 描述：系统用户控制层
 * @auther: HuangZhiCheng
 * @date: 2018/8/7 16:48
 */
@Controller
@RequestMapping(value = "/user")
public class SysUserController {

    private Logger log=Logger.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转到系统用户首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "sys/user/list";
    }

    /**
     * 跳转到系统用户添加页面
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "sys/user/add";
    }

    /**
     * 跳转去系统用户修改页面
     * @return
     */
    @RequestMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable int id,Map <String, Object> map){
        //根据参数获取系统用户信息
        SysUser sysUser=new SysUser();
        sysUser.setId(id);
        sysUser= sysUserService.findUserAll(sysUser).get(0);
        map.put("user",sysUser);

        return "sys/user/edit";
    }

    /**
     * 获取系统用户信息
     * @param sysUser  用户信息
     * @param pageNum  当前页数
     * @param pageSize 展示行数
     * @return
     */
    @RequestMapping(value = "/query/{pageNum}/{pageSize}",method = RequestMethod.POST)
    @ResponseBody
    public Object query(@RequestBody SysUser sysUser,@PathVariable int pageNum,@PathVariable int pageSize){
        //请求参数
        log.info("请求参数："+ JSON.toJSONString(sysUser));
        //分页
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("create_date desc");
        //获取系统用户信息列表
        List<SysUser>  userList=sysUserService.findUserAll(sysUser);
        //返回结果
        JSONObject obj=new JSONObject();
        obj.put("status","1" );
        obj.put("data",new PageInfo<SysUser>(userList));

        return obj;
    }

    /**
     * 添加用户信息
     * @param sysUser
     * @return 0 添加成功 1添加失败
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody SysUser sysUser){
        //请求参数
        log.info("请求参数："+ JSON.toJSONString(sysUser));
        //添加默认密码
       Map<String,Object> resultMap= ShiroPassWordUtil.findEncryption(ConfigProperties.getProperty("dufaultPassword"));
        sysUser.setSalt(String.valueOf(resultMap.get("salt")));
        sysUser.setPassword(String.valueOf(resultMap.get("ciphertext")));
        log.info("添加用户信息："+JSON.toJSONString(sysUser));
        try {
            sysUserService.insertSysUser(sysUser);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Object edit(@RequestBody SysUser sysUser){
        //请求参数
        log.info("请求参数："+ JSON.toJSONString(sysUser));
        //锁定用户能够修改的字段
        SysUser user=new SysUser(sysUser.getId(),sysUser.getUserName(),sysUser.getPhone(),sysUser.getEmail(),sysUser.getGender(),sysUser.getAddress(),sysUser.getNote());
        try {
            sysUserService.updateByPrimaryKeySelective(user);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    /**
     * 逻辑删除用户信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(@RequestBody SysUser sysUser){
        //请求参数
        log.info("del请求参数："+ JSON.toJSONString(sysUser));
        //锁定用户能够修改的字段
        SysUser user=new SysUser();
        user.setId(sysUser.getId());
        user.setIsDeleted(1);
        try {
            sysUserService.updateByPrimaryKeySelective(user);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }





}
