package org.usfirst.frc2783.BasicTankDriveBase.subsystems;

import org.usfirst.frc2783.BasicTankDriveBase.PIDClasses.LeftTankSideOutput;
import org.usfirst.frc2783.BasicTankDriveBase.PIDClasses.LeftTankSideSource;
import org.usfirst.frc2783.BasicTankDriveBase.PIDClasses.RightTankSideOutput;
import org.usfirst.frc2783.BasicTankDriveBase.PIDClasses.RightTankSideSource;
import org.usfirst.frc2783.BasicTankDriveBase.robot.Constants;
import org.usfirst.frc2783.BasicTankDriveBase.PIDClasses.TankPositionOutput;
import org.usfirst.frc2783.BasicTankDriveBase.util.GyroSource;
import org.usfirst.frc2783.BasicTankDriveBase.util.NavSensor;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;

public class TankDriveBase {
	
	// Instantiates the right tank motor controllers
	public VictorSPX rightMaster = new VictorSPX(Constants.kRightDrive1);
	VictorSPX rightSlave = new VictorSPX(Constants.kRightDrive2);

	// Instantiates the left tank motor controllers
	public VictorSPX leftMaster = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX leftSlave = new VictorSPX(Constants.kLeftDrive2);
	
	NavSensor gyro = NavSensor.getInstance();
	
	public static double leftOut;
	public static double rightOut;
	
	public static double rotation;
	
	PIDController posePid;
	TankPositionOutput posePidOut;
	GyroSource posePidSource;
	
	LeftTankSideSource leftPidSource;
	RightTankSideSource rightPidSource;
	LeftTankSideOutput leftSideOut;
	RightTankSideOutput rightSideOut;
	public PIDController leftSideController;
	public PIDController rightSideController;
	
	public TankDriveBase() {
		// Sets the slave motor controllers to follow the masters
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);


		// Sets all drive motors to be in brake mode
		setBrakeMode(true);
		
		//Creates the tank rotation PID controller

		posePidOut = new TankPositionOutput();
		posePidSource = new GyroSource();
		posePid = new PIDController(Constants.kTankPoseP, Constants.kTankPoseI, Constants.kTankPoseD, posePidSource,
				posePidOut);
		posePid.setInputRange(0, 360);
		posePid.setContinuous();

		// Creates the left side PID controller
		leftPidSource = new LeftTankSideSource();
		leftSideOut = new LeftTankSideOutput();
		leftSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,
				leftPidSource, leftSideOut);
		leftSideController.setInputRange(0, 4096);
		leftSideController.setContinuous(true);
		

		// Creates the right side PID controller
		rightPidSource = new RightTankSideSource();
		rightSideOut = new RightTankSideOutput();
		rightSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,rightPidSource, rightSideOut);
		rightSideController.setInputRange(0, 4096);
		rightSideController.setContinuous(false);
	}
	
	/**
	 * Sets Brake Mode based on Boolean you pass in, true = brake
	 */
	public void setBrakeMode(boolean on) {
		if (on) {
			rightMaster.setNeutralMode(NeutralMode.Brake);
			rightSlave.setNeutralMode(NeutralMode.Brake);

			leftMaster.setNeutralMode(NeutralMode.Brake);
			leftSlave.setNeutralMode(NeutralMode.Brake);
		} else {
			rightMaster.setNeutralMode(NeutralMode.Coast);
			rightSlave.setNeutralMode(NeutralMode.Coast);

			leftMaster.setNeutralMode(NeutralMode.Coast);
			leftSlave.setNeutralMode(NeutralMode.Coast);
		}
	}
	
}
