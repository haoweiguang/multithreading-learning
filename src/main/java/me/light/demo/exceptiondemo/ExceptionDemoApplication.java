package me.light.demo.exceptiondemo;

/**
 * @author light.hao
 * @date 2020/12/2 11:01 上午
 */
public class ExceptionDemoApplication {
    public static void main(String[] args) {
        RecordStackMessage stackMessage = new RecordStackMessage();
        stackMessage.say();
    }
}
