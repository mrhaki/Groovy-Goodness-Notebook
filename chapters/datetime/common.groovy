// Date.parse() to convert String to Date.
date = new Date().parse('yyyy/MM/dd', '1973/07/09')

// We can use [] or getAt() to get date fields.
assert date[Calendar.YEAR] == 1973
assert date[Calendar.MONTH] == 6
assert date.getAt(Calendar.DATE) == 9

dateNext = date.clone()
datePrevious = date.clone()

// We can use the + and - operators to add or
// subtract days.
nextDay = date + 1  // Or date.plus(1)
previousDay = date - 1  // Or date.minus(1)

// ++ operator to move one day ahead.
dateNext++  // Or dateNext.next()
assert dateNext == nextDay

// -- operator to move one day back.
datePrevious--  // Or datePrevious.previous()
assert datePrevious == previousDay

otherDate = new Date().parse('yyyy/MM/dd', '1973/07/21')
// Dates can be used in ranges.
assert (otherDate..<date).size() == 12

// Set Locale to assert date formatting.
Locale.setDefault(Locale.US)

// Date.format() uses java.text.SimpleDateFormat.
assert date.format("d MMMM, yyyy") == '9 July, 1973'
assert date.getDateString() == '7/9/73'
