package org.usfirst.frc2783.BasicTankDriveBase.PIDClasses;

import org.usfirst.frc2783.BasicTankDriveBase.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class LeftTankSideSource implements PIDSource {
	PIDSourceType sourceType;

	public LeftTankSideSource() {
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
		return Robot.leftAbsEnc.getValue();
	}
}
