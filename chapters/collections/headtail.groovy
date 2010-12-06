def list = [1, 2, 3, 4]

// Recursive method with tail/head methods.
def reverse(l) {
    if (l.size() == 0) {
        []
    } else {
        reverse(l.tail()) + l.head()
    }
}

assert reverse(list) ==  [4, 3, 2, 1]

// For the same result we can of course use the List.reverse() method,
// but then we didn't learn about tail() and head() ;-)
assert list.reverse() == [4, 3, 2, 1]

// Tail/head also works on arrays.
String[] stringArray = ['Groovy', 'Grails', 'Spock']
assert stringArray.head() == 'Groovy'
assert stringArray.tail() == ['Grails', 'Spock']
assert stringArray.first() == 'Groovy'
assert stringArray.last() == 'Spock'
