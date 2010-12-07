// Suppose we have a environment variable GROOVY_HOME
// pointing to the Groovy installation dir.
def groovyHome = System.getenv('GROOVY_HOME')

def includeFiles = '**/*.txt'
def excludeFiles = '**/*.doc **/*.pdf'
def txtFiles = new FileNameFinder().getFileNames(groovyHome, includeFiles, excludeFiles)
assert new File(groovyHome, 'README.txt').absolutePath in txtFiles

// Use FileNameByRegexFinder to search with
// a regular expression.
def icoFiles = new FileNameByRegexFinder().getFileNames(groovyHome, /.*\.ico/)
assert new File(groovyHome, 'html/groovy-jdk/groovy.ico').absolutePath in icoFiles
