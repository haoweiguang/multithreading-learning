package me.light.demo.designpatterns.simplefactory;

/**
 * @author light.hao
 * @date 2020/1/19 10:46 AM
 */
public class SimplePizzaFactoryTest {
    public static void main(String[] args) {
        SimplePizzaFactory simpleFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simpleFactory);

        Pizza pizza = pizzaStore.orderPizza("pepperoni");
        System.out.println("我们预定了一个" + pizza.getName());
        System.out.println(pizza);


        pizza = pizzaStore.orderPizza("cheese");
        System.out.println("我们预定了一个" + pizza.getName());
        System.out.println(pizza);
    }
}
