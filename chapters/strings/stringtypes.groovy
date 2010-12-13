// Single quotes:
def s1 = 'Yep this is a string, and we can use "double quotes" without escaping them.'
def m1 = '''With three quotes
we can write multi-line strings, without all
the hassle of concatenation.'''

// Double quotes:
def s2 = "Also a string, and of course we can use 'single quotes' without escaping them."
def m2 = """\
With three double quotes we can have a multi-line string,
and we don't need to add extra + signs. Very easy for
copy-paste."""

// Slashy:
def s3 = /Well almost everyting goes in a "slashy" 'string' without escaping. Good for readable regular expressions!/


// Simple Groovy expressions can be used in a GString:
def user = new Expando(name: 'mrhaki', email: 'mail@email.com')
def gs1 = "Hi, your name is ${user?.name}. If I shout I will call you ${user?.name?.toUpperCase()}!"
assert gs1 == 'Hi, your name is mrhaki. If I shout I will call you MRHAKI!'

// Works also in triple double quoted multi-line strings:
def mailMessage = """
Hi ${user?.name},

thank you for signing up.
You signed up with the following e-mail address:

${user?.email}

Kind regards,

the support team.
"""
assert mailMessage == '''
Hi mrhaki,

thank you for signing up.
You signed up with the following e-mail address:

mail@email.com

Kind regards,

the support team.
'''

// We can use closures in GStrings to do lazy evaluation.
// The closure is evaluated when the toString() method on the
// GString is invoked instead of when the GString is created.
// Closures can have zero or one arguments. With one argument we get a writer
// object we can write to, with zero arguments the toString() is called on the
// closure.
def directEval = "Current name value is ${user.name} and email is ${user.email}."
def lazyEval = "Current name value is ${ -> user.name } and email is ${ out -> out << user.email }."
user.name = 'changed username'
user.email = 'changed email'
assert directEval == 'Current name value is mrhaki and email is mail@email.com.'
assert lazyEval == 'Current name value is changed username and email is changed email.'
