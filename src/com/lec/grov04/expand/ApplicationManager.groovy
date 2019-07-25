package com.lec.grov04.expand

import com.lec.grov04.Person

/**
 * 模拟一个应用的管理类
 */
class ApplicationManager {

    static void init() {

        ExpandoMetaClass.enableGlobally() //设置全局有效，一次注入，其他类也可用
        //为第三方类添加静态方法
        Person.metaClass.static.createPerson = {
            String name, int age -> new Person(name: name, age: age)
        }
    }

}
