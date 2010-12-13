class Author {
    String name
    List books
}
class Book {
    String title
}

def createKing() {
    new Author(name: 'Stephen King', books: [
        new Book(title: 'Carrie'),
        new Book(title: 'The Shining'),
        new Book(title: 'It')
    ])
}

assert createKing().books.size() == 3
assert createKing().name == 'Stephen King'
assert createKing().books.getAt(0).title == 'Carrie'

@Newify
def createKingRuby() {
    Author.new(name: 'Stephen King', books: [
        Book.new(title: 'Carrie'),
        Book.new(title: 'The Shining'),
        Book.new(title: 'It')
    ])
}

assert createKingRuby().books.size() == 3
assert createKingRuby().name == 'Stephen King'
assert createKingRuby().books.title.join(', ') == 'Carrie, The Shining, It'

@Newify([Author, Book])
def createKingPython() {
    Author(name: 'Stephen King', books: [
        Book(title: 'Carrie'),
        Book(title: 'The Shining'),
        Book(title: 'It')
    ])
}

assert createKingPython().books.size() == 3
assert createKingPython().name == 'Stephen King'
assert createKingPython().books.title.find { it == 'It' } == 'It'
