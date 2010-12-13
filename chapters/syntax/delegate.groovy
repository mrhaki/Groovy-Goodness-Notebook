class SimpleEvent {
    @Delegate Date when
    @Delegate List<String> attendees = []
    int maxAttendees = 0
    String description

    boolean add(Object value) {
        if (attendees.size() < maxAttendees) {
            return attendees.add(value)
        } else {
            throw new IllegalArgumentException("Maximum of ${maxAttendees} attendees exceeded.")
        }
    }

}

def event = new SimpleEvent(when: new Date() + 7, description: 'Small Groovy seminar', maxAttendees: 2)

assert event.size() == 0  // Delegate to List.size()
assert event.after(new Date())  // Delegate to Date.after()
assert event.description == 'Small Groovy seminar'
assert event.maxAttendees == 2

event << 'mrhaki' << 'student1'  // Delegate to List.leftShift()
assert event.size() == 2
assert event[0] == 'mrhaki'

event -= 'student1'  // Delegate to List.minus()
assert event.size() == 1

event = new SimpleEvent(when: new Date() + 7, description: 'Small Groovy seminar', maxAttendees: 2)
event << 'mrhaki' << 'student1'

try {
    event << 'three is a crowd.'
    assert false
} catch (IllegalArgumentException e) {
    assert e.message == 'Maximum of 2 attendees exceeded.'
}
