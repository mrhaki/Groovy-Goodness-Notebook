class Size {
    int x, y

    Object getAt(int index) {
        index == 0 ? x : y
    }
}

def (int myX, int myY) = new Size(x: 12, y: 30)
assert myX == 12
assert myY == 30
