import static java.net.HttpURLConnection.HTTP_OK  // Normal Java static import.
import static java.net.HttpURLConnection.HTTP_OK as okay
import static java.net.HttpURLConnection.setFollowRedirects as redirect
import java.net.HttpURLConnection as http // Non static import.

redirect false  // HttpURLConnection.setFollowRedirects(false)
assert HttpURLConnection.followRedirects == false

def c = (http) 'http://mrhaki.blogspot.com'.toURL().openConnection()
assert c instanceof HttpURLConnection

assert okay == c.responseCode
assert HTTP_OK == c.responseCode
