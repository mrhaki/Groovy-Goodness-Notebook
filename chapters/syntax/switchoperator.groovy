def testSwitch(val) {
    def result
    switch (val) {
        case ~/^Switch.*Groovy$/:
            result = 'Pattern match'
            break
        case BigInteger:
            result = 'Class isInstance'
            break
        case 60..90:
            result = 'Range contains'
            break
        case [21, 'test', 9.12]:
            result = 'List contains'
            break
        case 42.056:
            result = 'Object equals'
            break
        case { it instanceof Integer && it < 50 }:
            result = 'Closure boolean'
            break
        default:
            result = 'Default'
            break
    }
    result
}

assert testSwitch("Switch to Groovy") == 'Pattern match'
assert testSwitch(42G) == 'Class isInstance'
assert testSwitch(70) == 'Range contains'
assert testSwitch('test') == 'List contains'
assert testSwitch(42.056) == 'Object equals'
assert testSwitch(20) == 'Closure boolean'
assert testSwitch('default') == 'Default'
