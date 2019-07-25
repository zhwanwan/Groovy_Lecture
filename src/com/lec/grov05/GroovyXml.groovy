package com.lec.grov05

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

//开始解析xml数据
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