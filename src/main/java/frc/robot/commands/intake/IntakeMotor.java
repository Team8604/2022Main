package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeMotor extends CommandBase {

  private double dutyCycle;

  public IntakeMotor(double dutyCycle) {
    addRequirements(RobotContainer.intake);
    this.dutyCycle = dutyCycle;
  }

  @Override
  public void initialize() {
    RobotContainer.intake.setMotor(dutyCycle);
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
