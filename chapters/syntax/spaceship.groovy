class Person implements Comparable {
    String username
    String email

    int compareTo(other) {
        this.username <=> other.username
    }
}

assert ('a' <=> 'b') == -1
assert (42 <=> 42) == 0
assert (new Person([username:'mrhaki', email: 'test@email.com']) <=> new Person([username:'zavaria', email:'tester@email.com'])) == -1
assert [4, 2, 1, 3].sort{ a, b -> a <=> b } == [1, 2, 3, 4]
