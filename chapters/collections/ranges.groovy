// Simple ranges with number values.
def ints = 1..10
assert ints == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
assert ints.size() == 10
assert ints.from == 1
assert ints.to == 10

// We can step through the values.
def list = []
ints.step(2) { list << it }
assert list == [1, 3, 5, 7, 9]

// A range is just a List.
assert ints[0] == 1
assert ints.last() == 10
def s = ''
(2..4).each { s += it }
assert s == '234'

// Exclusive range.
def exclusive = 2..<8
assert exclusive == [2, 3, 4, 5, 6, 7]
assert exclusive.size() == 6
assert !exclusive.contains(8)

// Object with next() and previous() can be used
// in ranges. Groovy extends Java enum with
// next() and previous() so we can use it in ranges.
enum Compass {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST,
    SOUTH, SOUTH_WEST, WEST, NORTH_WEST
}
def northToSouth = Compass.NORTH..Compass.SOUTH
assert northToSouth.size() == 5
assert northToSouth[2] == Compass.EAST
assert northToSouth.contains(Compass.SOUTH_EAST)

// Bonus: next() and previous() are equivalent to
// ++ and -- operators.
def region = Compass.SOUTH
assert ++region == Compass.SOUTH_WEST
assert --region == Compass.SOUTH
