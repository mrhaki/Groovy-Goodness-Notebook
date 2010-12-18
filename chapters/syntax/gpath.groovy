def xml = '''
<languages>
    <language id="1" jvm="true">Groovy</language>
    <language id="2" jvm="true">Java</language>
    <language id="3" jvm="false">Ruby</language>
</languages>
'''

def languages = new XmlSlurper().parseText(xml)
// Navigate in XML with GPath.
assert languages.language.size() == 3
assert languages.language.find { it.'@id' = 1 }.text() == 'Groovy'
assert languages.language.collect { it.text() } == ['Groovy', 'Java', 'Ruby']
assert languages.language.find { it = /Groovy/ }['@id'].toInteger() == 1

// Navigating with GPath through object graph.
assert BigDecimal.metaClass.methods.name.size() == 76
assert BigDecimal.metaClass.methods.findAll { it.static }.name.unique() == ['valueOf']
assert BigDecimal.metaClass.methods.name.grep(~/toBigInteger.*/) == ['toBigInteger', 'toBigIntegerExact']
assert BigDecimal.metaClass.properties.name == ['scale', 'class']
assert BigDecimal.metaClass.properties.type.canonicalName == ['int', 'java.lang.Class']
