package frc.robot.commands.balltunnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class BallTunnelMotor extends CommandBase {

  private double dutyCycle;

  public BallTunnelMotor(double dutyCycle) {
    addRequirements(RobotContainer.ballTunnel);
    this.dutyCycle = dutyCycle;
  }

  @Override
  public void initialize() {
    RobotContainer.ballTunnel.setSpeed(dutyCycle);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
