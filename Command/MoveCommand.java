package Command;

class MoveCommand implements Command {
    private Location _newLoc;

    public MoveCommand(Location newLoc) {
        _newLoc = newLoc;
    }

    @Override
    public void execute() {
        System.out.println("Executing Move Command");
        VideoGame.move(_newLoc);
    }
}


