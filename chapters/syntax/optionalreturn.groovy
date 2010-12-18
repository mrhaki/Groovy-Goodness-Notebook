def simple() {
    "Hello world"
}
assert simple() == 'Hello world'

def doIt(b) {
    if (b) {
        "You are true"
    } else {
        "You are false"
    }
}
assert doIt(true) == 'You are true'
assert doIt(false) == 'You are false'

def tryIt(file) {
    try {
        new File(file).text
    } catch (e) {
        "Received exception: ${e.message}"
    } finally {
        println 'Finally is executed but nothing is returned.'
        'Finally reached'
    }
}
assert tryIt('invalidfilename') == 'Received exception: invalidfilename (No such file or directory)'
// Create new file with the name test, so we can read it.
new FileWriter('test').withWriter { it.write('file contents') }
assert tryIt('test') == 'file contents'
