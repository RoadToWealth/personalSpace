package hzc.com.utils;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：shiro 手动生成加密密码
 * @auther: HuangZhiCheng
 * @date: 2018/6/29 9:56
 */
public class ShiroPassWordUtil {

   private static  Logger log=Logger.getLogger(ShiroPassWordUtil.class);
    //产生随机盐工具类
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //加密方式
    private static String algorithmName = "md5";
    //加密次数
    private final static int hashIterations = 2;


    /**
     * 指定盐值加密
     * @param source 加密字符串
     * @param salt 指定盐值
     * @return
     */
    public static String encryption(String source,String salt){
        //通过SimpleHash 来进行加密操作
        SimpleHash hash = new SimpleHash(algorithmName, source, ByteSource.Util.bytes(salt),hashIterations);
        return hash.toHex();

    }

    /**
     * 获取加密后的加密信息
     * @param source 加密文本
     * @return
     */
    public static Map<String,Object> findEncryption(String source){
        Map<String,Object> result=new HashMap<String,Object>();
        //获取随机盐
        String salt=randomNumberGenerator.nextBytes().toHex();  //产生随机盐值
        result.put("salt",salt);
        log.info("产生的随机盐："+salt);
        //获取加密后的密码
        log.info("加密文本："+source);
        String ciphertext=encryption(source,salt);
        result.put("ciphertext",ciphertext);
        log.info("加密后的密文：" + ciphertext);
        return result;
    }

    public static void main(String[] args) {
        String password="huang9028";
       String  params= encryption(password,"ZWQxZDM3MTgyNTRjY2IzOTk1NWRhNDVkM2QxMWQ5ODk=");
        log.info("返回结果："+ JSON.toJSONString(params));
    }



}
