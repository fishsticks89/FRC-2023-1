// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.*;
import frc.robot.Drive.*;
import frc.robot.DriverControl.DriverControl;
import frc.robot.Util.*;

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
  private CANSparkMax two; // issue
  private CANSparkMax three; // counterclockwise
  private CANSparkMax four; // counterclockwise
  private CANSparkMax five; // counterclockwise
  private CANSparkMax six; // clockwise
  private DriveSide left;
  private DriveSide right;
  private DriverControl dControl;
  private PS4Controller con;
  private LogOcc logger = new LogOcc();
  private EasyTimer timer = new EasyTimer();

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
    left = new DriveSide(one, three, two);
    right = new DriveSide(four, five, six);
    this.dControl = new DriverControl(left, right, 4);
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
    System.out.println("deltaTime: " + timer.getTime());
    dControl.tick(con.getLeftY(), con.getRightY());
    
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
