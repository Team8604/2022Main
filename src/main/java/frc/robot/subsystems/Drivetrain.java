// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonFX leftLeader;
  private WPI_TalonFX rightLeader;
  private WPI_TalonFX[] leftFollowers;
  private WPI_TalonFX[] rightFollowers;
  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;
  private DifferentialDrive drive;

  public Drivetrain() {
    leftLeader = new WPI_TalonFX(Constants.kLeftLeader);
    rightLeader = new WPI_TalonFX(Constants.kRightLeader);

    leftFollowers = new WPI_TalonFX[Constants.kLeftFollowers.length];
    rightFollowers = new WPI_TalonFX[Constants.kRightFollowers.length];

    for(int i = 0;i < Constants.kLeftFollowers.length;i ++){
      leftFollowers[i] = new WPI_TalonFX(Constants.kLeftFollowers[i]);
    }

    for(int i = 0;i < Constants.kRightFollowers.length;i ++){
      rightFollowers[i] = new WPI_TalonFX(Constants.kRightFollowers[i]);
    }

    leftMotors = new SpeedControllerGroup(leftLeader, leftFollowers);
    rightMotors = new SpeedControllerGroup(rightLeader, rightFollowers);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    drive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void periodic() {
    
  }

}
