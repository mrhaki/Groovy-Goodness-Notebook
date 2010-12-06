def list = [10, 20, 30]

assert list.reverse() == [30, 20, 10]
assert list[-1..0] == [30, 20, 10]

def result = []
list.reverseEach {
    result << it * 2
}

assert result == [60, 40, 20]


def reversed = [:]
[a: 1, c: 3, b: 2].reverseEach { key, value ->
    reversed[key] = value ** 2
}

assert reversed == [b: 4, c: 9, a: 1]

// TreeMap uses natural ordering of keys, so
// reverseEach starts with key 'c'.
def tree = [a: 10, c: 30, b: 20] as TreeMap
def reversedMap = [:]
tree.reverseEach {
    reversedMap[it.key] = it.value * 2
}
assert reversedMap == [c: 60, b: 40, a: 20]
