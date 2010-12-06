// Closure with default single 'it' argument.
def minusOne = { it - 1 }
assert minusOne('Groovy String with 1.') == 'Groovy String with .'
assert minusOne(42) == 41

// Closure with single named argument.
def namedArg = { value -> value * 2 }
assert namedArg('Groovy ') == 'Groovy Groovy '
assert namedArg(42) == 84

// Closure with multiple named arguments.
def moreArgs = { a, b -> a + b }
assert moreArgs('Groovy ', 'Java') == 'Groovy Java'
assert moreArgs(42, 2) == 44

// Closure without arguments, even no 'it'.
def noArgs = { -> 'Groovy closure without arguments' }
assert noArgs() == 'Groovy closure without arguments'
