def list = [1, 2, 3, 4, 5]
assert 4 == list.max() - 2

/*
assert 4 == list.max() - 2
         |  |    |     |
         |  |    5     3
         |  [1, 2, 3, 4, 5]
         false
*/