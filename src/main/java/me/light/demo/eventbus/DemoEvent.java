package me.light.demo.eventbus;

/**
 * @author light.hao
 * @date 2020/9/25 10:56 上午
 * 事件
 */
public class DemoEvent {
    private String demo;

    public DemoEvent(String demo) {
        this.demo = demo;
    }

    public String getDemo() {
        return this.demo;
    }
}
