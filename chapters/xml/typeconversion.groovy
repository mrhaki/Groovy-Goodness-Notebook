def xml = '''
<users>
    <user loggedin="true">
        <age>36</age>
        <name>mrhaki</name>
        <fullname>Hubert A. Klein Ikkink</fullname>
        <homepage>http://www.mrhaki.com/</homepage>
    </user>
</users>
'''

def users = new XmlSlurper().parseText(xml)
def mrhaki = users.user[0]
assert mrhaki.@loggedin.toBoolean()
assert mrhaki.age.toInteger() == 36
assert mrhaki.name.toString() == 'mrhaki'
assert mrhaki.homepage.toURL() == new URL('http://www.mrhaki.com/')
