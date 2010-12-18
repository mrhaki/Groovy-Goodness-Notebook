// Simple map.
def m = [name: 'mrhaki', language: 'Groovy']

assert m.getAt('name') == 'mrhaki'
assert m['name'] == 'mrhaki'
assert m.language == 'Groovy'
assert m."name" == 'mrhaki'
assert m.get('name')  == 'mrhaki' // We can omit the default value if we know the key exists.
assert m.get('language', 'Java') == 'Groovy'
assert m.get('expression') == null // Non-existing key in map.
assert m.get('expression', 'rocks') == 'rocks' // Use default value, this also creates the key/value pair in the map.
assert m.get('expression') == 'rocks'
assert m == [name: 'mrhaki', language: 'Groovy', expression: 'rocks']


def map = [start: 'one'].withDefault { key ->
    key.isNumber() ? 42 : 'Groovy rocks!'
}

assert map.start == 'one'
assert map['1'] == 42
assert map['I say'] == 'Groovy rocks!'
assert map.size() == 3

// We can still assign our own values to keys of course:
map['mrhaki'] = 'Hubert Klein Ikkink'
assert map.mrhaki == 'Hubert Klein Ikkink'
assert map.size() == 4
