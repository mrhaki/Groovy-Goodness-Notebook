import groovy.transform.IndexedProperty

class Group {
    String name
    List members = []
}

class IndexedGroup {
    String name
    @IndexedProperty List members = []
}

def group = new Group(name: 'Groovy')
group.members[0] = 'mrhaki'
group.members[1] = 'Hubert'
assert group.members.size() == 2
assert group.members == ['mrhaki', 'Hubert']

try {
    group.setMembers(0, 'hubert') // Not index property
} catch (MissingMethodException e) {
    assert e
}

def indexedGroup = new IndexedGroup(name: 'Grails')
indexedGroup.members[0] = 'mrhaki'
indexedGroup.setMembers 1, 'Hubert'
assert indexedGroup.members.size() == 2
assert indexedGroup.getMembers(0) == 'mrhaki'
assert indexedGroup.members[1] == 'Hubert'
