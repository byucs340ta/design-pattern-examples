package Command;

class JumpCommand implements Command {

    public JumpCommand() { }

    @Override
    public void execute() {
        System.out.println("Executing Jump Command");
        VideoGame.jump();
    }
}


