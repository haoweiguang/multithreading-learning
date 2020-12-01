package me.light.demo.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 发布者
 *
 * @author light.hao
 * @date 2020/9/25 11:26 上午
 */
public class DemoPublisher {

    public void asyncPublish(Object object) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20,
                30, TimeUnit.SECONDS, workQueue);
        AsyncEventBus asyncEventBus = new AsyncEventBus(executor);

        asyncEventBus.post(object);
    }
}
