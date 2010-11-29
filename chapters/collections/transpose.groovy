def keys = ['username', 'email']
def values = ['mrhaki', 'email@host.com', 'not-tranposed']
def transpose = GroovyCollections.transpose([keys, values, [0, 1]])
assert 2 == transpose.size()
assert [['username', 'mrhaki', 0], ['email', 'email@host.com', 1]] == transpose
