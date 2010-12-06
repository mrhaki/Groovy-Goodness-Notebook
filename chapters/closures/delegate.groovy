// Script variable and method.
count = 0
def info() {
    "Count value is $count."
}
// Closure to increment a count variable and invoke a info() method.
def printInfo = {
    count++
    info()
}
// Delegate is by default set to owner, so the script in this case.
assert printInfo() == "Count value is 1."

// Simple class to show closure delegate feature.
class Post {
    int count
    def info() { "This is Groovy Goodness post #$count!" }
}
// Change closure resolver so first the delegate is used.
printInfo.resolveStrategy = Closure.DELEGATE_FIRST
// Set delegate to Post object.
printInfo.delegate = new Post(count: 100)
// Invoke closure again.
assert printInfo() == "This is Groovy Goodness post #101!"
