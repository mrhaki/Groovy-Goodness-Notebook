// For non-existing methods we can use << or =
// to define the method.
Integer.metaClass.eights << { delegate * 8 }
Integer.metaClass.hundreds = { delegate * 100 }
assert 4.eights() == 32
assert 2.hundreds() == 200

try {
    Integer.metaClass.toString << { 'Groovy' } // Cannot use << for existing method.
    assert false
} catch (e) {
    assert e.message == 'Cannot add new method [toString] for arguments [[]]. It already exists!'
}

// For an existing method we must = to define new implementation.
Integer.metaClass.toString = { 'Groovy' }
assert 100.toString() == 'Groovy'
