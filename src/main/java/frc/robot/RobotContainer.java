package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystems.*;
import frc.robot.commands.drive.DriveArcade;

public class RobotContainer {

  public static Joystick driverController = new Joystick(0);

  public static Drivetrain drivetrain = new Drivetrain();
  public static Intake intake = new Intake();
  public static BallTunnel ballTunnel = new BallTunnel();
  public static Shooter shooter = new Shooter();

  public RobotContainer() {
    configureButtonBindings();
    drivetrain.setDefaultCommand(new DriveArcade());
  }


  private void configureButtonBindings() {

  }

  
  public Command getAutonomousCommand() {
    return null;
  }
}
