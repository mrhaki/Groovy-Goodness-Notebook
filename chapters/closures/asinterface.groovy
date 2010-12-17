//TODO
filter = { it.path ==~ /.*\.jpg$/ }
new File('c:/temp').listFiles(filter as FileFilter).each { file ->
    println file.path
}
