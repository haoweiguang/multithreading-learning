package me.light.demo.designpatterns.simplefactory;

/**
 * 简单工厂
 *
 * @author light.hao
 * @date 2020/1/19 10:55 AM
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
