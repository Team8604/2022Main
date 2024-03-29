// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftTriggerY) - RobotContainer.driverController.getRawAxis(Constants.kRightTriggerY);
    double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.kLeftStickX);//FIXME: These are strange, figure out why they don't work
    rotateSpeed = rotateSpeed * -1;
    
    moveSpeed *= Constants.kDriveModifier;
    rotateSpeed *= Constants.kDriveModifier;

    RobotContainer.drivetrain.arcadeDrive(rotateSpeed, moveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
