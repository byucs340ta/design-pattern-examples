package Command;

class VideoGame {

    private static VideoGame _instance = new VideoGame();

    public static void move(Location newLoc) {
        _instance._move(newLoc);
    }

    public static void jump() {
        _instance._jump();
    }

    public static void raiseShield() {
        _instance._raiseShield();
    }

    public static void swingSword(Swing swing) {
        _instance._swingSword(swing);
    }


    private VideoGame() { }

    private void _move(Location newLoc) {
        System.out.println(String.format("You moved to %s", newLoc));
    }

    private void _jump() {
        System.out.println("You jumped");
    }

    private void _raiseShield() {
        System.out.println("You raised their shield");
    }

    private void _swingSword(Swing swing) {
        System.out.println(String.format(
                "You swung your sword at angle %d with speed %d", swing.getAngle(), swing.getSpeed()));
    }
}
