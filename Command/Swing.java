package Command;

public class Swing {
    private int _angle;
    private int _speed;

    public Swing(int angle, int speed) {
        _speed = speed;
        _angle = angle;
    }

    public int getAngle() {
        return _angle;
    }

    public int getSpeed() {
        return _speed;
    }

    public String toString() {
        return String.format("Angle: %d Speed: %d", _angle, _speed);
    }
}
