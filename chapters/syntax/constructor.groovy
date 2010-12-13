// Default constructor invocation:
def url1 = new URL('http', 'www.mrhaki.com', 80, '/')
assert url1.protocol == 'http'
assert url1.host == 'www.mrhaki.com'
assert url1.port == 80
assert url1.file == '/'
assert url1.path == '/'

// Explicit coersion with as keyword:
def url2 = ['http', 'www.mrhaki.com', 80, '/'] as URL
assert url2.protocol == 'http'
assert url2.host == 'www.mrhaki.com'
assert url2.port == 80
assert url2.file == '/'
assert url2.path == '/'

// Implicit coersion by type of variable:
URL url3 = ['http', 'www.mrhaki.com', 80, '/']
assert url3.protocol == 'http'
assert url3.host == 'www.mrhaki.com'
assert url3.port == 80
assert url3.file == '/'
assert url3.path == '/'


// GroovyBean: Groovy creates a constructor
// that takes a map as parameter.
class Sample {
    Integer age
    String name
}

def s1 = new Sample([age: 36, name: 'mrhaki'])
assert s1.age == 36
assert s1.name == 'mrhaki'

// Explicit coersion with as keyword:
def s2 = [age: 36, name: 'mrhaki'] as Sample
assert s2.age == 36
assert s2.name == 'mrhaki'

// Implicit coersion (by type of variable):
Sample s3 = [age: 36, name: 'mrhaki']
assert s3.age == 36
assert s3.name == 'mrhaki'
