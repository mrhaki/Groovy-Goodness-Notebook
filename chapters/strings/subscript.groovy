def s = 'Accessing Strings in Groovy is easy.'

assert s[0] == 'A'
assert s.getAt(0) == 'A'
assert s[21..26] == 'Groovy'  // We can use ranges.
assert s[s.indexOf('ea')..-1] == 'easy.'

// We can also use each() method on a String.
s[21..26].each { println "$it-" } // Output: G-r-o-o-v-y-
