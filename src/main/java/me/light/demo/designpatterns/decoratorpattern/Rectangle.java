package me.light.demo.designpatterns.decoratorpattern;

/**
 * @author light.hao
 * @date 2019/12/11 5:19 PM
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
