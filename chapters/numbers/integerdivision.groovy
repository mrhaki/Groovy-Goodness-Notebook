def x = 26
def y = 10

def resultDiv = x.div(y)  // or x / y
def resultIntDiv = x.intdiv(y) // Integer division

assert resultDiv == 2.6
assert resultIntDiv == 2
assert resultDiv.class == java.math.BigDecimal
assert resultIntDiv.class == java.lang.Integer
