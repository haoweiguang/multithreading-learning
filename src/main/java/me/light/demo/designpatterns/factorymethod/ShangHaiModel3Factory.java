package me.light.demo.designpatterns.factorymethod;

/**
 * @author light.hao
 * @date 2020/1/5 10:55 PM
 */
public class ShangHaiModel3Factory extends ShangHaiFactory {
    @Override
    public Tesla manufacture() {
        return new TeslaModel3();
    }
}
