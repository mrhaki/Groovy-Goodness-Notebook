def finder = ('groovy' =~ /gr.*/)
assert finder instanceof java.util.regex.Matcher

def matcher = ('groovy' ==~ /gr.*/)
assert matcher instanceof Boolean

assert 'Groovy rocks!' =~ /Groovy/  // =~ in conditional context returns boolean.
assert !('Groovy rocks!' ==~ /Groovy/)  // ==~ looks for an exact match.
assert 'Groovy rocks!' ==~ /Groovy.*/

def cool = /gr\w{4}/  // Start with gr followed by 4 characters.
def findCool = ('groovy, java and grails rock!' =~ /$cool/)
assert findCool.count == 2
assert findCool.size() == 2  // Groovy adds size() method.
assert findCool[0] == 'groovy'  // Array-like access to match results.
assert findCool.getAt(1) == 'grails'

// With grouping we get a multidimensional array.
def group = ('groovy and grails, ruby and rails' =~ /(\w+) and (\w+)/)
assert group.hasGroup()
assert group.size() == 2
assert group[0] == ['groovy and grails', 'groovy', 'grails']
assert group[1][2] == 'rails'

// Use matcher methods.
assert ('Hello world' =~ /Hello/).replaceFirst('Hi') == 'Hi world'

// Groovy matcher syntax can be used in other methods.
assert ['def', 'abc', '123'].findAll { it =~ /abc/ } == ['abc']
assert ['def', 'abc', '123'].collect { it ==~ /\d{3}/ } == [false, false, true]
