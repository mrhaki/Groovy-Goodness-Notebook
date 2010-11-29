def one = ['Java', 'Groovy', 'Scala']
def two = ['Groovy', 'JRuby', 'Java']
def three = ['C++', 'C##']

assert ['Groovy', 'Java'] == one.intersect(two)
assert [] == one.intersect(three)
assert one.disjoint(three)
assert !one.disjoint(two)


def m1 = [a: 'Groovy', b: 'rocks', c: '!']
def m2 = [a: 'Groovy', b: 'rocks', c: '?', d: 'Yes!']

assert [a: 'Groovy', b: 'rocks'] == m1.intersect(m2)

assert [1: 1.0, 2: 2] == [1: 1.0, 2: 2].intersect([1: 1, 2: 2.0])
