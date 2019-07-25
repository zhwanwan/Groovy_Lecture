package com.lec.grov03
/**
 * Groovy的数据结构
 * 2.映射
 */
//def map = new HashMap()
def colors = [red: 'ff0000', 'green': '00ff00', blue: '0000ff']
//索引方式
println colors['red']
println colors.red
//添加元素
colors.yellow = 'ffff00'
colors.complex = [a: 1, b: 2]
println colors.getClass() //class java.util.LinkedHashMap
println colors.toMapString()
println('----------------------------------------')
def students = [
        1: [number: '0001', name: 'Bob', score: 55, sex: 'male'],
        2: [number: '0002', name: 'Joy', score: 80, sex: 'male'],
        3: [number: '0003', name: 'Tom', score: 76, sex: 'male'],
        4: [number: '0004', name: 'Amy', score: 90, sex: 'female']
]
//一般遍历
students.each { def student -> println "key: ${student.key}, value: ${student.value}" } //def可省略

//带索引的遍历eachWithIndex 顺序：对象,index
students.eachWithIndex {
    def student, int i -> println "index: ${i}, key: ${student.key}, value: ${student.value}"
}
//each: key,value
students.each {
    key, value -> println "key: ${key}, value: ${value}"
}
//eachWithIndex: 三个参数分别表示key,value,index
students.eachWithIndex {
    key, value, index -> println "index: ${index}, key: ${key}, value: ${value}"
}
println('----------------------------------------')

//Map的查找
def entry1 = students.find {
    def student -> return student.value.score >= 60
}
println entry1

def entry2 = students.findAll {
    def student -> return student.value.score >= 60
}
println entry2

def count = students.count {
    return it.value.score >= 60 && it.value.sex == 'male'
}
println count
//查找所有及格学生的姓名
def names = students.findAll {
    def student -> return student.value.score >= 60
}.collect { it.value.name }
println names
println('----------------------------------------')
//Map分组
def group = students.groupBy {
    def student -> return student.value.score >= 60 ? '及格' : '不及格'
}
println group.toMapString()
println('----------------------------------------')

//Map排序: map排序有返回值，不是在原有map上排序，这一点跟list不同，list排序直接影响本身，因此没有返回值
def mapSort = students.sort {
    def s1, def s2 ->
        Number score1 = s1.value.score
        Number score2 = s2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}
println students.toMapString()
println mapSort.toMapString()