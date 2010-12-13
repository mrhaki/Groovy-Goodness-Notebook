class Blog {
    String name
    String subject

    Blog() {}

    Blog(String name, String subject) {
        this.name = name
        this.subject = subject
    }
}

def blog = Blog.newInstance()
assert !blog.name, 'Name has no value'
assert !blog.subject, 'Subject has no value'

def blog2 = Blog.newInstance(['mrhaki', 'Groovy'] as Object[])
assert blog2.name == 'mrhaki'
assert blog2.subject == 'Groovy'

def blog3 = Blog.newInstance([name:'mrhaki', subject: 'Groovy'])
assert blog3.name == 'mrhaki'
assert blog3.subject == 'Groovy'
