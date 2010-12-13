import groovy.transform.InheritConstructors

@InheritConstructors
class MyException extends Exception {
}

def e = new MyException()
def e1 = new MyException('message')   // Other constructors are available.
assert e1.message == 'message'

class Person {
    String name

    Person(String name) {
        this.name = name
    }
}

@InheritConstructors
class Child extends Person {}

def child = new Child('Liam')
assert child.name == 'Liam'
