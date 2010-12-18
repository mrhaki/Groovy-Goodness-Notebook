import groovy.io.FileType

// First create sample dirs and files.
def basedir = new File('filetypes')
basedir.mkdir()
(1..3).each {
    new File(basedir, "dir$it").mkdir()
}
(1..3).each {
    def file = new File(basedir, "file$it")
    file << "Sample content for ${file.absolutePath}"
}

def currentDir = new File(basedir)
def dirs = []
// Use FileType.DIRECTORIES to only work with directories.
currentDir.eachFile FileType.DIRECTORIES, {
    dirs << it.name
}
assert dirs.join(',') == 'dir1,dir2,dir3'

def files = []
// Use FileType.FILES to only work with files.
currentDir.eachFileMatch(FileType.FILES, ~/file\d/) {
    files << it.name
}
assert files.join(',') == 'file1,file2,file3'

def found = []
// FileType.ANY works with both directories and files.
currentDir.eachFileMatch(FileType.ANY, ~/.*2/) {
   found << it.name
}

assert found.join(',') == 'dir2,file2'
