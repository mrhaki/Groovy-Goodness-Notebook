class Simple {

    String multi() {
        '''\
Multiline string
with simple 2 space
indentation.'''
    }

    // Now in Groovy 1.7.3:
    String multi173() {
        '''\
        Multiline string
        with simple 2 space
        indentation.'''.stripIndent()
    }

}


def multi = '''\
  Multiline string
  with simple 2 space
  indentation.'''

assert '''\
Multiline string
with simple 2 space
indentation.''' == multi.stripIndent()

assert '''\
ine string
imple 2 space
ation.''' == multi.stripIndent(8)  // We can define the number of characters ourselves as well.
