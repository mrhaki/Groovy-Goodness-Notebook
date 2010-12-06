// Grep result depends on argument we use.
assert ['test', 12, 20, true].grep(Boolean) == [true] // Class isInstance
assert ['test', 'Groovy', 'Java'].grep(~/^G.*/) == ['Groovy'] // Pattern match
assert ['a', 'b', 'c', 'd'].grep(['b', 'c']) == ['b', 'c'] // List contains
assert [1, 15, 16, 30, 12].grep(12..18) == [15, 16, 12] // Range contains
assert [12.300, 109.20, 42.031, 42.032].grep(42.031) == [42.031] // Object equals
assert [10, 20, 30, 50, 100, 200].grep({ it > 50 }) == [100, 200] // Closure boolean
