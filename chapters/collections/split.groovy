def range = 1..10
def (even, odd) = range.split { it % 2 == 0 }
assert even == [2,4,6,8,10]
assert odd == [1,3,5,7,9]

def map = [language: 'Groovy', username: 'mrhaki', age: 36]
def (strings, others) = map.split { it.value instanceof String }
assert strings.size() == 2
assert others.size() == 1
assert strings[0].key == 'language'
assert strings[0].value == 'Groovy'
assert strings[1].key == 'username'
assert strings[1].value == 'mrhaki'
assert others[0].key == 'age'
assert others[0].value == 36
