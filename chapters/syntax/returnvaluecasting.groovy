// Return type determines type casting of return value.
String simple() {
    42
}
assert simple().class.name == 'java.lang.String'
assert simple() == '42'

class User {
    String name, email
}

User createUser() {
    [name: 'mrhaki', email: 'mail@host.com']
}
assert createUser() instanceof User
assert createUser().name == 'mrhaki'
assert createUser().email == 'mail@host.com'
