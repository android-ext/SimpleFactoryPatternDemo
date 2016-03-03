package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 抽象工厂实现类
 * Created by Ext
 * Created at 2016/3/2
 */
public class AddOperationImpl implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
