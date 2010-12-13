def s = 'one two three four'

def resultList = s.tokenize()
assert resultList.class.name == 'java.util.ArrayList'
assert resultList == ['one', 'two', 'three', 'four']

def resultArray = s.split()
assert resultArray instanceof String[]
assert resultArray == ['one', 'two', 'three', 'four']

def s1 = 'Java:Groovy'
assert s1.tokenize(":") == ['Java', 'Groovy']
assert s1.tokenize(':' as char) == ['Java', 'Groovy']
