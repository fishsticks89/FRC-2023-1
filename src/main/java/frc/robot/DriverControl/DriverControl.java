package frc.robot.DriverControl;

import frc.robot.Drive.*;
import frc.robot.Util.*;

public class DriverControl {
    DriveSide m_left;
    DriveSide m_right;
    double deadzone;
    LogOcc logger = new LogOcc();

    public DriverControl(DriveSide left, DriveSide right, double deadzone) {
        this.m_left = left;
        this.m_right = right;
        this.deadzone = deadzone;
    }

    /**
     * 
     * @param input     [-100, 100]
     * @param intensity [0, 20]
     * @return [-100, 100]
     */
    public static double curve(double input, double intensity) {
        return Math.exp((Math.abs(input) - 100) * intensity / 1000) * input;
    }

    /**
     * 
     * @param leftpwr  [-1, 1]
     * @param rightpwr [-1, 1]
     */
    public void tick(double leftpwr, double rightpwr) {
        if (Math.abs(leftpwr) * 100 < deadzone && Math.abs(rightpwr) < deadzone) {
            m_left.set_power(0);
            m_right.set_power(0);
        }
        double pwr = curve(((leftpwr + rightpwr) / 2) * 100, 5); // range -100 to 100
        double turn = curve((leftpwr - rightpwr) * 100, 7); // range -100 to 100
        m_left.set_power(-(pwr + turn));
        m_right.set_power(pwr - turn);
        logger.tick((-(pwr + turn)) + " - " + (pwr - turn));
    }
}
