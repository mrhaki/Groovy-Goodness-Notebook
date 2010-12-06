// Collect without initial collection.
assert (0..3).collect { it * 2 } == [0,2,4,6]
assert [lang: 'Groovy', framework: 'Grails'].collect { it.value } == ['Groovy', 'Grails']

// Collect with initial collection argument.
assert [2, 3].collect([0, 1]) { it } == [0, 1, 2, 3]
assert [2, 3].collect([0, 3], { it * 3}) == [0, 3, 6, 9]
assert ['Groovy', 'Grails'].collect(['Gradle']) { it.toLowerCase() } == ['Gradle', 'groovy', 'grails']
assert [4, -3, 7, 5].collect(['m', 'r']) { (it + 100) as char } == ['m','r','h','a','k','i']


class User {
    String name
    String aloud() { name.toUpperCase() }
    String toString() { name }
}

def users = [new User(name: 'mrhaki'), new User(name: 'hubert')]
// Compare spread operator and collect method.
assert users*.toString() == ['mrhaki', 'hubert']
assert users*.aloud() == ['MRHAKI', 'HUBERT']
assert users.collect { it.toString() } == ['mrhaki', 'hubert']
assert users.collect { it.aloud() } == ['MRHAKI', 'HUBERT']

// Compare collectAll and collect methods.
def list = [10, 20, 30, [1, 2, 3, [25, 50]], ['Groovy']]
assert list.collectAll { it * 2 } == [20, 40, 60, [2, 4, 6, [50, 100]], ['GroovyGroovy']]
assert list.collect { it * 2 } == [20, 40, 60, [1, 2, 3, [25, 50], 1, 2, 3, [25, 50]], ['Groovy', 'Groovy']]
