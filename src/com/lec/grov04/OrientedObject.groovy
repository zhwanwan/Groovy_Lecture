package com.lec.grov04

/**
 * Groovy面向对象
 *
 * 2.无论直接用.还是调用get/set，最终都是调用get/set
 */
def person = new Person(name: "Amy", age: 20)
println "Name: ${person.name}, Age: ${person.getAge()}"
person.increaseAge(2);
println person.toString()
println '--------------------------------------------'
//为类动态添加一个属性
//ExpandoMetaClass.enableGlobally() //设置全局有效
Person.metaClass.sex = 'male'
def p = new Person(name: "Jack", age: 18)
p.sex = 'female'
println p.sex
//为类动态添加一个成员方法
Person.metaClass.sexUpperCase = { -> sex.toUpperCase() }
def p1 = new Person(name: "Cherry", age: 21)
println p1.sexUpperCase()
//为类动态添加一个静态方法
Person.metaClass.static.createPerson = {
    String name, int age -> new Person(name: name, age: age)
}
def p2 = Person.createPerson('Bruce',30)
println p2.name + ", " + p2.age

