def map = [username: 'mrhaki']
assert '["username":"mrhaki"]' == map.inspect()

def list = [1, 2, 3, 'Groovy']
assert '[1, 2, 3, "Groovy"]' == list.inspect()

def range = 0..10
assert '0..10' == range.inspect()

def str = 'Inspecting object with Groovy'
assert '"Inspecting object with Groovy"' == str.inspect()

def dom = groovy.xml.DOMBuilder.newInstance().parseText('<root><language>Groovy</language></root>')
println dom.documentElement.inspect()
// Output:
// <?xml version="1.0" encoding="UTF-8"?>
// <root>
//   <language>Groovy</language>
// </root>
/**
 * Created by IntelliJ IDEA.
 * User: mrhaki
 * Date: Nov 30, 2010
 * Time: 8:26:37 PM
 * To change this template use File | Settings | File Templates.
 */
