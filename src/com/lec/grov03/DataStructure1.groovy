package com.lec.grov03

/**
 * Groovy的数据结构
 * 1.列表
 * 2.映射
 * 3.范围
 */

//def list = new ArrayList() //java中list的定义方式
def list = [1, 2, 3, 4, 5] //Groovy中list定义方式
println list.class //class java.util.ArrayList
//定义数组的两种方式
def array = [1, 2, 3, 4, 5] as int[]
int[] arr = [1, 2, 3, 4, 5]
println arr.class == array.class
println('----------------------------------------')

/**
 * 列表的排序
 */
def sortList = [6, -9, 2, 3, 4, 8, 1]
//Collections.sort(sortList)
//println sortList
/*Comparator cp = { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
Collections.sort(sortList,cp)
println sortList*/
//sortList.sort()
//println sortList
sortList.sort { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1 }
println sortList
println('----------------------------------------')
def sortStringList = ['abc', 'z', 'hello', 'groovy', 'java']
sortStringList.sort { return it.size() } //使用隐藏参数it,等价于sortStringList.sort {it -> return it.size()}
println sortStringList
println('----------------------------------------')

/**
 * 列表的查找
 */
def findList = [-3, 4, 8, 2, 1, -9, 5, 0]
/*
int result = findList.find {return it % 2 == 0} //查找列表中第一个偶数
println(result)*/
/*
def result = findList.findAll {return it % 2 != 0} //查找所有的奇数
println result.toListString()
*/
/*
def result = findList.any {return it % 2 != 0}
println result*/
/*def result = findList.every {return it % 2 == 0} //列表中是否都是偶数
println result*/
/*
println findList.min()  //列表中最小值
println findList.max { return Math.abs(it) } //列表中绝对值最大的
*/
def num = findList.count { return it % 2 == 0 }
println num
println('----------------------------------------')