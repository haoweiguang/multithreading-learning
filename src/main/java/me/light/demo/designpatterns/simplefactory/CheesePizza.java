package me.light.demo.designpatterns.simplefactory;

/**
 * 奶酪披萨
 *
 * @author light.hao
 * @date 2020/1/19 10:37 AM
 */
public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}
