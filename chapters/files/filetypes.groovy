import groovy.io.FileType

// First create sample dirs and files.
(1..3).each {
    new File("dir$it").mkdir()
}
(1..3).each {
    def file = new File("file$it")
    file << "Sample content for ${file.absolutePath}"
}

def currentDir = new File('.')
def dirs = []
// Use FileType.DIRECTORIES to only work with directories.
currentDir.eachFile FileType.DIRECTORIES, {
    dirs << it.name
}
assert dirs.join(',') == 'dir1,dir2,dir3'

def files = []
// Use FileType.FILES to only work with files.
currentDir.eachFile(FileType.FILES) {
    files << it.name
}
assert files.join(',') == 'file1,file2,file3'

def found = []
// FileType.ANY works with both directories and files.
currentDir.eachFileMatch(FileType.ANY, ~/.*2/) {
   found << it.name
}

assert found.join(',') == 'dir,file2'
