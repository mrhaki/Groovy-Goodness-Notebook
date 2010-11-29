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
assert 2 == groupEntries.size()
assert groupEntries.params & groupEntries.sort
assert 'desc' == groupEntries.sort[0].value  // Key for a list of Map$Entry objects.
assert 2 == groupEntries.params.size()
assert 'Groovy' == groupEntries.params[0].value
assert 'q1' == groupEntries.params[0].key
assert 'Grails' == groupEntries.params.find { it.key == 'q2' }.value
assert groupEntries.params instanceof ArrayList
assert groupEntries.params[0] instanceof Map$Entry

// Use groupBy.
def group = m.groupBy(groupIt)
assert 2 == group.size()
assert group.params & group.sort
assert 'desc' == group.sort.sort  // Key for Map with key/value pairs.
assert 2 == group.params.size()
assert 'Groovy' == group.params.q1
assert 'q1' == group.params.keySet().toArray()[0]
assert 'Grails' == group.params.q2
assert group.params instanceof Map
assert group.params.q1 instanceof String


class User {
    String name
    String city
    Date birthDate
    public String toString() { "$name" }
}

def users = [
    new User(name:'mrhaki', city:'Tilburg', birthDate:new Date(73,9,7)),
    new User(name:'bob', city:'New York', birthDate:new Date(63,3,30)),
    new User(name:'britt', city:'Amsterdam', birthDate:new Date(80,5,12)),
    new User(name:'kim', city:'Amsterdam', birthDate:new Date(83,3,30)),
    new User(name:'liam', city:'Tilburg', birthDate:new Date(109,3,6))
]

// Helper closure for asserts.
def userToString = { it.toString() }

// Group by city property of user object:
def usersByCity = users.groupBy({ user -> user.city })
assert 2 == usersByCity["Tilburg"].size()
assert ['mrhaki', 'liam'] == usersByCity["Tilburg"].collect(userToString)
assert ['bob'] == usersByCity["New York"].collect(userToString)
assert ['britt', 'kim'] == usersByCity["Amsterdam"].collect(userToString)

// Group by year of birthdate property of user object:
def byYear = { u -> u.birthDate[Calendar.YEAR] }
def usersByBirthDateYear = users.groupBy(byYear)
assert ['mrhaki'] == usersByBirthDateYear[1973].collect(userToString)

// Just a little fun with the closure:
def groupByGroovy = {
    if (it =~ /y/) {
        "Contains y"
    } else {
        "Doesn't contain y"
    }
}
assert ["Contains y":["Groovy"], "Doesn't contain y":["Java", "Scala"]] == ['Groovy', 'Java', 'Scala'].groupBy(groupByGroovy)
