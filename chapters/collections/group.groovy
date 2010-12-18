// A simple map.
def m = [q1: 'Groovy', sort: 'desc', q2: 'Grails']

// Closure we use to define the grouping.
// We want all keys starting with 'q' grouped together
// with the key 'params', all other keys are not grouped.
def groupIt = { key, value ->
    if (key.startsWith('q')) {
        'params'
    } else {
        key
    }
}

// Use groupEntriesBy.
def groupEntries = m.groupEntriesBy(groupIt)
assert groupEntries.size() == 2
assert groupEntries.params && groupEntries.sort
assert groupEntries.sort[0].value == 'desc' // Key for a list of Map$Entry objects.
assert groupEntries.params.size() == 2
assert groupEntries.params[0].value == 'Groovy'
assert groupEntries.params[0].key == 'q1'
assert groupEntries.params.find { it.key == 'q2' }.value == 'Grails'
assert groupEntries.params instanceof ArrayList
assert groupEntries.params[0] instanceof Map$Entry

// Use groupBy.
def group = m.groupBy(groupIt)
assert group.size() == 2
assert group.params && group.sort
assert group.sort.sort == 'desc'  // Key for Map with key/value pairs.
assert group.params.size() == 2
assert group.params.q1 == 'Groovy'
assert group.params.keySet().toArray()[0] == 'q1'
assert group.params.q2 == 'Grails'
assert group.params instanceof Map
assert group.params.q1 instanceof String


class User {
    String name
    String city
    Date birthDate
    public String toString() { "$name" }
}

def users = [
    new User(name:'mrhaki', city: 'Tilburg', birthDate: new Date(year: 73, month: 9, date: 7)),
    new User(name:'bob', city: 'New York', birthDate: new Date(year: 63, month: 3, date: 30)),
    new User(name:'britt', city: 'Amsterdam', birthDate: new Date(year: 80, month: 5, date: 12)),
    new User(name:'kim', city: 'Amsterdam', birthDate: new Date(year: 83, month: 3, date: 30)),
    new User(name:'liam', city: 'Tilburg', birthDate: new Date(year: 109, month: 3, date: 6))
]

// Helper closure for asserts.
def userToString = { it.toString() }

// Group by city property of user object:
def usersByCity = users.groupBy({ user -> user.city })
assert usersByCity["Tilburg"].size() == 2
assert usersByCity["Tilburg"].collect(userToString) == ['mrhaki', 'liam']
assert usersByCity["New York"].collect(userToString) == ['bob']
assert usersByCity["Amsterdam"].collect(userToString) == ['britt', 'kim']

// Group by year of birthdate property of user object:
def byYear = { u -> u.birthDate[Calendar.YEAR] }
def usersByBirthDateYear = users.groupBy(byYear)
assert usersByBirthDateYear[1973].collect(userToString) == ['mrhaki']

// Just a little fun with the closure:
def groupByGroovy = {
    if (it =~ /y/) {
        "Contains y"
    } else {
        "Doesn't contain y"
    }
}
assert ['Groovy', 'Java', 'Scala'].groupBy(groupByGroovy) == ["Contains y":["Groovy"], "Doesn't contain y":["Java", "Scala"]]
