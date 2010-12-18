def sampleText

// Normal ternary operator.
def ternaryOutput = (sampleText != null) ? sampleText : 'Hello Groovy!'
assert ternaryOutput == 'Hello Groovy!'

// The Elvis operator in action. We must read: 'If sampleText is not null assign
// sampleText to elvisOuput, otherwise assign 'Viva Las Vegas!' to elvisOutput.
def elvisOutput = sampleText ?: 'Viva Las Vegas!'
assert elvisOutput == 'Viva Las Vegas!'