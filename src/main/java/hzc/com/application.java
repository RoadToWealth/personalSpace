package hzc.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：启动类3
 * @auther: HuangZhiCheng
 * @date: 2018/7/5 16:16
 */
@SpringBootApplication
@MapperScan(basePackages = "club.sscai.userservice.user")
public class application {

    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }


}
