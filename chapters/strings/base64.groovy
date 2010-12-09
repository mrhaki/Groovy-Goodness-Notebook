def s = 'Argh, Groovy you say, mate?'

// Encode.
String encoded = s.bytes.encodeBase64().toString()
assert encoded == 'QXJnaCwgR3Jvb3Z5IHlvdSBzYXksIG1hdGU/'

// And decode.
byte[] decoded = encoded.decodeBase64()
assert new String(decoded) == s
