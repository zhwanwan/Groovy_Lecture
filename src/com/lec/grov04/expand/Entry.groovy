package com.lec.grov04.expand

import com.lec.grov04.PersonManager

/**
 * 入口程序--测试类
 */
class Entry {

    static void main(def args) {

        println '应用程序正在启动...'
        //初始化
        ApplicationManager.init()
        println '应用程序初始化完成...'
        def person = PersonManager.createPerson('zhangsan', 27)
        println "Name: ${person.name}, Age: ${person.age}"
    }
}
