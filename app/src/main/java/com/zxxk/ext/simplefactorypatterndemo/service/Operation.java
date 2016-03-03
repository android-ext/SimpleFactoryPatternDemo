package com.zxxk.ext.simplefactorypatterndemo.service;

/**
 * Description: 运算符操作父类
 * Created by Ext
 * Created at 2016/3/2
 */
public abstract class Operation {

    protected double numberA = 0;
    protected double numberB = 0;

    public double getResult(){

        double result = 0;

        return result;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }


}
