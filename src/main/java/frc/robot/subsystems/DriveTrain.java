// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArcadeDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  /* private CANSPARKMAX rf;
  private CANSPARKMAX lf;
  private CANSPARKMAX rb;
  private CANSPARKMAX lb; */

  private static final CANSparkMax lf = new CANSparkMax(2, MotorType.kBrushless); // double check IDS
  private static final CANSparkMax lb = new CANSparkMax(4, MotorType.kBrushless);
  private static final CANSparkMax rf = new CANSparkMax(3, MotorType.kBrushless);
  private static final CANSparkMax rb = new CANSparkMax(1, MotorType.kBrushless);

  private static DriveTrain mDriveTrain;

  public DriveTrain() {
    /* lb.follow(lf);
    lf.setInverted(true);
    rb.follow(rf); */
    
  }

  public static DriveTrain getInstance(){
    if (mDriveTrain==null){
      mDriveTrain = new DriveTrain();
    }
    return mDriveTrain;
  }

  public void initDefaultCommand(XboxController driverController) {
    setDefaultCommand(new ArcadeDrive(
      () -> driverController.getRightY(), 
      () -> driverController.getLeftY()
    ));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotorSpeed(double left, double right) {
    // lf.set(left);
    rf.set(right);
    rb.set(right);
  }
}
