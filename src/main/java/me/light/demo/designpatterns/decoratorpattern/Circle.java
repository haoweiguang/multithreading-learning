package me.light.demo.designpatterns.decoratorpattern;

/**
 * @author light.hao
 * @date 2019/12/11 5:20 PM
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
