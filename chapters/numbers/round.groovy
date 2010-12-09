def doubleValue = 12.5456d

assert doubleValue.round(3) == 12.546d
assert doubleValue.round() == 13

assert doubleValue.trunc() == 12
assert doubleValue.trunc(2) == 12.54d

def floatValue = 987.654f

assert floatValue.round(2) == 987.65f
assert floatValue.round() == 988
assert floatValue.trunc(1) == 987.6f
assert floatValue.trunc() == 987
