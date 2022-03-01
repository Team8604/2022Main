package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class Shooter extends SubsystemBase {

  private WPI_TalonFX leader;
  private WPI_TalonFX follower;

  public Shooter() {
    leader = new WPI_TalonFX(Constants.kShooterMotorLeader);
    follower = new WPI_TalonFX(Constants.kShooterMotorFollower);

    leader.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, Constants.kDriveCurrentLimitContinuous,
    Constants.kDriveCurrentLimitPeak, Constants.kDriveCurrentLimitTime));
    follower.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, Constants.kDriveCurrentLimitContinuous,
    Constants.kDriveCurrentLimitPeak, Constants.kDriveCurrentLimitTime));

    follower.follow(leader);
    leader.configFactoryDefault();
    leader.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, Constants.kPIDLoopIdx,
        Constants.kTimeoutsMs);
    leader.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocity_kF, Constants.kTimeoutsMs);
    leader.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocity_kP, Constants.kTimeoutsMs);
    leader.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocity_kI, Constants.kTimeoutsMs);
    leader.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocity_kD, Constants.kTimeoutsMs);
  }

  @Override
  public void periodic() {
    
  }

  public void setMotorRaw(double dutyCycle){
    leader.set(TalonFXControlMode.PercentOutput, dutyCycle);
  }

  public void setMotorPID(double speedRPM) {
    follower.set(TalonFXControlMode.Velocity, speedRPM * Constants.kRPM2Ticks);
  }
}
