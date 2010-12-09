// Define 'groovy' method with different argument types.
String.metaClass.groovy << { Integer number ->
    delegate * number
} << { String s ->
    delegate + s
} << { ->
    delegate + ' Groovy rocks.'
}

assert 'Groovy'.groovy(2) == 'GroovyGroovy'
assert 'Hello world'.groovy(' from Groovy') == 'Hello world from Groovy'
assert 'It is true.'.groovy() == 'It is true. Groovy rocks.'
