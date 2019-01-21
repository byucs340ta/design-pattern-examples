package Command;

class Location {
    private int _x;
    private int _y;

    public Location(int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public void setX(int x) {
        _x = x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        _y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", _x, _y);
    }
}

