package me.light.demo.designpatterns.factorymethod;

/**
 * @author light.hao
 * @date 2020/1/5 10:54 PM
 */
public class ShangHaiModelSFactory extends ShangHaiFactory {
    @Override
    public Tesla manufacture() {
        return new TeslaModelS();
    }
}
