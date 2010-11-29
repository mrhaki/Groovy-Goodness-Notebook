def methods = ['min', 'max', 'sum']
def classes = ['Object[]', 'Collection']

def combinations = GroovyCollections.combinations([classes, methods])
assert 2 * 3 == combinations.size()
assert [['Object[]', 'min'], ['Collection', 'min'], ['Object[]', 'max'], ['Collection', 'max'], ['Object[]', 'sum'], ['Collection', 'sum']] == combinations
assert 3 == combinations.findAll { it[0] == 'Collection' }.size()
