def text = 'First line\r\nSecond line\r\n'
def textNormalized = text.normalize()
def LS = System.properties['line.separator']

assert textNormalized == 'First line\nSecond line\n'
assert textNormalized.denormalize() == "First line${LS}Second line${LS}"
