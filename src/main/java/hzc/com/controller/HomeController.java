package hzc.com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hzc.com.model.SysPermission;
import hzc.com.model.SysUser;
import hzc.com.service.SysPermissionService;
import hzc.com.service.SysUserService;
import hzc.com.utils.ShiroPassWordUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：后台主页控制层
 * @auther: HuangZhiCheng
 * @date: 2018/6/29 17:22
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private Logger log=Logger.getLogger(HomeController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;


    /**
     * 跳转到后台首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Map <String, Object> map){
        //获取到登录用户信息
        SysUser user=(SysUser) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        log.info("信息跳转："+JSON.toJSONString(user));
        map.put("user", user);

        return "sys/home";
    }

    /**
     * 获取菜单列表
     * @return
     */
    @RequestMapping(value = "/menu")
    @ResponseBody
    public Object findMenu(){
        SysPermission sysPermission=null;
        //获取全部菜单
        sysPermission=new SysPermission();
        sysPermission.setType("menu");
        sysPermission.setAvailable("0");
        sysPermission.setIsSortstring("1");
        List<SysPermission> menuList=sysPermissionService.findPermissionList(sysPermission);
        for (SysPermission sp :menuList){
            //获取菜单下的全部功能点
            sysPermission=new SysPermission();
            sysPermission.setParentid(sp.getId());
            sysPermission.setAvailable("0");
            sysPermission.setIsSortstring("1");
            List<SysPermission> funcList=sysPermissionService.findPermissionList(sysPermission);
            //添加到菜单列表
            sp.setFuncList(funcList);
        }
        log.info("菜单列表："+ JSON.toJSONString(menuList));
        return JSON.toJSONString(menuList);
    }

    /**
     * 验证密码是否正确
     * @return
     */
    @RequestMapping(value = "/getPassword")
    @ResponseBody
    public String getPassword(@RequestParam String pw){
        log.info("进入验证密码是否正确........"+pw);
        //获取到登录用户信息
        SysUser user=(SysUser) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        //当前密码加密
        String passwd= ShiroPassWordUtil.encryption(pw, user.getSalt());
        //判断输入密码是否正确
        Map<String,Object> map=new HashMap<>();
        if(user.getPassword().equals(passwd)){
            map.put("valid",true);
        }else{
            map.put("valid",false);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 密码修改
     * @param passwd
     * @return
     */
    @RequestMapping(value = "/pwEdit",method = RequestMethod.POST)
    @ResponseBody
    public Object pwEdit(@RequestBody String passwd){
        //请求参数
        log.info("请求参数："+ passwd);
        passwd = String.valueOf(JSONObject.parseObject(passwd).get("passwd"));
        log.info("请求参数解析："+ passwd);
        //获取到登录用户信息
        SysUser userInfo=(SysUser) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        String pw= ShiroPassWordUtil.encryption(passwd, userInfo.getSalt());
        log.info("salt"+userInfo.getSalt()+"加密前的值："+passwd+" 加密后的值："+pw);
        //锁定用户能够修改的字段
        SysUser user=new SysUser(userInfo.getId(),pw);
        try {
            sysUserService.updateByPrimaryKeySelective(user);
            return "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    /**
     * 跳转到
     * @param map
     * @return
     */
    @RequestMapping(value = "icons",method = RequestMethod.GET)
    public String icons(Map <String, Object> map){
        map.put("tom","1");
       return "sys/tools/icons";
    }

}
