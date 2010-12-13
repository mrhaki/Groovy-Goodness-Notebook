def user = new Expando(username: 'mrhaki')
assert user.username == 'mrhaki'

// Add an extra property.
user.email = 'email@host.com'
assert user.email == 'email@host.com'

// Assign closure as a method.
// The closure can take parameters.
user.printInfo = { writer ->
    writer << "Username: $username"
    writer << ", email: $email"
}

def sw = new StringWriter()
user.printInfo(sw)
assert sw.toString() == 'Username: mrhaki, email: email@host.com'
