def list = [0, 1, 2, 1, 1, 3, 2, 0, 1]

assert list.size() == 9
assert list.count(0) == 2  // Count number of 0's
assert list.count(1) == 4  // Count number of 1's
assert list.count(2) == 2  // Count number of 2's
assert list.count(3) == 1  // Count number of 3's
