package com.lec.grov04

/**
 * 1.groovy中默认都是public
 */
class Person implements Action, Serializable {

    String name
    int age
    //定义一个方法
    def increaseAge(int year) {
        this.age += year
    }

    @Override
    String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    void eat() {
        println 'eating'
    }

    @Override
    void drink() {
        println 'drinking'
    }

    @Override
    void play() {
        println 'playing'
    }

    /*@Override
    Object invokeMethod(String s, Object o) {
        return "method name : ${s}, parameters : ${o}"
    }*/

    def invokeMissingMethod(Object o, String name, Object[] args) {
        return "method name : ${name}, parameters : ${args}"
    }


}
