// Create date object with specific year, month and day.
def date = new Date()
date.clearTime()
date.set year: 2010, month: Calendar.AUGUST, date: 10

// Convert to java.sql.Timestamp.
def sqlTimestamp = date.toTimestamp()
assert sqlTimestamp.class.name == 'java.sql.Timestamp'
assert sqlTimestamp.toString() == '2010-08-10 00:00:00.0'
