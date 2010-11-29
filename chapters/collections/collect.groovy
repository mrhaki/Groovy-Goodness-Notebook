// Collect without
// initial collection.
assert [0,2,4,6] == (0..3).collect { it * 2 }
assert ['Groovy', 'Grails'] == [lang: 'Groovy', framework: 'Grails'].collect { it.value }

// Collect with initial collection argument.
assert [0, 1, 2, 3] == [2, 3].collect([0, 1]) { it }
assert [0, 3, 6, 9] == [2, 3].collect([0, 3], { it * 3})
assert ['Gradle', 'groovy', 'grails'] == ['Groovy', 'Grails'].collect(['Gradle']) { it.toLowerCase() }
assert ['m','r','h','a','k','i'] == [4, -3, 7, 5].collect(['m', 'r']) { (it + 100) as char }


class User {
    String name
    String aloud() { name.toUpperCase() }
    String toString() { name }
}

def users = [new User(name: 'mrhaki'), new User(name: 'hubert')]

assert ['mrhaki', 'hubert'] == users*.toString()
assert ['MRHAKI', 'HUBERT'] == users*.aloud()
assert ['mrhaki', 'hubert'] == users.collect { it.toString() }
assert ['MRHAKI', 'HUBERT'] == users.collect { it.aloud() }


def list = [10, 20, 30, [1, 2, 3, [25, 50]], ['Groovy']]

assert [20, 40, 60, [2, 4, 6, [50, 100]], ['GroovyGroovy']] == list.collectAll { it*2 }
assert [20, 40, 60, [1, 2, 3, [25, 50], 1, 2, 3, [25, 50]], ['Groovy', 'Groovy']] == list.collect { it * 2 }
