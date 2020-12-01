package me.light.demo.projectreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author light.hao
 * @date 2020/8/8 2:01 下午
 */
public class ReactorDemo {
    public static void main(String[] args) {
//        Flux.just("red", "white", "blue")
//                .log()
//                .map(String::toUpperCase)
//                .subscribeOn(Schedulers.parallel())
//                .subscribe(null, 2); //FIXME 旧的方法，不再支持！

//        Mono.just("tom")
//                .map(s -> s.concat("123"))
//                .filter(s -> s.length() > 5)
//                .subscribe(System.out::println);

//        Flux.just("tom", "jack", "allen")
//                .map(s-> s.concat("@qq.com"))
//                .subscribe(System.out::println);


    }
}
