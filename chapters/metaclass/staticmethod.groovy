class User {
    String username, email
    String toString() { "$username, $email" }
}

// Add 'new' static method to User class.
User.metaClass.static.new = { u, e ->
    new User(username: u, email: e)
}

def u = User.new('mrhaki', 'mail@host.com')

assert u.username == 'mrhaki'
assert u.email == 'mail@host.com'
