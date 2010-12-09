def single = ~'[ab]test\\d' // Notice the space between = and ~.
assert single.class.name == 'java.util.regex.Pattern'

def dubble = ~"string\$"
assert dubble instanceof java.util.regex.Pattern

// Groovy's String slashy syntax is very useful to
// define patterns, because we don't have to escape
// all those backslashes.
def slashy = ~/slashy \d+ value/
assert slashy instanceof java.util.regex.Pattern

// GString adds a negate() method which is mapped
// to the ~ operator.
def negateSlashy = /${'hello'}GString$/.negate()
assert negateSlashy instanceof java.util.regex.Pattern
def s = 'more'
def curlySlashy = ~"$s GString"
assert curlySlashy instanceof java.util.regex.Pattern

// Using Pattern.matcher() to create new java.util.regex.Matcher.
def testPattern = ~'t..t'
assert testPattern.matcher("test").matches()

// Groovy adds isCase() method to Pattern class.
// Easy for switch and grep statements.
def p = ~/\w+vy$/  // Ends with 'vy', like 'groovy'.
assert p.isCase('groovy')

switch ('groovy') {
    case ~/java/: assert false; break;
    case ~/gr\w{4}/: assert true; break;
    default: assert false
}

// We can use flags in our expressions. In this sample
// we use the case insensitive flag (?i).
// And the grep method accepts Patterns.
def lang = ~/^(?i)gr.*/
def languages = ['java', 'Groovy', 'gRails']
assert languages.grep(lang) == ['Groovy', 'gRails']
