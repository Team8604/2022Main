package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Intake extends SubsystemBase {

  private WPI_TalonFX intakeMotor;
  private DoubleSolenoid intakeSolenoid;

  public Intake() {
    intakeSolenoid = new DoubleSolenoid(Constants.kPCM, Constants.kIntakeSolenoidExtend,
        Constants.kIntakeSolenoidRetract);
    intakeMotor = new WPI_TalonFX(Constants.kIntakeMotor);
  }

  @Override
  public void periodic() {
  }

  public void setMotor(double speed) {
    intakeMotor.set(speed);
  }

  public void setSolenoid(boolean extended) {
    if (extended) {
      intakeSolenoid.set(Value.kForward);

    } else {
      intakeSolenoid.set(Value.kReverse);
    }
  }

  public boolean getSolenoid() {
    if (intakeSolenoid.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }
  }
}
