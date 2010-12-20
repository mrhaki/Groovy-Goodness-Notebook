def baseDir = new File('interfaces')
baseDir.mkdir()
('a'..'e').each {
    def file = new File(baseDir, "${it}.txt")
    file << 'sample'
}

def map = [
    // Implement FileFilter.accept(File) method.
    accept: { file -> file.name ==~ /.*\.txt$/ }
] as FileFilter
assert baseDir.listFiles(map).size() == 5
