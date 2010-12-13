def say(msg = 'Hello', name = 'world') {
    "$msg $name!"
}

// We can invoke 3 signatures:
// say(), say(msg), say(msg, name)
assert say() == 'Hello world!'
// Right most parameter with default value is eliminated first.
assert say('Hi') == 'Hi world!'
assert say('Howdy,', 'mrhaki') == 'Howdy, mrhaki!'
