package hzc.com.utils;

/**
 * @Auther: HuangZhicheng
 * @Date: 2019/10/24 15:43
 * @Description: 字符串工具类
 */
public class StringUtil {

    /**
     * 其他数据类型转字符串
     * @param obj 其他数据
     * @return
     */
    public static String getStr(Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return "";
        }
    }

    /**
     * 判断是否为空
     * @param obj
     * @return true 空 false 非空
     */
    public static Boolean isEmpty(String obj) {
        if (obj == null || "".equals(obj) || "null".equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
     */
    public  static String upperFrist(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    /**
     * 将字符串的首字母转小写
     * @param str 需要转换的字符串
     * @return
     */
    public static String lowerFrist(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
    }

    /**
     * 拆字符串[例子：userName -> USER_ID]
     * @param str
     * @return
     */
    public static String characterString(String str){
        char[] cs=str.toCharArray();
        StringBuffer buffer=new StringBuffer();
        for (char ab:cs){
            //判断大小写
            if(Character.isUpperCase(ab)){
                buffer.append("_"+Character.toLowerCase(ab));
            }else{
                buffer.append(ab);
            }
        }
        return buffer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String str="userId";
        System.out.println(characterString(str));
    }

}
