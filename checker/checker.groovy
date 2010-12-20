dontcheck = ['powerassert', 'padding', 'process', 'grabresolver']

ok = []
fail = []
norun = []

def runScript(scriptFile) {
    def message = "Evaluating '$scriptFile'..."
    def script = (scriptFile.name =~ /(.*)\.groovy$/)[0][1]
    if (script in dontcheck) {
        message = "$message NORUN"
        norun << message
    } else {
        def shell = new GroovyShell()
        try {
            shell.evaluate(scriptFile)
            message = "$message OK"
            ok << message
        } catch (all) {
            message = "$message FAIL"
            fail << message
        }
    }
    println message
}

def basedirName = '/Users/mrhaki/Projects/Groovy-Goodness-Notebook/chapters'
def basedir = new File(basedirName)

basedir.eachDir { dir ->
    dir.eachFileMatch(~/.*\.groovy$/) { file ->
        runScript file
    }
}

def printList(type, messages) {
    println '-' * 80
    println "# scripts $type: ${messages.size()}"
    println '-' * 80
    messages.each { println it }
}

if (ok) {
    printList 'OK', ok
}

if (norun) {
    printList 'NORUN', norun
}

if (fail) {
    printList 'FAIL', fail
}

