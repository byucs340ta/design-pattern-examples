package Command;

class SwingSwordCommand implements Command {
    private Swing _swing;

    public SwingSwordCommand(Swing swing) {
        _swing = swing;
    }

    @Override
    public void execute() {
        System.out.println("Executing Swing Sword Command");
        VideoGame.swingSword(_swing);
    }
}