import groovy.xml.*

def xml = '''
<books xmlns:meta="http://meta/book/info" count="3">
  <book id="1">
    <title lang="en">Groovy in Action</title>
    <meta:isbn>1-932394-84-2</meta:isbn>
  </book>
  <book id="2">
    <title lang="en">Groovy Programming</title>
    <meta:isbn>0123725070</meta:isbn>
  </book>
  <book id="3">
    <title>Groovy &amp; Grails</title>
    <!--Not yet available.-->
  </book>
  <book id="4">
    <title>Griffon Guide</title>
  </book>
</books>
'''

def books = new XmlSlurper().parseText(xml).declareNamespace([meta:'http://meta/book/info'])
assert books instanceof groovy.util.slurpersupport.GPathResult
assert books.book.size() == 4
assert books.breadthFirst().size() == 11
assert books.book[0].title == 'Groovy in Action'
assert books.book.find { it.@id == '2' }.title == 'Groovy Programming'
assert books.book.findAll { it.title =~ /Groovy/ }.'@id'.list() == [1, 2, 3]
assert books.book.'meta:isbn'.list() == ['1-932394-84-2', '0123725070']
