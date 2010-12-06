// Find items in a list in different ways.
def list = ['Daffy', 'Bugs', 'Elmer', 'Tweety', 'Silvester', 'Yosemite']
assert list.find { it == 'Bugs' } == 'Bugs'
assert list.findAll { it.size() < 6 } == ['Daffy', 'Bugs', 'Elmer']
assert list.findIndexOf { name -> name =~ /^B.*/ } == 1 // Start with B.
assert list.findIndexOf(3) { it[0] > 'S' }  == 3// Use a start index.
assert list.findIndexValues { it =~ /(y|Y)/ } == [0, 3, 5] // Contains y or Y.
assert list.findIndexValues(2) { it =~ /(y|Y)/ } == [3, 5]
assert list.findLastIndexOf { it.size() == 5 } == 2
assert list.findLastIndexOf(1) { it.count('e') > 1 } == 5
assert list.any { it =~ /a/ }
assert list.every { it.size() > 3 }

// Find items in a map.
def map = [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com', blog: true]
def found = map.find { key, value -> key == 'name' }
assert found.key == 'name'
assert found.value == 'Messages from mrhaki'
found = map.find { it.value =~ /mrhaki/ }
assert found.key == 'name'
assert found.value == 'Messages from mrhaki'
assert map.findAll { key, value ->
    value =~ /mrhaki/
} == [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com']
assert map.findIndexOf { it.value.endsWith('com') } == 1
assert map.findIndexValues { it.key =~ /l/ } == [1, 2]  // All keys with the letter 'l'.
assert map.findLastIndexOf { it.key =~ /l/ && it.value } == 2
assert map.any { entry -> entry.value }
assert map.every { key, value -> key.size() >= 3 }
