// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LimelightTurn extends CommandBase {

  private int goodFrameCounter = 0;

  public LimelightTurn() {
    addRequirements(RobotContainer.drivetrain);//Interrupts DriveArcade command
    //Since DriveArcade is the default command, when this command finishes it will automatically resume.
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    //NetworkTableEntry ty = table.getEntry("ty");//Not needed now, might eventually be used
    NetworkTableEntry tv = table.getEntry("tv");
    //TODO: Look into moving some of this to initialize(), it seems like a lot of wasting computation.
    //It's like this because that's how we did it last year

    double x = tx.getDouble(0.0);
    //double y = ty.getDouble(0.0);
    double v = tv.getDouble(0.0);

    if(v != 0.0){
      double turnAmount = Constants.kLimeLightTurn_kP * x;
      if(Math.abs(turnAmount) < Constants.kMinRotateSpeed){
        turnAmount = Math.copySign(Constants.kMinRotateSpeed, turnAmount);
      }
      System.out.println(turnAmount);
      RobotContainer.drivetrain.arcadeDrive(0, turnAmount);
      if(x > -Constants.kMaxLimeLightDelta && x < Constants.kMaxLimeLightDelta){
        goodFrameCounter++;
      } else{
        goodFrameCounter = 0;
      }
    } else {
      goodFrameCounter = Constants.kRequiredLimeLightGoodFrames;//Dirty little hack to immediately finish.
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return goodFrameCounter > Constants.kRequiredLimeLightGoodFrames;
  }
}
