def list = ['Groovy', 'Grails', 'Griffon', 'Gradle']
def iterator = list.iterator()

assert 'Groovy' == iterator[0]
assert 'Gradle' == iterator[-1]
assert !iterator[1]  // Iterator is exhausted.

iterator = list.iterator()  // Get new iterator.
def newList = []
(0..<list.size()).each {
 newList << iterator[0]  // Index 0 is next element.
}
assert 'Groovy,Grails,Griffon,Gradle' == newList.join(',')

class User { String name }
def listObjects = [new Date(), new User(name: 'mrhaki'), 42.0, 'Groovy Rocks!']

assert ['java.util.Date', 'User', 'java.math.BigDecimal', 'java.lang.String'] == listObjects['class']['name']

def languages = ['Java', 'Groovy', 'Scala']

def index = 0
def indices = [0,2]
def range = (1..-1)

assert 'Java' == languages[index]
assert ['Java', 'Scala'] == languages[indices]
assert ['Groovy', 'Scala'] == languages[range]


