package me.light.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author light.hao
 * @date 2019/11/11 5:36 PM
 */
@SpringBootApplication
public class SpringCloudEurekaApplication {
    public static void main(String[] args) {
        System.out.println("Eureka in");
        SpringApplication.run(SpringCloudEurekaApplication.class, args);
    }
}
