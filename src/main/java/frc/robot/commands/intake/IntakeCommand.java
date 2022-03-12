package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class IntakeCommand extends SequentialCommandGroup {

  public IntakeCommand(boolean extended) {
    addCommands(new IntakeMotor(extended ? Constants.kIntakeMotorSpeed : 0), new IntakeSolenoid(extended));
  }
}
