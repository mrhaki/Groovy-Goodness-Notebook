import static java.util.Calendar.*

def cal = Calendar.instance
cal[MONTH] = DECEMBER
def calNextMonth = cal.updated(month: cal[MONTH] + 1, year: 2012)

assert calNextMonth[MONTH] == JANUARY
assert calNextMonth[YEAR] == 2013

def date = new Date()
date.set(year: 2011, month: MAY, date: 5)
def dateTenYearsAgo = date.updated(year: date[YEAR] - 10)

assert date.format('yyyy-M-d') == '2011-5-5'
assert dateTenYearsAgo.format('yyyy-M-d') == '2001-5-5'
