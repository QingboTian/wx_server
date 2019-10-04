package com.main;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WXApplication
 * @Description: SpringBoot入口类
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/26 21:11
 * @Version v1.0
 */
@SpringBootApplication(scanBasePackages = {"com.tqb"})
@MapperScan("com.tqb.*.dao")
@Configuration
public class WXApplication {
    public static void main(String[] args) {
        SpringApplication.run(WXApplication.class, args);
    }
}
