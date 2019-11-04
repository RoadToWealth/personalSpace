package hzc.com.mybaties;

import hzc.com.utils.ClassNoteUtil;
import hzc.com.utils.Constans;
import hzc.com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: HuangZhicheng
 * @Date: 2019/10/24 10:09
 * @Description: 根据实体类生成建表语句
 */
public class SqlGenerator {
    private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);

    public static void main(String[] args) {
        //项目编译文件存放目录
        String  classCompileCatalog="E:\\博客资料\\personalSpace\\target\\classes";
        //实体类所在的package在磁盘上的绝对路径
        String packageName = "E:\\博客资料\\personalSpace\\src\\main\\java\\hzc\\com\\model";
        //生成sql的文件夹
        String filePath = "E:/";
        //项目中实体类的路径
        String prefix = "hzc.com.model.";
        String className = "";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className,classCompileCatalog, packageName);
            sqls.append(sql);
        }
        logger.info(sqls.toString());
        StringToSql(sqls.toString(), filePath + "report.sql");

    }

    /**
     * 根据实体类生成建表语句
     * @param className
     * @param classCompileCatalog
     * @param packageName
     * @return
     */
    public static String generateSql(String className,String classCompileCatalog,String packageName){
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            Field[] fields = clz.getDeclaredFields();
            //获取类get方法备注
            Map<String,String> classFileNoteMap= ClassNoteUtil.findGetDoc(classCompileCatalog,packageName+"\\"+className+".java");
            StringBuffer column = new StringBuffer();
            for (Field f : fields) {
                if(!Constans.Sql.ID.equals(f.getName())){
                    column.append(" \n `"+ StringUtil.characterString(f.getName())+"` ")
                          .append(getCenericType(f.getGenericType().toString()))
                          .append("comment '"+classFileNoteMap.get(f.getName())+"'")
                          .append(",");
                }
            }

            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `"+StringUtil.characterString(StringUtil.lowerFrist(className))+"`; ")
                    .append(" \n CREATE TABLE `"+StringUtil.characterString(StringUtil.lowerFrist(className))+"`  (")
                    .append(" \n `id` int(11) NOT NULL AUTO_INCREMENT,")
                    .append(column)
                    .append(" \n PRIMARY KEY (`id`)")
                    .append(" \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;\n\n");
            return sql.toString();
        } catch (ClassNotFoundException e) {
            logger.debug("该类未找到！");
            return null;
        }

    }

    /**
     * 根据字段类型返回sql数据类型
     * @param GenericType
     * @return
     */
    private static String getCenericType(String GenericType) {
        String type=null;
        switch (GenericType){
            case "class java.lang.Integer":
                type=" int ";
                break;
            case "class java.lang.String":
                type=" varchar(50) ";
                break;
            case "class java.util.Date":
                type =" date ";
                break;
            default:
                type=" varchar(50) ";
                break;
        }
        return type;
    }

    /**
     * 获取包下的所有类名称,获取的结果类似于 XXX.java
     * @param packageName
     * @return
     */
    public static List<String> getAllClasses(String packageName){
        List<String> classList = new ArrayList<String>();
        String className="";
        File f = new File(packageName);
        if(f.exists() && f.isDirectory()){
            File[] files = f.listFiles();
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        }else{
            logger.debug("包路径未找到！");
            return null;
        }
    }

    /**
     * 将string 写入sql文件
     * @param str
     * @param path
     */
    public static void StringToSql(String str,String path){
        byte[] sourceByte = str.getBytes();
        if(null != sourceByte){
            try {
                File file = new File(path);     //文件路径（路径+文件名）
                if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();  //关闭文件输出流
                System.out.println("生成成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
