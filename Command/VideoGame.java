package Command;

class VideoGame {

    private static VideoGame _instance = new VideoGame();

    public static void move(int player, Location newLoc) {
        _instance._move(player, newLoc);
    }

    public static void jump(int player) {
        _instance._jump(player);
    }

    public static void raiseShield(int player) {
        _instance._raiseShield(player);
    }

    public static void swingSword(int player, int angle, int speed) {
        _instance._swingSword(player, angle, speed);
    }


    private VideoGame() { }

    private void _move(int player, Location newLoc) {
        System.out.println(String.format("Player %d moved to %s", player, newLoc));
    }

    private void _jump(int player) {
        System.out.println(String.format("Player %d jumped", player));
    }

    private void _raiseShield(int player) {
        System.out.println(String.format("Player %d raised their sheild", player));
    }

    private void _swingSword(int player, int angle, int speed) {
        System.out.println(String.format(
                "Player %d swung their sword at angle %d with speed %d", player, angle, speed));
    }
}
