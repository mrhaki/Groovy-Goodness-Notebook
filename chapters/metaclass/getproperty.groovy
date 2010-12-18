class User {
    String username
}

User.metaClass.getProperty = { String propName ->
    def meta = User.metaClass.getMetaProperty(propName)
    if (meta) {
        meta.getProperty(delegate)
    } else {
        'Dynamic property for User'
    }
}

def mrhaki = new User(username: 'mrhaki')

assert mrhaki.username == 'mrhaki'
assert mrhaki.fullname == 'Dynamic property for User'
