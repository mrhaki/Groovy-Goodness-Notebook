def keys = ['username', 'email']
def values = ['mrhaki', 'email@host.com', 'not-tranposed']
def transpose = [keys, values, [0, 1]].transpose()
assert transpose.size() == 2
assert transpose == [['username', 'mrhaki', 0], ['email', 'email@host.com', 1]]
