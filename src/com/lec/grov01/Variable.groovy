package com.lec.grov01

/**
 * groovy中的变量：
 * 基本类型/对象类型都会转成对象类型
 *
 */

//强类型定义方式，跟Java中类似
int x = 10;
println(x.class) //class java.lang.Integer

double y = 3.14
println y.class  //class java.lang.Double

Float z = 5.5
println(z.class) //class java.lang.Float

println("---------------------------")

//定义弱类型变量(用def关键字)，所谓弱类型就是可以动态转换成其他类型
def x_1 = 11
def y_1 = 3.1415
def name = "Android"
println(x_1.class)
println(y_1.class)
println(name.class)
x_1 = "Groovy"
println x_1.class
println("---------------------------")


//------------String类型-------------------
def str = 'a single string' //用单引号定义一个string
def str1 = 'Tom\'s cat'   //转义字符'
println(str.class)
println str1
def tripleName = '''\
line one
line two
line three''' //三引号字符串,
println(tripleName)
println("---------------------------")
//双引号的字符串--可扩展的字符串
def doubleName = "this is a common string"
def grv = "Groovy"
def hello = "Hello : ${grv}"
println hello
println hello.class
def sum = "2 + 3 = ${2 + 3}" //可扩展任意的表达式
//println(sum)

String echo(String message) {
    return message
}
def result = echo(sum)
println result
println(result.class)

/*============字符串方法============*/
def test = "Hello groovy"
println test.center(8,'a')
println test.padLeft(8,'a')

def test1 = 'Hello'
println test > test1

println test[0]
println test1[0..1]

println test.minus(test1)
println test - test1

println test1.reverse().capitalize()
println test.isNumber()