// Two simple closure with one and two parameters.
def oneArg = { it.toUpperCase() }
def twoArg = { String s, upper ->
    if (upper) {
        s.toUpperCase()
    } else {
        s.toLowerCase()
    }
}

// Closure with check for number of parameters and types.
def runClosure(cl) {
    switch (cl.maximumNumberOfParameters) {
        case 1:
            assert cl.parameterTypes == [java.lang.Object]
            cl.call('Groovy')
            break
        case 2:
            assert cl.parameterTypes == [java.lang.String, java.lang.Object]
            cl('Groovy', false)
            break
    }
}

assert runClosure(oneArg) == 'GROOVY'
assert runClosure(twoArg) == 'groovy'
