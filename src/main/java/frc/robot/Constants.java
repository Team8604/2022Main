// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    //CAN IDs
    public static final int kRightLeader = 0;
    public static final int[] kRightFollowers = { 1 };
    public static final int kLeftLeader = 2;
    public static final int[] kLeftFollowers = { 3 };
    public static final int kShooterMotorLeader = 6;
    public static final int kShooterMotorFollower = 7;
    public static final int kBallMotor = 5;
    public static final int kIntakeMotor = 8;

    //PID
    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs = 0;
    public static final int kTimeoutsMs = 0;
    public static final double kGains_Velocity_kP = .39;
    public static final double kGains_Velocity_kI = 0;
    public static final double kGains_Velocity_kD = 1;
    public static final double kGains_Velocity_kF = .057;
    public static final double kLimeLightTurn_kP = 0.029; //1/27, so max turn at limelight edge of view is 0.037037....

    //Sensors
    public static final int kBallSensorLowerLeft = 0;
    public static final int kBallSensorLowerRight = 1;
    public static final int kSensorDebounce = 3;

    //Pneumatics
    public static final PneumaticsModuleType kPCM = PneumaticsModuleType.CTREPCM;//TODO: Find correct PCM tpye
    public static final int kIntakeSolenoidExtend = 0;
    public static final int kIntakeSolenoidRetract = 1;

    //Speeds but not feeds
    public static final double kDriveModifier = 0.40;
    public static final double kBallTunnelMotorSpeed = 0.25;
    public static final double kIntakeMotorSpeed = 0.25;

    // Current limits
    public static final double kHDriveCurrentLimit = 35;
    public static final double kHDriveCurrentLimitTime = 0.4;
    public static final double kDriveCurrentLimitPeak = 45;
    public static final double kDriveCurrentLimitContinuous = 40;
    public static final double kDriveCurrentLimitTime = 0.4;
    public static final double kDrivePowerRatioDuringAuto = 0.3;    

    //Auto constants (NOT PID)
    public static final int kRequiredLimeLightGoodFrames = 15;
    public static final double kMaxLimeLightDelta = 1;
    public static final double kMinRotateSpeed = 0.29;

    //Conversions
    public static final double kRPM2Ticks = 2048 / (10 * 60);//TODO: This was copied from last year, probably isn't accurate

    // Button IDs
    public static final int kButtonA = 1;
    public static final int kButtonB = 2;
    public static final int kButtonX = 3;
    public static final int kButtonY = 4;
    public static final int kBumperL = 5;
    public static final int kBumperR = 6;

    public static final int kLeftStickX = 0;
    public static final int kLeftStickY = 1;
    public static final int kRightStickX = 4;
    public static final int kRightStickY = 5;
    public static final int kLeftTriggerY = 2;
    public static final int kRightTriggerY = 3;



    public static final int kButton1 = 1;
    public static final int kButton2 = 2;
    public static final int kButton3 = 3;
    public static final int kButton4 = 4;
}
