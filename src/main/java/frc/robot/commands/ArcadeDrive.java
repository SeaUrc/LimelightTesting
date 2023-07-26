// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import java.lang.Math;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain mDriveTrain;
  private final DoubleSupplier stickXSupplier, stickYSupplier;
  /**
   *
   * @param DriveTrain
   */
  public ArcadeDrive(DoubleSupplier leftY, DoubleSupplier rightX) {
    stickYSupplier = leftY;
    stickXSupplier = rightX;
    mDriveTrain = DriveTrain.getInstance();
    addRequirements(mDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /* double l = 0, r = 0;
    if (stickXSupplier.getAsDouble() > 0.05 && stickYSupplier.getAsDouble() > 0.05){
      l += stickYSupplier.getAsDouble(); r += stickYSupplier.getAsDouble();
      l += stickXSupplier.getAsDouble();
    }
    // double maxVal = Math.max(l, r);
    SmartDashboard.putNumber("L: ", l);
    SmartDashboard.putNumber("R: ", r);

    //System.out.println(l + " " + r);
    mDriveTrain.setMotorSpeed(l, r); */
    mDriveTrain.setMotorSpeed(stickYSupplier.getAsDouble(), stickXSupplier.getAsDouble());
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDriveTrain.setMotorSpeed(0, 0);
  }

  // Returns true when the command should end.
  /* @Override
  public boolean isFinished() {
    return false;
  } */
}
