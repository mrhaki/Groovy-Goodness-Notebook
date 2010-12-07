import static java.util.Calendar.*

def date = new Date()
// Set value with subscript operator
date[YEAR] = 2010
date[MONTH] = JUNE
date[DATE] = 14

assert date.year == 110
assert date.month == 5
assert date.date == 14

// Get value with subscript operator
assert date[YEAR] == 2010
assert date[MONTH] == JUNE
assert date[DATE] == 14


def cal = Calendar.instance
// Set value with subscript operator
cal[YEAR] = 2000
cal[MONTH] = DECEMBER
cal[DATE] = 25

assert cal.format('yyyy-MM-dd') == '2000-12-25'
assert cal[YEAR] == 2000 // Get value with subscript operator
