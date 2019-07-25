package com.lec.grov01

/**
 * Groovy流程控制
 */

def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break;
    case [1.23, 4, 5, 6, 'inlist']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
    default: result = 'default'
}

println result

//for loop
def sum = 0;
for (i in 0..9){
    sum += i
}
println sum
sum = 0

//list loop
for (i in [1,2,3,4,5,6,7,8,9]){
    sum += i
}
println(sum)


//map loop
for (i in ['a':1,'b':2]) {
    sum += i.value
}
