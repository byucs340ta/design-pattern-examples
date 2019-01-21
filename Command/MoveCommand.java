package Command;

class MoveCommand implements Command {
    private int _player;
    private Location _newLoc;

    public MoveCommand(int player, Location newLoc) {
        _player = player;
        _newLoc = newLoc;
    }

    @Override
    public void execute() {
        VideoGame.move(_player, _newLoc);
    }
}


