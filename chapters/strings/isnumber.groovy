def n = '42.01'
def i = '201'

assert n.isNumber() && n.isBigDecimal() && n.isFloat() && n.isDouble()
assert i.isInteger() && i.isLong() && i.isBigInteger()


assert '42'.isNumber()
assert '42'.isInteger() && '42'.isLong() && '42'.isBigInteger()
assert '42.42'.isDouble() && /42.42/.isBigDecimal() && '42.42'.isFloat()
