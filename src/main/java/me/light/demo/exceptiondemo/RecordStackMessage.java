package me.light.demo.exceptiondemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author light.hao
 * @date 2020/12/2 11:03 上午
 */
@Slf4j
public class RecordStackMessage {
    public void say() {
        Long userId = 1000l;
        try {
            throw new IllegalArgumentException("参数错误了");
        } catch (Exception ex) {
            log.error("获取用户信息报错，用户id:{}，{}", userId, ex.getMessage());
            log.error("获取用户信息报错，用户id:{}，{}", userId, ex.getMessage(), ex);
        }
    }
}
