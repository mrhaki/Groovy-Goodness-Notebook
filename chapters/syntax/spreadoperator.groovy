class Simple {
    String speak(Integer n, String text, Date date) {
        def out = new StringBuffer()
        n.times {
            out << "Say $text on ${date.format('yyyy-MM-dd')}.\n"
        }
        out
    }
}

// Spread params list for speak() method.
def params = [
    2,
    "hello world",
    new Date().parse("yyyy/MM/dd", "2009/09/01")
]
assert new Simple().speak(*params) == '''Say hello world on 2009-09-01.
Say hello world on 2009-09-01.
'''

// Add a list to another list.
def list = ['Groovy', 'Java']
assert [*list, 'Scala'] == ['Groovy', 'Java', 'Scala']

// Add a range to a list.
def range = 2..5
assert [1, *range, 6] == [1, 2, 3, 4, 5, 6]

// Add a map to another map.
def map = [name: 'mrhaki', blog: true]
assert [subject: 'Groovy Goodness', *:map] == [name: 'mrhaki', blog: true, subject: 'Groovy Goodness']

// Little trick to simulate named parameters for a method.
// It is just a trick so the ordering of the map key/values
// must be the same as the method parameters.
def paramsMap = [
    n: 1,
    text: 'hello',
    date: new Date().parse("yyyy/MM/dd", "2009/09/04")
]
def paramsList = paramsMap.values().toList()
assert new Simple().speak(*paramsList) == 'Say hello on 2009-09-04.\n'
