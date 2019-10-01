package hzc.com.wx;

import com.alibaba.fastjson.JSONObject;
import hzc.com.utils.HttpUtil;

/**
 * 描述：微信公众号 测试
 * @auther: HuangZhiCheng
 * @date: 2018/6/27 14:52
 */
public class Wxgzh {

    //微信号
    private static  String appID="wx2212ba9ead108d87";
    private static String appsecret="e1f6dc406379b856dd379e4539952305";
    //获取token地址
    private static  String tokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
    //token 值
    private static String token="11_q4yPm5WzIeTYh0gg-ie3OSp9bZFJD-jPacGCFQU9YBGcWjOqzK1qK3lUsAlFHnMDvlSl1tb7teKW8ne1DqUMI9fx2vdiEy_JmRuKoZEIZxbEnhs2lTu65aMTlhHYGzTBSVP3J9GxUjpGSl__HUQjAJAREA";
    //生成菜单地址
    private static String menu="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;

    /**
     * 获取token
     * @return
     */
    public static String getAccess_token(){
        //请问腾讯微信获取token值
        String resData= HttpUtil.get(tokenUrl);
        //将返回字符串
        JSONObject jsonObj= JSONObject.parseObject(resData);
        //判断是否是正确返回
        if(!jsonObj.containsKey("access_token")){
            return null;
        }
        //获取token值
        String token=String.valueOf(jsonObj.get("access_token"));
        return  token;
    }


    /**
     * 执行入口方法
     * @param args
     */
    public static void main(String[] args) {

    }


}
