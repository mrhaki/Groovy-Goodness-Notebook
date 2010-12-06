def one = ['Java', 'Groovy', 'Scala']
def two = ['Groovy', 'JRuby', 'Java']
def three = ['C++', 'C##']

assert one.intersect(two) == ['Groovy', 'Java']
assert one.intersect(three) == []
assert one.disjoint(three)
assert !one.disjoint(two)


def m1 = [a: 'Groovy', b: 'rocks', c: '!']
def m2 = [a: 'Groovy', b: 'rocks', c: '?', d: 'Yes!']

assert [a: 'Groovy', b: 'rocks'] == m1.intersect(m2)

// Numbers are compared for equality and value from
// first map is used as intersection result map.
assert [1: 1.0, 2: 2].intersect([1: 1, 2: 2.0]) == [1: 1.0, 2: 2]
