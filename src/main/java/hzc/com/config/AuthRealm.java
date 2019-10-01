package hzc.com.config;


import com.alibaba.fastjson.JSON;
import hzc.com.model.SysUser;
import hzc.com.service.SysUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 描述：自定义shiro Realm 做用户认证、权限管理
 * @auther: HuangZhiCheng
 * @date: 2018/6/29 9:51
 */
public class AuthRealm  extends AuthorizingRealm{

    private Logger log=Logger.getLogger(AuthRealm.class);

    @Autowired
    private SysUserService sysUserService;


    /**
     * 认证登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户
        String username=String.valueOf(token.getPrincipal());
        log.info("认证登录doGetAuthenticationInfo...."+username);
        //获取用户信息
        SysUser sysUser= sysUserService.findUserCode(username);
        log.info("打印用户信息："+ JSON.toJSONString(sysUser));
        //判断账户是否存在
        if(sysUser==null){
            // 抛出 帐号找不到异常
            throw new UnknownAccountException();
        }
        //判断账户是否被锁定
        if(sysUser.getLocked() == 1){
            // 抛出 帐号锁定异常
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),getName());

        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", sysUser);
        session.setAttribute("userSessionId", sysUser.getId());

        return authenticationInfo;
    }

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

}
