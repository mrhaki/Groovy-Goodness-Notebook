// Let's create some sample files with .txt
// and .doc extensions.
['txt', 'doc'].each { ext ->
    (1..5).each {
        def file = new File("file${it}.${ext}")
        file << 'sample'
    }
}

// We can use ANT style include/exclude file patterns.
def includeFiles = '**/*.txt'
def excludeFiles = '**/*.doc'
def txtFiles = new FileNameFinder().getFileNames('.', includeFiles, excludeFiles)
assert new File('file3.txt').absolutePath in txtFiles

// Use FileNameByRegexFinder to search with a regular expression.
// In this sample we look for files ending with .doc extension.
def docFiles = new FileNameByRegexFinder().getFileNames('.', /.*\.doc$/)
assert new File('.', 'file2.doc').absolutePath in docFiles
