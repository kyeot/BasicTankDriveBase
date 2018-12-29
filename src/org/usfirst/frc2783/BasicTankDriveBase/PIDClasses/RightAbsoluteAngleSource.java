package org.usfirst.frc2783.BasicTankDriveBase.PIDClasses;

import org.usfirst.frc2783.BasicTankDriveBase.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class RightAbsoluteAngleSource implements PIDSource {
	PIDSourceType sourceType;

	public RightAbsoluteAngleSource() {
		setPIDSourceType(PIDSourceType.kDisplacement);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		sourceType = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return sourceType;
	}

	@Override
	public double pidGet() {
		return (Robot.rightCounter.getRotations() * 4096) + Robot.leftAbsEnc.getValue();
	}		
}
