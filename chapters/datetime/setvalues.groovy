import static java.util.Calendar.*

def cal = Calendar.instance
// Use set() method to assign property values.
cal.set(year: 2010, month: JULY, date: 9)

assert 'Birthday @ ' + cal.format('yyyy-M-d') == 'Birthday @ 2010-7-9'
assert cal[DAY_OF_WEEK] == FRIDAY

def date = new Date()
// Use set() method to assign property values.
date.set(hourOfDay: 12, minute: 0, second: 0, year: 2010, month: JUNE, date: 1)

assert date.format('HH:mm:ss') == '12:00:00'
assert date[YEAR] == 2010
assert date[MONTH] == JUNE
assert date.getAt(DATE) == 1
