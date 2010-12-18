def abc = ['a', 'b', 'c']
assert abc.join() == 'abc'
assert abc.join('::') == 'a::b::c'

def numbers = [0, 1, 2, 3, 4, 5] as Integer[]
assert numbers.join() == '012345'
assert numbers.join(' x ') == '0 x 1 x 2 x 3 x 4 x 5'
assert numbers.join(' ') == '0 1 2 3 4 5'

// Object toString() method is invoked when necessary.
def objects = [new URL('http://www.mrhaki.com'), 'mrhaki', new Expando(name: 'mrhaki'), new Date(110, 10, 10)]
assert objects.join(',') == 'http://www.mrhaki.com,mrhaki,{name=mrhaki},Wed Nov 10 00:00:00 CET 2010'

// Also great for creating URL query parameters.
def map = [q: 'groovy', maxResult: 10, start: 0, format: 'xml']
def params = map.inject([]) { result, entry ->
    result << "${entry.key}=${URLEncoder.encode(entry.value.toString())}"
}.join('&')
assert params == 'q=groovy&maxResult=10&start=0&format=xml'
