def list = ['Groovy', 'Clojure', 'Java']

assert list.toListString() == '[Groovy, Clojure, Java]'  // Just as list.toString()
assert list.toString() == '[Groovy, Clojure, Java]'
assert list.toListString(12) == '[Groovy, Clojure, ...]'
