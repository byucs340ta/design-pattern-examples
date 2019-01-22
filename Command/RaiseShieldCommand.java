package Command;

class RaiseShieldCommand implements Command {

    public RaiseShieldCommand() {}

    @Override
    public void execute() {
        System.out.println("Executing Raise Shield Command");
        VideoGame.raiseShield();
    }
}


