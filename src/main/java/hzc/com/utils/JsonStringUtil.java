package hzc.com.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * 描述：JSON字符串转换工具类
 * @auther: HuangZhiCheng
 * @date: 2018/6/28 14:15
 */
public class JsonStringUtil {

    /**
     * 将map 类型转换成JSON字符串
     * @param map
     * @return
     */
    public static String MapToString (Map map){
        return JSON.toJSONString(map);
    }


}
