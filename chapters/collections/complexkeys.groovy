def key = 100  // Variable to be used a key.

def m = [
    (new Date(109, 11, 1)): 'date key',
    (-42): 'negative number key',
    (false): 'boolean key',
    (key): 'variable key'
]
m.(true) = 'boolean key'  // Key is converted to String.
m.(2 + 2) = 'number key'
m[(key + 1)] = 'number key'  // Key keeps to be Integer.

assert m[new Date(109, 11, 1)] == 'date key'
assert m.get(-42) == 'negative number key'
assert m[(false)] == 'boolean key'
assert m[100] == 'variable key'
assert m.getAt(key) == 'variable key'
assert m['true'] == 'boolean key' // Key is String so we can use it to get the value.
assert m.'4' == 'number key'
assert m.get(101) == 'number key'
