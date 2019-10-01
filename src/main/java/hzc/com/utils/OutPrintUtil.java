package hzc.com.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：输出工具类
 * @auther: HuangZhiCheng
 * @date: 2019/1/10 14:54
 */
public class OutPrintUtil {

    /**
     * 输出结果
     * @param response
     * @param value
     */
    protected void renderJsonDone(HttpServletResponse response, final Object value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("statusCode", 200);
        map.put("result", value);
        String jsonText = JSON.toJSONString(map);

        PrintWriter writer = null;
        try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            response.setContentType("text/javascript;charset=utf-8");
            writer = response.getWriter();
            writer.write(jsonText);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
