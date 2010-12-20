// Groovy adds the minus() method to the String class.
def s = 'Groovy and Strings are fun and versatile.'

assert s - ' and versatile.' == 'Groovy and Strings are fun' // We can use the '-' operator.
assert s.minus(" and versatile") == 'Groovy and Strings are fun.'
assert s - ~/\b\w{3}\b/ == 'Groovy  Strings are fun and versatile.'
