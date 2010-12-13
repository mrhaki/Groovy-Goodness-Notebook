class Simple {
    def hello(value) {
        "Hello $value, how are you?"
    }

    def goodbye() {
        "Have a nice trip."
    }
}

def s = new Simple()
def methods = ['hello', 'goodbye']

assert s."$methods[0]"('mrhaki') == 'Hello mrhaki, how are you?'
assert s."$methods[1]" == 'Have a nice trip.'
