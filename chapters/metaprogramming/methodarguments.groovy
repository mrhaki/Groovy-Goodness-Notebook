String.metaClass.groovy << { Integer number ->
    delegate * number
} << { String s ->
    delegate + s
} << { ->
    delegate + ' Groovy rocks.'
}

assert 'GroovyGroovy' == 'Groovy'.groovy(2)
assert 'Hello world from Groovy' == 'Hello world'.groovy(' from Groovy')
assert 'It is true. Groovy rocks.' == 'It is true.'.groovy()
