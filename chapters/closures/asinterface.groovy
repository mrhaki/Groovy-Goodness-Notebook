def baseDir = new File('interfaces')
baseDir.mkdir()
('a'..'e').each {
    def file = new File(baseDir, "${it}.txt")
    file << 'sample'
}

def filter = { it.path ==~ /.*\.txt$/ } as FileFilter
assert baseDir.listFiles(filter).size() == 5
