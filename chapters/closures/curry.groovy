//TODO// Simple curry sets value of first argument.
def addNumbers = { x, y -> x + y }
def addOne = addNumbers.curry(1)
assert addOne(4) == 5

// General closure to use a filter on a list.
def filterList = { filter, list -> list.findAll(filter) }
// Closure to find even numbers.
def even = { it % 2 == 0 }
// Closure to find odd numbers.
def odd = { !even(it) }
// Other closures can be curry parameters.
def evenFilterList = filterList.curry(even)
def oddFilterList = filterList.curry(odd)
assert [0,2,4,6,8] == evenFilterList(0..8)
assert [1,3,5,7] == oddFilterList(0..8)

// Recipe to find text in lines.
def findText = { filter, handler, text ->
    text.eachLine {
        filter(it) ? handler(it) : null
    }
}
// Recipe for a regular expression filter.
def regexFilter = { pattern, line -> line =~ pattern }

// Create filter for searching lines with "Groovy".
def groovyFilter = regexFilter.curry(/Groovy/)
// Create handler to print out line.
def printHandler = { println "Found in line: $it" }

// Create specific closure as clone of processText to
// search with groovyFilter and print out found lines.
def findGroovy = findText.curry(groovyFilter, printHandler)

// Invoke the closure.
findGroovy('''Groovy rules!
And Java?
Well... Groovy needs the JVM...
''')
// This will output:
// Found in line: Groovy rules!
// Foudn in line: Well... Groovy needs the JVM...


@Grab('commons-lang:commons-lang:2.5')
import org.apache.commons.lang.RandomStringUtils as RSU

def randomClosure = { size, letters, numbers ->
    // Invoke RandomStringUtils.random() method.
    RSU.random size, letters, numbers
}

def randomNumbers = randomClosure.rcurry(false, true)  // letters = false, numbers = true
def randomLetters = randomClosure.ncurry(1, true, false) // letters = true, numbers = false

println randomClosure(10, true, true)  // Sample output: VG7mffNAdA
println randomNumbers(10)              // Sample output: 8099670444
println randomLetters(10)              // Sample output: ZOHlHewEPU
