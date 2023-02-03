package frc.robot.Util;

import edu.wpi.first.wpilibj.Timer;

public class EasyTimer {
    double startTime = 0;
    double totalTime = 0;
    boolean isGoing = false;

    public EasyTimer() {

    }

    public void start() {
        startTime = Timer.getFPGATimestamp();
        totalTime = 0;
        isGoing = true;
    }
    public void pause() {
        if (isGoing) {
            isGoing = false;
            totalTime += Timer.getFPGATimestamp() - totalTime;
        }
    }
    public void reset() {
        startTime = Timer.getFPGATimestamp();
        totalTime = 0;
    }
    public void stop() {
        pause();
        reset();
    }
    public double getTime() {
        return totalTime + ((this.isGoing) ? Timer.getFPGATimestamp() - startTime : 0);
    }
}
