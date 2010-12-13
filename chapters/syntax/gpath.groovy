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
assert String.metaClass.methods.name.size() == 75
assert String.metaClass.methods.findAll { it.static }.name.unique() == ['copyValueOf', 'format', 'valueOf']
assert String.metaClass.methods.name.grep(~/replace.*/) == ['replace', 'replace', 'replaceAll', 'replaceFirst']
assert String.metaClass.properties.name == ['class', 'bytes', 'empty']
assert String.metaClass.properties.type.canonicalName == ['java.lang.Class', 'byte[]', 'boolean']
