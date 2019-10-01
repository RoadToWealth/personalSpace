package hzc.com.controller;

import com.alibaba.fastjson.JSON;
import hzc.com.model.SysUser;
import hzc.com.service.SysUserService;
import hzc.com.utils.JsonStringUtil;
import hzc.com.utils.RandomValidateCodeUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：后台登录控制层
 * @auther: HuangZhiCheng
 * @date: 2018/6/25 16:05
 */
@Controller
@RequestMapping(value = "/")
public class LoginController{

    Logger log= Logger.getLogger(LoginController.class);

   @Autowired
   private SysUserService sysUserService;

    /**
     * 登录跳转 get请求
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
      return  new ModelAndView("sys/login");
    }

    /**
     * 校验登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login_in")
    public String validateLogin(HttpServletRequest request,String username,String password,String verify,Boolean rememberMe){
        log.info("控制层 --输入信息：username:"+username+"  password:"+password+" verify:"+verify+"  rememberMe:"+rememberMe);
        //声明返回属性
        Map<String,Object> returnMap=new HashMap<String,Object>();
        returnMap.put("code","0001"); //失败
        returnMap.put("msg","");

        //校验前端传过来的参数正确性
        if(username==null || password==null || verify==null){
            returnMap.put("msg","参数异常，检查是否是异常入侵！");
            return JsonStringUtil.MapToString(returnMap);
        }
        //验证验证码是否正确
         String verifyCode=String.valueOf(request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY));
        log.info("获取session中的验证码："+verifyCode);
        if(!verifyCode.toLowerCase().equals(verify.toLowerCase())){
            returnMap.put("msg","验证码输入有误！");
            return JsonStringUtil.MapToString(returnMap);
        }

        //shiro 验证
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //修改登录信息
            SysUser user=(SysUser) SecurityUtils.getSubject().getSession().getAttribute("userSession");
            log.info("登录信息："+ JSON.toJSONString(user));
            SysUser params=new SysUser(user.getLoginCount(),user.getLastLoginDate(),user.getId());
            sysUserService.updateByPrimaryKeySelective(params);

        } catch (IncorrectCredentialsException ice) {//密码错误
            log.info("密码输入有误，请检查大小写！");
            returnMap.put("msg","密码输入有误，请检查大小写！");
            return JsonStringUtil.MapToString(returnMap);
        }catch (UnknownAccountException e) { //账号不存在
            log.info("账户不存在，请先注册！");
            returnMap.put("msg","账户不存在，请先注册！");
            return JsonStringUtil.MapToString(returnMap);
        }catch (LockedAccountException e) {
            log.info("账户已被锁定，请联系管理员!");
            returnMap.put("msg","账户已被锁定，请联系管理员!");
            return JsonStringUtil.MapToString(returnMap);
        } catch (ExcessiveAttemptsException eae) {
            log.info("账户登录错误次数过多，已被锁定！");
            returnMap.put("msg","账户登录错误次数过多，已被锁定！");
            return JsonStringUtil.MapToString(returnMap);
        } catch (AuthenticationException e) {//登录异常
            log.info("登录其他错误异常！");
            returnMap.put("msg", e.getMessage());
            return JsonStringUtil.MapToString(returnMap);
        }

        returnMap.put("code","0000"); //成功
        returnMap.put("msg","恭喜 登录成功！");
        return JsonStringUtil.MapToString(returnMap);
    }

    /**
     * 获取验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            log.error("获取验证码失败>>>>   ", e);
        }
    }



}
