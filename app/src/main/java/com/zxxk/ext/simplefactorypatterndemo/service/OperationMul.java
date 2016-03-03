package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 乘法操作
 * Created by Ext
 * Created at 2016/3/2
 */
public class OperationMul extends Operation {

    @Override
    public double getResult() {

        return numberA * numberB;
    }
}
