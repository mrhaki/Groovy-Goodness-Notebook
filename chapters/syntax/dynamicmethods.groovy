class Simple {
    def hello(value) {
        "Hello $value, how are you?"
    }

    def goodbye() {
        "Have a nice trip."
    }
}

def simple = new Simple()
def methods = ['hello', 'goodbye']

assert simple."${methods[0]}"('mrhaki') == 'Hello mrhaki, how are you?'
assert simple."${methods[1]}"() == 'Have a nice trip.'
