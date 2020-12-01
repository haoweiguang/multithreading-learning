package me.light.demo.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.greenrobot.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author light.hao
 * @date 2020/9/25 1:57 下午
 */
public class DemoService {
    private AsyncEventBus eventBus;

    public DemoService() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20,
                30, TimeUnit.SECONDS, workQueue);
        eventBus = new AsyncEventBus(executor);
    }

    public void post() {
        //向订阅者发送消息
        DemoEvent demoEvent = new DemoEvent("light");
        eventBus.post(demoEvent);
    }

    public void register() {
        eventBus.register(new DemoSubscriber());
    }
}
