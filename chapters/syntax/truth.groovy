// Booleans:
def b1 = false
def b2 = true
assert !b1
assert b2

// Strings:
def s1 = ''
def s2 = 'abc'
assert !s1
assert s2

// Numbers:
def n1 = 0
def n2 = 42
assert !n1
assert n2

// Lists, iterators:
def l1 = []
def l2 = [1, 3, 6]
assert !l1
assert l2
def i1 = l1.iterator()
def i2 = l2.iterator()
assert !i1
assert i2

// Maps:
def m1 = [:]
def m2 = ['key': 'value']
assert !m1
assert m2

// Objects:
def o1
def o2 = new Expando(name: 'groovy')
assert !o1
assert o2

// Matchers:
def ma1 = "groovy" =~ /java/
def ma2 = "groovy" =~ /groovy/
assert !ma1
assert ma2



def bytes = [] as byte[]
def ints = [1,2,4] as int[]
def floats = [] as float[]
def booleans = [true, false] as boolean[]

assert !bytes
assert ints
assert !floats
assert booleans


class User {
    String username
    boolean active

    boolean asBoolean() {
        active
    }
}

assert new User(username: 'mrhaki', active: true)
assert !new User(username: 'mrhaki', active: false)

// We can also add the asBoolean method with metaClass.
String.metaClass.asBoolean = {
    delegate == /sure/
}
assert !'true'
assert 'sure'
