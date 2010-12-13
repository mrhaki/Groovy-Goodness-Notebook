// Set the stage with a Simple interface
// and Sample class.
interface Simple {}
class Sample implements Simple {
    String info
    String displayInfo() { "info from $Sample.name" }
}

// In Groovy we can omit the getClass() method
// invocation to get the name.
assert Sample.name == 'Sample'
assert Sample.class.name == 'Sample'  // With getClass() method.

// We can see which interfaces are implemented by the class.
def interfaces = Sample.interfaces.name
assert 'Simple' in interfaces
assert 'groovy.lang.GroovyObject' in interfaces

// Let's see which methods are available.
def methods = Sample.methods.name
assert 'setInfo' in methods
assert 'getInfo' in methods
assert 'displayInfo' in methods

def s = new Sample()
assert s.displayInfo() == 'info from Sample'
