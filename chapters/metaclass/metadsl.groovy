// DSL for defining multiple methods with different
// arguments in a closure.
String.metaClass {
    or << { String s -> delegate.plus(' or ').plus(s) }
    or << { List l -> delegate.findAll("(${l.join('|')})") }
    and { String s -> delegate.plus(' and ').plus(s) }
    'static' {
        groovy { 'Yeah man!' }
    }
}

assert ("Groovy" | "Java?") == 'Groovy or Java?'
assert ("Groovy" | ['o', 'y']) == ['o', 'o', 'y']
assert ("Groovy" & "Java!") == 'Groovy and Java!'

assert String.groovy() == 'Yeah man!'
