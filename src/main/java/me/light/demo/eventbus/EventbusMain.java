package me.light.demo.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.greenrobot.eventbus.EventBus;

/**
 * @author light.hao
 * @date 2020/9/25 11:08 上午
 */
public class EventbusMain {
    public static void main(String[] args) {
//        DemoPublisher demoPublisher = new DemoPublisher();
//        DemoSubscriber demoSubscriber = new DemoSubscriber();
//        //注册
//        EventBus.getDefault().register(demoSubscriber);
//        //向订阅者发送消息
//        DemoEvent demoEvent = new DemoEvent("light");
//
//        demoPublisher.asyncPublish(demoEvent);

        DemoService demoService = new DemoService();
        demoService.register();
        demoService.post();

    }
}
