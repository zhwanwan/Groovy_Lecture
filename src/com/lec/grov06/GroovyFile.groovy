package com.lec.grov06

import com.lec.grov04.Person

/**
 * Groovy中文件操作
 * 文本、字节内容的读写
 * 本例中的流底层代码会自动关闭流，无需我们自己关闭流
 *
 */
def file = new File('../../../../Groovy_Lecture.iml')
/*file.eachLine {
    line -> println line
}*/
/*
def text = file.getText()
println text*/
/*
def list = file.readLines()
println list*/

//读取文件部分内容
/*
def reader = file.withReader {reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader*/

/*
def writer = file.withWriter {writer ->
    //
}*/

//定义一个文件拷贝的方法
def copy(String sourcePath, String destinationPath) {
    try {
        //1.创建目标文件
        def destFile = new File(destinationPath)
        if (!destFile.exists())
            destFile.createNewFile()
        //2.拷贝
        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            destFile.withWriter { writer ->
                lines.each { line ->
                    writer.append(line + "\r\n")
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
}

//执行copy方法
/*
def result = copy('../../../../Groovy_Lecture.iml',
        '../../../../Groovy_Lecture2.iml')
println result*/

println('---------------------------------------------------')
/**
 * 对象存储
 */
def saveObject(Object object, String path) {
    try {
        def destFile = new File(path)
        if (!destFile.exists())
            destFile.createNewFile()
        destFile.withObjectOutputStream { out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false;
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists())
            return null
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
        return obj
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

//序列化对象--存储字节
/*
def person = new Person(name: 'Jack',age: 25)
saveObject(person,'../../../../person.bin')*/

//反序列化对象--读取字节
def p = (Person) readObject('../../../../person.bin')
println p
