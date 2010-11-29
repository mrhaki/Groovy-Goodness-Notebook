def m = [sort: 'asc', name: 'test', paginate: true, max: 100]

def expectedKeys = ['max', 'name', 'paginate', 'sort']
assert expectedKeys == m.sort()*.key  // Since 1.7.2
assert expectedKeys == m.sort( { k1, k2 -> k1 <=> k2 } as Comparator )*.key // Since 1.7.2

// Sorting before Groovy 1.7.2
assert expectedKeys == new TreeMap(m)*.key
assert expectedKeys == m.sort { e1, e2 -> e1.key <=> e2.key }*.key  // Sort by closure.
