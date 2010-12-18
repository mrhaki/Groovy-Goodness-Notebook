import static groovy.io.FileType.*

// We build a sample dir structure so we can
// test the traversing.
def basedir = new File('traverse-sample')
basedir.mkdirs()
(1..15).each { counter ->
    def subdir = new File(basedir, "sub$counter")
    subdir.mkdirs()
    ['txt', 'doc'].each { ext ->
        def file = new File(subdir, "sample${counter}.$ext")
        file.write 'sample'
    }
}

def countFilesAndDirs = 0
basedir.traverse {
    countFilesAndDirs++
}
assert countFilesAndDirs == 45

def totalFileSize = 0
def txtFileCount = 0
def sumFileSize = {
    totalFileSize += it.size()
    txtFileCount++
}
def filterTxtFiles = ~/.*\.txt$/
basedir.traverse type: FILES, visit: sumFileSize, nameFilter: filterTxtFiles
assert txtFileCount == 15
assert totalFileSize == 90

def dirsWithSmallFiles = []
def countSmallFiles = 0
def postDirVisitor = {
    if (countSmallFiles > 0) {
        dirsWithSmallFiles << it.name
    }
    countSmallFiles = 0
}

basedir.traverse(type: FILES, postDir: postDirVisitor, nameFilter: ~/.*\.doc/) {
    if (it.name.size() < 12) {
        countSmallFiles++
    }
}
assert dirsWithSmallFiles == ['sub1', 'sub2', 'sub3', 'sub4', 'sub5', 'sub6', 'sub7', 'sub8', 'sub9']
