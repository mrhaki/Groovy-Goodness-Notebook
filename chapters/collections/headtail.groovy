def list = [1, 2, 3, 4]

def reverse(l) {
    if (l.size() == 0) {
        []
    } else {
        reverse(l.tail()) + l.head()
    }
}

assert [4, 3, 2, 1] == reverse(list)

// For the same result we can of course use the List.reverse() method,
// but then we didn't learn about tail() and head() ;-)
assert [4, 3, 2, 1] == list.reverse()


String[] stringArray = ['Groovy', 'Grails', 'Spock']

assert 'Groovy' == stringArray.head()
assert ['Grails', 'Spock'] == stringArray.tail()
assert 'Groovy' == stringArray.first()
assert 'Spock' == stringArray.last()
