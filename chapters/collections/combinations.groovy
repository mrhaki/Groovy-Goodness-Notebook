def classes = ['Object[]', 'Collection']
def methods = ['min', 'max']

// Make possible combinations of both lists.
def combinations = [classes, methods].combinations()

assert combinations.size() == 2 * 2
assert combinations == [['Object[]', 'min'], ['Collection', 'min'], ['Object[]', 'max'], ['Collection', 'max']]
assert combinations.findAll { it[0] == 'Collection' }.size() == 2
