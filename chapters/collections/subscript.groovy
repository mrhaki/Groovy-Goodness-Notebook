def list = ['Groovy', 'Grails', 'Griffon', 'Gradle']
def iterator = list.iterator()

assert iterator[0] == 'Groovy'
assert iterator[-1] == 'Gradle'
assert !iterator[1]  // Iterator is exhausted.

iterator = list.iterator()  // Get new iterator.
def newList = []
(0..<list.size()).each {
 newList << iterator[0]  // Index 0 is next element.
}
assert newList.join(',') == 'Groovy,Grails,Griffon,Gradle'

class User { String name }
def listObjects = [new Date(), new User(name: 'mrhaki'), 42.0, 'Groovy Rocks!']

assert listObjects['class']['name'] == ['java.util.Date', 'User', 'java.math.BigDecimal', 'java.lang.String']

def languages = ['Java', 'Groovy', 'Scala']

def index = 0
def indices = [0,2]
def range = (1..-1)

assert languages[index] == 'Java'
assert languages[indices] ==  ['Java', 'Scala']
assert languages[range] == ['Groovy', 'Scala'] 


