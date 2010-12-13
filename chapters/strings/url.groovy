// Contents of http://www.mrhaki.com/url.html:
// Simple test document
// for testing URL extensions
// in Groovy.

def url = "http://www.mrhaki.com/url.html".toURL()

assert url.text == '''\
Simple test document
for testing URL extensions
in Groovy.
'''

def result = []
url.eachLine {
    if (it =~ /Groovy/) {
        result << it
    }
}
assert result == ['in Groovy.']

url.withReader { reader ->
    assert reader.readLine() == 'Simple test document'
}
