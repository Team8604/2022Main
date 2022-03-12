package frc.robot.commands.balltunnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class BallTunnelIntaking extends CommandBase {

  private boolean lastSensorState;
  private int triggeredFrames;

  public BallTunnelIntaking() {
    addRequirements(RobotContainer.ballTunnel);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    boolean currentSensorState = RobotContainer.ballTunnel.readSensorState();
    if(currentSensorState){
      if(lastSensorState){
        //Rising edge, the ball was not present last frame but is present this frame.
      }
    } else {

    }

    lastSensorState = currentSensorState;
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}