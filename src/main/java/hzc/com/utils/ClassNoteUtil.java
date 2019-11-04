package hzc.com.utils;

import com.alibaba.fastjson.JSON;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: HuangZhicheng
 * @Date: 2019/10/24 15:22
 * @Description: 获取注释内容公共方法
 */
public class ClassNoteUtil {
    private static Logger logger=Logger.getLogger(ClassNoteUtil.class);

    private static RootDoc rootDoc;
    public static  class Doclet {
        public static boolean start(RootDoc rootDoc) {
            ClassNoteUtil.rootDoc = rootDoc;
            return true;
        }
    }

    /**
     * 获取实体类get方法注释内容
     * @param classCompileCatalog class 文件编译目录[绝对路径]
     * @param classFile 单个java类文件路径[绝对路径]
     * @return 示例：{"classMethod":"请求方法","httpUrl":"请求地址","ip":"ip地址","id":"主键ID","httpMethod":"请求方式","params":"请求参数","createDate":"创建时间"}
     */
    public static Map<String,String> findGetDoc(String  classCompileCatalog,String classFile){
        Map<String,String> dataMap=new HashMap<>(16);
        //javaDoc加载解析类信息
        com.sun.tools.javadoc.Main.execute(new String[] {"-doclet", Doclet.class.getName(), "-encoding","utf-8","-classpath", classCompileCatalog,classFile});
        //遍历获取属性方法注释
        ClassDoc[] classes = rootDoc.classes();
        for(ClassDoc classDoc : classes){
            logger.info(classDoc.name()+"类的注释:"+classDoc.commentText());
            MethodDoc[] methodDocs = classDoc.methods();
            for(MethodDoc methodDoc : methodDocs){
                // 打印出方法上的注释
                logger.info("类" +classDoc.name()+","+methodDoc.name()+ "方法注释:" +methodDoc.commentText());
                if(methodDoc.name().substring(0,3).indexOf(Constans.ClassFiled.GET) != Constans.Num.NEGATIVEONE){
                    //获取属性名称
                   String fileName=StringUtil.lowerFrist(methodDoc.name().substring(3));
                   dataMap.put(fileName,methodDoc.commentText());
                }
            }
        }
        return dataMap;
    }


    public static void main(String[] args) {
        String  classCompileCatalog="E:\\博客资料\\personalSpace\\target\\classes";
        String classFile="E:\\博客资料\\personalSpace\\src\\main\\java\\hzc\\com\\model\\SysLogs.java";
        Map<String,String> classFileNoteMap=findGetDoc(classCompileCatalog,classFile);
        System.out.println(JSON.toJSONString(classFileNoteMap));

    }

}
