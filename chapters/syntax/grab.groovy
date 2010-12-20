// With Groovy we can add annotations to import statements.
@Grab(group='commons-lang', module='commons-lang', version='2.4')
import org.apache.commons.lang.SystemUtils

assert SystemUtils.isJavaVersionAtLeast(1.4)
