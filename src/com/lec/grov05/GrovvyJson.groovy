package com.lec.grov05

import com.lec.grov04.Person
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * Groovy的JSON应用
 *
 */

//将对象转换成Json
def list = [
        new Person(name: "John", age: 20),
        new Person(name: "Jack", age: 21),
        new Person(name: "Tom", age: 18)
]

def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)
println('------------------------------------------')
//将Json转换成对象
def jsonSlurper = new JsonSlurper()
def o = jsonSlurper.parseText(json)
println o
println('------------------------------------------')
//定义一个方法请求URL获取JSON数据
def getNetworkData(String url) {
    //发送HTTP请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text;
    //将json转换为对象
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(response)
}

def response = getNetworkData('localhost:8080/data.json')
println response.data.head.name
