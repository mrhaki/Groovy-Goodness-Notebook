// With the sprintf() method we can format Object values
// according to the java.util.Formatter format rules.
assert sprintf('%2$s %3$s %1$s', ['cool!', 'Groovy', 'is']) == 'Groovy is cool!'
assert sprintf('%05d', 42) == '00042'
