package Command;

class JumpCommand implements Command {
    private int _player;

    public JumpCommand(int player) {
        _player = player;
    }

    @Override
    public void execute() {
        VideoGame.jump(_player);
    }
}


