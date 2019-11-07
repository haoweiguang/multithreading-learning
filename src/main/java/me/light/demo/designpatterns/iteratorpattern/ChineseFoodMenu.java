package me.light.demo.designpatterns.iteratorpattern;

/**
 * menu的实现
 *
 * @author light.hao
 * @date 2019/3/22 上午11:15
 */
public class ChineseFoodMenu implements Menu {

    private String[] foods = new String[4];
    private int position = 0;

    @Override
    public void add(String name) {
        foods[position] = name;
        position += 1;
    }

    @Override
    public Iterator getIterator() {
        return new MenuIterator(this.foods);
    }
}
