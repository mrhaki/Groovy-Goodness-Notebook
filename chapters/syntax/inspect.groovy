def map = [username: 'mrhaki']
assert map.inspect() == '["username":"mrhaki"]'

def list = [1, 2, 3, 'Groovy']
assert list.inspect() == '[1, 2, 3, "Groovy"]'

def range = 0..10
assert range.inspect() == '0..10'

def str = 'Inspecting object with Groovy'
assert str.inspect() == '"Inspecting object with Groovy"'
//TODO
def dom = groovy.xml.DOMBuilder.newInstance().parseText('<root><language>Groovy</language></root>')
println dom.documentElement.inspect()
// Output:
// <?xml version="1.0" encoding="UTF-8"?>
// <root>
//   <language>Groovy</language>
// </root>

