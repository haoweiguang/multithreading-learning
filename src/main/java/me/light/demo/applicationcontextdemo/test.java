package me.light.demo.applicationcontextdemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 上下文
 *
 * @author light.hao
 * @date 2019/3/5 下午6:07
 */
@EnableAutoConfiguration
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        context.getBean("test");
    }
}
