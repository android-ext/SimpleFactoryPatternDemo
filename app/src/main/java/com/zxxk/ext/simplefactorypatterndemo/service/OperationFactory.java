package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 简单工厂类
 * Created by Ext
 * Created at 2016/3/2
 */
public class OperationFactory {

    public static Operation createOperation(String operate) {

        Operation oper = null;

        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;

            case "-":
                oper = new OperationSub();
                break;

            case "*":
                oper = new OperationMul();
                break;

            default:
            case "/":
                oper = new OperationDiv();
                break;
        }

        return oper;
    }
}
