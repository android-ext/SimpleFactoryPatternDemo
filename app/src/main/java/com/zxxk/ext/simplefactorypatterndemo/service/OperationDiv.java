package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 除法操作
 * Created by Ext
 * Created at 2016/3/2
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        return numberA / numberB;
    }
}
