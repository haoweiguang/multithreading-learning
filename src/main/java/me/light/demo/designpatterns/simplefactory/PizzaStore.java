package me.light.demo.designpatterns.simplefactory;

/**
 * @author light.hao
 * @date 2020/1/19 10:30 AM
 */
public class PizzaStore {

    public SimplePizzaFactory simpleFactory;

    public PizzaStore(SimplePizzaFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        pizza = simpleFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
