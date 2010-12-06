def languages = ['Groovy', 'Clojure', 'Scala']

def sequences = languages.subsequences()

assert sequences.findAll { it.size() == 1 } as List ==  [['Clojure'], ['Scala'], ['Groovy']]
assert sequences.findAll { it.size() == 2 } as List == [['Clojure', 'Scala'], ['Groovy', 'Scala'], ['Groovy', 'Clojure']]
assert sequences.findAll { it.size() == 3}.toList() == [['Groovy', 'Clojure', 'Scala']]
