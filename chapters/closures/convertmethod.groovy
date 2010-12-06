// Simple list with names.
def names = ['groovy', 'grails', 'mrhaki']

// Simple closure.
names.each { println 'Normal closure says: Hello ' + it + '!' }

// Groovy method to convert to closure.
def groovySays(s) {
    "Groovy says: Hello ${s}!"
}
// Use .& syntax to convert method to closure.
names.each this.&groovySays

// Simple Java class to show we can turn a Java method
// also into a Groovy closure.
public class JavaObject {
    public static String javaSays(final String s) {
        return "Java says: Hello " + s + "!";
    }
}

// Convert Java method to closure and use it.
def javaSays = JavaObject.&javaSays
names.each javaSays
