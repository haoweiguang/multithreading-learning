package me.light.demo.designpatterns.iteratorpattern;

/**
 * 迭代器的实现
 *
 * @author light.hao
 * @date 2019/3/22 上午11:06
 */
public class MenuIterator implements Iterator {

    String[] foods;
    int position = 0;

    public MenuIterator(String[] foods) {
        this.foods = foods;
    }

    @Override
    public boolean hasNext() {
        return position != foods.length;
    }

    @Override
    public Object next() {
        String food = foods[position];
        position += 1;
        return food;
    }
}
