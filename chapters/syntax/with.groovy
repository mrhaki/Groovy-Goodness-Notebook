class Sample {
    String username
    String email
    List<String> labels = []
    def speakUp() { "I am $username" }
    def addLabel(value) { labels << value }
}

def sample = new Sample()
sample.with {
    username = 'mrhaki'
    email = 'email@host.com'
    println speakUp()  // Output: I am mrhaki
    addLabel 'Groovy'
    addLabel 'Java'
}
assert sample.labels.size() == 2
assert sample.labels[0] == 'Groovy'
assert sample.labels[1] == 'Java'
assert sample.username == 'mrhaki'
assert sample.email == 'email@host.com'

def sb = new StringBuilder()
sb.with {
    append 'Just another way to add '
    append 'strings to the StringBuilder '
    append 'object.'
}

assert sb.toString() == 'Just another way to add strings to the StringBuilder object.'

// Another example as seen at
// http://javajeff.blogspot.com/2008/11/getting-groovy-with-with.html
def cal = Calendar.instance
cal.with {
    clear()
    set(YEAR, 2009)
    set MONTH, SEPTEMBER
    set DATE, 4
    add DATE, 2
}
assert cal.time.format('MMMM d, yyyy') == 'September 6, 2009'
