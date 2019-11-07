package me.light.demo.designpatterns.iteratorpattern;

/**
 * 测试
 *
 * @author light.hao
 * @date 2019/3/22 上午11:18
 */
public class IteratorTest {
    public static void main(String[] args) {
        ChineseFoodMenu chineseFoodMenu = new ChineseFoodMenu();
        chineseFoodMenu.add("水煮肉片");
        chineseFoodMenu.add("孜然羊肉");
        chineseFoodMenu.add("烧鸡");
        chineseFoodMenu.add("牛肉");

        Iterator iterator = chineseFoodMenu.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
