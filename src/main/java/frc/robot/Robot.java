// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.*;
import frc.robot.Drive.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the manifest
 * file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private CANSparkMax one; // counterclockwise
  private CANSparkMax two; // counterclockwise
  private CANSparkMax three; // clockwise
  private CANSparkMax four; // counterclockwise
  private CANSparkMax five; // counterclockwise
  private CANSparkMax six; // clockwise
  private DriveSide right;
  private DriveSide left;
  private PS4Controller con;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    this.one = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.two = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.three = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.four = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.five = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);
    this.six = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    right = new DriveSide(one, two, three); 
    left = new DriveSide(four, five, six);
    con = new PS4Controller(0);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    // three.setVoltage(2);
    right.set_power(con.getRightY());
    left.set_power(con.getLeftY());
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}
