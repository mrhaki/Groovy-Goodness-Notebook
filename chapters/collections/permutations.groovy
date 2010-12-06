def languages = ['Groovy', 'Clojure', 'Scala']

def result = []
languages.eachPermutation {
    result << it
}

assert result.size() == 6
assert result[0] == ['Groovy', 'Clojure', 'Scala']
assert result[1] == ['Groovy', 'Scala', 'Clojure']
assert result.findAll { it[0] == 'Clojure' } == [['Clojure', 'Groovy', 'Scala'], ['Clojure', 'Scala', 'Groovy']]

// We can also get the complete list of permutations as Set.
def list = [true, false]
def permutations = list.permutations()
assert permutations.size() == 2
assert permutations == [[false,true], [true,false]] as Set 
