package me.light.demo.designpatterns.decoratorpattern;

/**
 * @author light.hao
 * @date 2019/12/11 5:21 PM
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }

}
