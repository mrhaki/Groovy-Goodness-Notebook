def stringArray = new String[3]
assert stringArray instanceof String[]
stringArray[0] = 'mrhaki'
stringArray.putAt(1, 'Groovy')  // New syntax.
stringArray[2] = 'Java'

assert stringArray.getAt(0) == 'mrhaki'  // Just another way to get a value.
assert stringArray[1] == 'Groovy'
assert stringArray[-1] == 'Java' // Negative indeces allowed.
assert stringArray[0..1] == ['mrhaki', 'Groovy'] // We can use ranges.
assert stringArray[0, 2] == ['mrhaki', 'Java']

assert stringArray.length == 3  // Normal length property for arrays.
assert stringArray.size() == 3 // Groovy adds size() method as well.

// We can use min() and max() methods.
assert [102,301,42,83].min() == 42
assert [102,301,42,83].max() == 301
assert stringArray.min { it.size() } == 'Java'
assert stringArray.max { it[0] as char } == 'mrhaki'

// We can even use the Collection GDK methods on an array.
stringArray.eachWithIndex { value, idx -> assert stringArray[idx] == value }
assert stringArray.collect { it.reverse() } == ['ikahrm', 'yvoorG', 'avaJ']
assert stringArray.find { it =~ /Groovy/ } == 'Groovy'

// We can remove values with the '-' operator.
assert stringArray - 'mrhaki' == ['Groovy', 'Java']

// Other useful methods for arrays.
assert stringArray.reverse() == ['Java', 'Groovy', 'mrhaki']
assert stringArray.sort() == ['Groovy', 'Java', 'mrhaki']
assert stringArray.count('mrhaki') == 1

// Convert to ArrayList.
def strList = stringArray.toList()
assert strList.class.name == 'java.util.ArrayList'

// Convert ArrayList to array object.
def otherArray = strList as String[]
assert otherArray instanceof String[]
