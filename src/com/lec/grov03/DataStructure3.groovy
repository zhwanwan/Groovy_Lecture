package com.lec.grov03

/**
 * Groovy的数据结构
 * 3.范围--Range
 */
def range = 1..10
println range.class //class groovy.lang.IntRange
println "range第一个元素：" + range[0]
println "range是否包含10：" + range.contains(10)
println "range第一个元素：" + range.from
println "range最后一个元素：" + range.to
println('----------------------------------------')
//遍历
range.each { print it + " " }
println()
for (i in range) {
    print i + " "
}
println()

def getGrade(Number num) {
    def result
    switch (num) {
        case 0..60:
            result = '不及格'
            break
        case 60..70:
            result = '及格'
            break
        case 70..80:
            result = '良好'
            break
        case 80..100:
            result = '优秀'
            break
    }
    /*return*/ result //Groovy中return可以省略
}

def result = getGrade(75)
println result