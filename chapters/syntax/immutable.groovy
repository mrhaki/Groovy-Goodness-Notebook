@Immutable class User {
    String username, email
    Date created = new Date()
    Collection roles
}

def first = new User(username: 'mrhaki', email: 'email@host.com', roles: ['admin', 'user'])
assert 'mrhaki' == first.username
assert 'email@host.com' == first.email
assert ['admin', 'user'] == first.roles
assert new Date().after(first.created)
try {
    // Properties are readonly.
    first.username = 'new username'
} catch (ReadOnlyPropertyException e) {
    assert 'Cannot set readonly property: username for class: User' == e.message
}
try {
    // Collections are wrapped in immutable wrapper classes, so we cannot
    // change the contents of the collection.
    first.roles << 'new role'
} catch (UnsupportedOperationException e) {
    assert true
}


def date = new Date(109, 8, 16)
def second = new User('user', 'test@host.com', date, ['user'])
assert 'user' == second.username
assert 'test@host.com' == second.email
assert ['user'] == second.roles
assert '2009/08/16' == second.created.format('yyyy/MM/dd')
assert date == second.created
assert !date.is(second.created)  // Date, Clonables and arrays are deep copied.
// toString() implementation is created.
assert 'User(user, test@host.com, Wed Sep 16 00:00:00 UTC 2009, [user])' == second.toString()


def third = new User(username: 'user', email: 'test@host.com', created: date, roles: ['user'])
// equals() method is also generated by the annotation and is based on the
// property values.
assert third == second
