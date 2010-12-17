//TODO
map = [
    // Implement FileFilter.accept(File) method.
    accept: { file -> file.path ==~ /.*\.(css|png)$/ }
] as FileFilter
new File('c:/temp').listFiles(map).each {
    println it.path
}