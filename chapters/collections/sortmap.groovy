def m = [sort: 'asc', name: 'test', paginate: true, max: 100]

def expectedKeys = ['max', 'name', 'paginate', 'sort']
assert m.sort()*.key == expectedKeys
assert m.sort( { k1, k2 -> k1 <=> k2 } as Comparator )*.key == expectedKeys

// Other ways to sort a map.
assert new TreeMap(m)*.key == expectedKeys
assert m.sort { e1, e2 -> e1.key <=> e2.key }*.key == expectedKeys  // Sort by closure.
