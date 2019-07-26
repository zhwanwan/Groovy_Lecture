package com.lec.grov05

import groovy.xml.MarkupBuilder

/**
 * Groovy的XML应用
 */
final String xml = '''
<beans>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property>jdbcTemplate</property>
    </bean>
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/sampdb">dataSource</property>
    </bean>
    <bean id="accountDao" class="com.lec.jdbc.template.dao.impl.AccountDaoImpl2">
        <property>accountDao</property>
    </bean>
</beans>
'''

//开始解析xml数据:XmlSlurper
def xmlSluper = new XmlSlurper()
def beans = xmlSluper.parseText(xml)
println beans.bean[0].property[0].text()
println beans.bean[1].property[0].@name
println beans.bean[1].property[0].@value

def list = []
beans.each { bean ->
    bean.property.each { property ->
        def prop = property.text()
        list.add(prop)
    }
}
//println list

//深度遍历xml数据： .depthFirst() ==> .'**'
def properties = beans/*.'**'*/.depthFirst().findAll {
    bean -> return bean.property.text() == 'accountDao' ? true : false
}
println properties.toListString()

//广度遍历xml数据：.children() ==>.'*'
def prop = beans.children()/*.'*'*/.findAll {
    node -> node.name() == 'bean' && node.@id == 'jdbcTemplate'
}.collect {
    node -> return node.property.text()
}
println prop
println('---------------------------------------------------------')
/**
 * 创建XML:MarkupBuilder
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw)
//静态生成xml
/*xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    //第一个language节点
    language(flavor: 'static', version: '1.8', value: 'Java') {
        age(value: 16)
    }
    language(flavor: 'dynamic', version: '1.6', value: 'Groovy') {
        age(value: 10)
    }
    language(flavor: 'dynamic', version: '1.9', value: 'JavaScript') {
        age(value: 15)
    }
}
println sw*/
println '-------------------动态生成XML-------------------------'
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [
            new Language(flavor: 'static', version: '1.8', value: 'Java'),
            new Language(flavor: 'dynamic', version: '1.6', value: 'Groovy'),
            new Language(flavor: 'dynamic', version: '1.7', value: 'JavaScript')
    ]
}

class Language {
    String flavor
    String version
    String value
}

def langs = new Langs()
xmlBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    langs.languages.each {
        lang -> language(flavor: lang.flavor, version: lang.version, value: lang.value)
    }
}
println sw