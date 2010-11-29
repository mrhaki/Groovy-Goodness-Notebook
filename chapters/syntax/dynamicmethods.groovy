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

assert 'Hello mrhaki, how are you?', s."$methods[0]"('mrhaki')
assert 'Have a nice trip.', s."$methods[1]"
