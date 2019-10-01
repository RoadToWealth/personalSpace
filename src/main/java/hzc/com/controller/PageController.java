package hzc.com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：页面跳转
 * @auther: HuangZhiCheng
 * @date: 2018/7/18 14:54
 */
@Controller
@RequestMapping(value = "/page")
public class PageController {
    Logger log=Logger.getLogger(PageController.class);

    /**
     * 跳转到页面
     * @param page html 地址名称
     * @return
     */
    @RequestMapping(value = "/{page}")
    public ModelAndView page(@PathVariable String page){
        return new ModelAndView(page);
    }

    /**
     * 跳转到页面
     * @param pageone html 文件夹
     * @param pagetwo html 名称
     * @return
     */
    @RequestMapping(value = "/{pageone}/{pagetwo}")
    public ModelAndView pages(@PathVariable String pageone,@PathVariable String pagetwo){
        return new ModelAndView(pageone+"/"+pagetwo);
    }


}
