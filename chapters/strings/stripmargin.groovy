def s = '''\
        |Groovy
        |Grails
        |Griffon'''

assert s.stripMargin() == '''\
Groovy
Grails
Griffon'''

def s1 = '''\
   * Gradle
   * GPars
   * Spock'''

assert s1.stripMargin("* ") == '''\
 Gradle
 GPars
 Spock'''
