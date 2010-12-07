def file = new File('test.groovy')
file.text = 'simple content'
file.renameTo 'newname.groovy'

def newFile = new File('newname.groovy')
assert newFile.exists()
assert newFile.text == 'simple content'
