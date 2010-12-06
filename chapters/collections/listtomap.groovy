def list = ['key', 'value', 'name', 'mrhaki'] as Object[]
def map = list.toSpreadMap()

assert map.size() == 2
assert map.key == 'value'
assert map['name'] == 'mrhaki'
