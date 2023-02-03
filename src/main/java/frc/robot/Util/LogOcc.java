package frc.robot.Util;

public class LogOcc {
    final int max_ticks = 300;
    int ticks = max_ticks;

    public void tick(String text) {
        if (ticks >= max_ticks) {
            ticks = 0;
            System.out.println(text);
        }
        ticks++;
    }
}
