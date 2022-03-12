package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeSolenoid extends CommandBase {

  private boolean extend;

  public IntakeSolenoid(boolean extend) {
    addRequirements(RobotContainer.intake);
    this.extend = extend;
  }

  @Override
  public void initialize() {
    if(RobotContainer.intake.getSolenoid() != extend){
      RobotContainer.intake.setSolenoid(extend);
    }
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
