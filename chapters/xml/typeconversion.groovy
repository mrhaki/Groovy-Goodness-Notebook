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
assert 36 == mrhaki.age.toInteger()
assert 'mrhaki' == mrhaki.name.toString()
assert new URL('http://www.mrhaki.com/') == mrhaki.homepage.toURL()
