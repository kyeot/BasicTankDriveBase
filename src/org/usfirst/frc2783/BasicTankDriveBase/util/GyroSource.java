package org.usfirst.frc2783.BasicTankDriveBase.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroSource implements PIDSource {
	PIDSourceType sourceType;
	
	public GyroSource() {
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
		return NavSensor.getInstance().getAngle(false);
	}
	
}