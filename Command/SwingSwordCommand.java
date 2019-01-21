package Command;

class SwingSwordCommand implements Command {
    private int _player;
    private int _angle;
    private int _speed;

    public SwingSwordCommand(int player, int angle, int speed) {
        _player = player;
        _angle = angle;
        _speed = speed;
    }

    @Override
    public void execute() {
        VideoGame.swingSword(_player, _angle, _speed);
    }
}