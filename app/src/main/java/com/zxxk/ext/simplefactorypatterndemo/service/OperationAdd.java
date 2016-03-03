package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 加法操作
 * Created by Ext
 * Created at 2016/3/2
 */
public class OperationAdd extends Operation{

    @Override
    public double getResult() {

        return numberA + numberB;
    }
}
