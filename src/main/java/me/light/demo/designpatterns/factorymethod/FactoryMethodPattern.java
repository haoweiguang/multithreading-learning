package me.light.demo.designpatterns.factorymethod;

/**
 * @author light.hao
 * @date 2020/1/5 10:55 PM
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        //客户定了Model S
        ShangHaiFactory factoryModelS = new ShangHaiModelSFactory();
        factoryModelS.manufacture().show();


        //客户定了Model 3
        ShangHaiFactory factoryModel3 = new ShangHaiModel3Factory();
        factoryModel3.manufacture().show();

        /**如果用户想要一辆Model Y...
         *
         * 这个时候就需要添加一个ModelY的产品类和对应的工厂
         *
         * 产品类：TeslaModelY
         * 工厂方法：ShangHaiModelYFactory
         *
         **/
    }
}
