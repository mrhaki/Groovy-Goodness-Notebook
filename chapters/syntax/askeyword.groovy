import java.text.MessageFormat as mf // Alias mf

// Use alias and use as to convert list to Object[]:
assert mf.format('Simple {0}!', ['message'] as Object[]) == 'Simple message!'

// Normal Groovy list:
def intList = [1,2,3,4]
assert intList.class.name =='java.util.ArrayList'
assert intList.size() == 4

// Coerse to int[]:
def intArray = intList as int[]
assert intArray.class.name != 'java.util.ArrayList'
assert intArray.length == 4 // Use int[] property.

// Use as to create Date object from list:
def date = [109, 8, 6] as Date
assert date[Calendar.YEAR] == 2009
assert date[Calendar.MONTH] == 8
assert date[Calendar.DATE] == 6

// Use as to treat closure as implementation for
// an interface:
def t = new Thread({ println 'hello' } as Runnable)
t.start()  // Output: hello

// Use as to treat map as implementation for
// an interface:
def t2 = new Thread([run: { println 'hello' }] as Runnable)
t2.start()  // Output: hello
