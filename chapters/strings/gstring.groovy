// We can do inquiries on a GString object.
def user = 'mrhaki'
def language = 'Groovy'

def s = "Hello ${user}, welcome to ${language}."

assert s.valueCount == 2  // Count variable parts.
assert s.values == ['mrhaki', 'Groovy']  // We can see the values.
assert s.getValue(0) == 'mrhaki'
assert s.getValue(1) == 'Groovy'
assert s.length() == 32
assert s.strings[0] == 'Hello ' // We can look at the fixed parts.
assert s.strings[1] == ', welcome to '
assert s.strings[2] == '.'
assert s == 'Hello mrhaki, welcome to Groovy.'
