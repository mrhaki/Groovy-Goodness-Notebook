// Result variable for storing loop results.
def result = ''
// Closure to fill result variable with value.
def createResult = {
    if (!it) {  // A bit of Groovy truth: it == 0 is false
        result = '0'
    } else {
        result += it
    }
}

// Classic for loop.
for (i = 0; i < 5; i++) {
    createResult(i)
}
assert result == '01234'

// Using int.upto(max).
0.upto(4, createResult)
assert result == '01234'

// Using int.times.
5.times(createResult)
assert result == '01234'

// Using int.step(to, increment).
0.step 5, 1, createResult
assert result == '01234'

// Classic while loop.
def z = 0
while (z < 5) {
    createResult(z)
    z++
}
assert result == '01234'

def list = [0, 1, 2, 3, 4]

// Classic Java for-each loop.
for (int i : list) {
    createResult(i)
}
assert result == '01234'

// Groovy for-each loop.
for (i in list) {
    createResult(i)
}
assert result == '01234'

// Use each method to loop through list values.
list.each(createResult)
assert result == '01234'

// Ranges are lists as well.
(0..4).each(createResult)
assert result == '01234'

// eachWithIndex can be used with closure: first parameter is value, second is index.
result = ''
list.eachWithIndex { listValue, index -> result += "$index$listValue" }
assert result == '0011223344'
