def m1 = [user: 'mrhaki', age: 37]
def m2 = [user: 'mrhaki', name: 'Hubert']
def m3 = [user: 'Hubert', age: 37]

assert m1 - m2 == [age: 37]
assert m1 - m3 == [user: 'mrhaki']
