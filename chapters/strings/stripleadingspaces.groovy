def multi = '''\
  Multiline string
  with simple 2 space
  indentation.'''

assert multi.stripIndent() == '''\
Multiline string
with simple 2 space
indentation.'''

// We can define the number of characters ourselves as well.
assert multi.stripIndent(8) == '''\
ine string
imple 2 space
ation.'''
