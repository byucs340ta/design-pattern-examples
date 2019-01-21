package Command;

class RaiseShieldCommand implements Command {
    private int _player;

    public RaiseShieldCommand(int player) {
        _player = player;
    }

    @Override
    public void execute() {
        VideoGame.raiseShield(_player);
    }
}


