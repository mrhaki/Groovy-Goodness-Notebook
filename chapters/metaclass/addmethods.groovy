// We add the method rightShift to the List class.
// The implementation is simply calling the remove method of List with
// the provided argument.
List.metaClass.rightShift {
    delegate.remove it
}

def list = ['one', 'two', 'three', 'four']
assert list.size() == 4

list.rightShift 'two'
assert list.size() == 3
assert list == ['one', 'three', 'four']

// Operator overloading in action: rightShift is >>
list >> 'one'
assert list.size() == 2
assert list == ['three', 'four']


// We can also add behaviour to a specific instance instead of class.
// Notice we use the instance list instead of class List to assign
// method groovy to metaClass property.
list.metaClass.groovy {
    delegate.collect { it + ' groovy' }
}

assert list.groovy() == ['three groovy', 'four groovy']

def newList = ['a', 'b']
try {
    newList.groovy()  // groovy method was added to list instance not List class.
    assert false
} catch (e) {
    assert e instanceof MissingMethodException
}
