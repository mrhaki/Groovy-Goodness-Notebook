String.metaClass {
    or << { String s -> delegate.plus(' or ').plus(s) }
    or << { List l -> delegate.findAll("(${l.join('|')})") }
    and { String s -> delegate.plus(' and ').plus(s) }
    'static' {
        groovy { 'Yeah man!' }
    }
}

assert 'Groovy or Java?' == ("Groovy" | "Java?")
assert ['o', 'o', 'y'] == ("Groovy" | ['o', 'y'])
assert 'Groovy and Java!' == ("Groovy" & "Java!")

assert 'Yeah man!' == String.groovy()
