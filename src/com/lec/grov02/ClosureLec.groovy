package com.lec.grov02

/**
 * 闭包：就是一个代码块
 */
def closure = {
    println "Hello Groovy"
}
//closure.call()
closure()

//带参闭包
def cur = { String name, int age ->
    println "Hello ${name}, age is ${age}"
}
cur("Groovy", 10)

//所有闭包都有一个默认的参数it--隐式参数
def curIt = { println "Hello ${it}" }
curIt("World")


//闭包返回值
def curRst = { String name -> return "Hello ${name}" }
def result = curRst("Groovy")
println(result)

/*---------------------------------------------*/
int x = 10
//求N!
int fab(int N) {
    int result = 1
    1.upto(N, { num -> result *= num })
    return result
}

println fab(5)

int fab2(int number) {
    int result = 1
    //闭包放在方法后面
    number.downto(1) {
        num -> result *= num
    }
    return result
}

println fab2(5)

//累加操作
int cal(int number) {
    int result
    number.times {
        num -> result += num
    }
    return result
}

println cal(101)

//字符串与闭包结合使用
String str = "the 2 and 3 is 5"
//each遍历
str.each {
    String temp -> print temp.multiply(2)
}

//find查找
println str.find {
    String s -> s.isNumber()
}

def list = str.findAll {
    String s -> s.isNumber()
}
println list.toListString()

def anyStr = str.any {
    String s -> s.isNumber()
}
println anyStr
def everyStr = str.every {
    String s -> s.isNumber()
}

def strList = str.collect { it.toUpperCase() }
println(strList)
println('------------------------------------')

/**
 * 闭包的三个重要变量：this,owner,delegate
 * this:闭包定义处的类
 * owner:闭包定义处的类或对象
 * delegate:代表任意对象，默认就是owner所指向的对象
 */
def scriptClosure = {
    println "this:" + this
    println "owner:" + owner
    println "delegate:" + delegate
}
scriptClosure.call()
println('------------------------------------')
//定义一个内部类
class Person {
    def static classClosure = {
        println "classClosure this:" + this
        println "classClosure owner:" + owner
        println "classClosure delegate:" + delegate
    }

    def static say() {
        def classClosure = {
            println "methodClassClosure this:" + this
            println "methodClassClosure owner:" + owner
            println "methodClassClosure delegate:" + delegate
        }
        classClosure.call()
    }
}

Person.classClosure.call()
Person.say()
println('------------------------------------')
Person p = new Person()
p.classClosure.call()
p.say()
println('------------------------------------')
//闭包中定义一个闭包
def nestClosure = {
    def innerClosure = {
        println "innerClosure this: " + this
        println "innerClosure owner: " + owner
        println "innerClosure delegate: " + delegate
    }
    innerClosure.delegate = p //修改默认的delegate对象
    innerClosure.call()
}
nestClosure.call()
println('------------------------------------')

/**
 * 闭包的委托策略
 */

class Student {
    String name
    def pretty = { "My name is ${name}" }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: "Jack") //构造方法中直接给属性赋值
def tec = new Teacher(name: "Tom")
println stu.toString()
stu.pretty.delegate = tec
//DELEGATE_FIRST:先从委托对象里找相应的属性，如果找不到再从原有对象查找该属性
//DELEGATE_ONLY:只从委托对象找相应的属性，找不到则报错
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST //修改委托策略，默认是OWNER_FIRST
println stu.toString()